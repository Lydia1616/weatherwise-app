package com.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WeatherModule {

    private static final String GEO_URL =
            "https://geocoding-api.open-meteo.com/v1/search?count=1&language=en&format=json&name=";

    public WeatherData fetchWeather(String cityName) {

        try {
            double[] coords = geocode(cityName);
            if (coords == null) return null;

            String apiUrl =
                    "https://api.open-meteo.com/v1/forecast?latitude=" + coords[0]
                    + "&longitude=" + coords[1]
                    + "&current_weather=true"
                    + "&hourly=relative_humidity_2m"
                    + "&timezone=auto";

            JSONObject json = getJson(apiUrl);
            if (json == null || !json.has("current_weather")) return null;

            JSONObject current = json.getJSONObject("current_weather");

            String[] info = mapCode(current.optInt("weathercode", 0));

            return new WeatherData(
                    cityName,
                    info[0],
                    info[1],
                    current.optDouble("temperature", 0),
                    extractHumidity(json),
                    current.optDouble("windspeed", 0)
            );

        } catch (Exception e) {
            return null;
        }
    }

    public void displayWeather(String cityName) {

        System.out.println("\nFetching live weather for " + cityName + "...");

        WeatherData d = fetchWeather(cityName);

        if (d == null) {
            System.out.println("Could not fetch weather. Check internet or API.");
            return;
        }

        System.out.println("\n--- LIVE WEATHER: " + d.getCityName().toUpperCase() + " ---");
        System.out.println("Condition   : " + d.getCondition() + " (" + d.getDescription() + ")");
        System.out.println("Temperature : " + d.getTemperature() + " °C");
        System.out.println("Humidity    : " + d.getHumidity() + "%");
        System.out.println("Wind Speed  : " + d.getWindSpeed() + " km/h");
        System.out.println("-".repeat(40));
    }

    private double[] geocode(String name) throws Exception {

        JSONObject geo = getJson(GEO_URL +
                URLEncoder.encode(name, StandardCharsets.UTF_8));

        if (geo == null || !geo.has("results")) return null;

        JSONArray results = geo.getJSONArray("results");
        if (results.length() == 0) return null;

        JSONObject r = results.getJSONObject(0);

        return new double[]{
                r.optDouble("latitude", 0),
                r.optDouble("longitude", 0)
        };
    }

    private JSONObject getJson(String urlStr) throws Exception {

    	URL url = URI.create(urlStr).toURL();
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        if (conn.getResponseCode() != 200) return null;

        try (BufferedReader br =
                     new BufferedReader(new InputStreamReader(conn.getInputStream()))) {

            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            return new JSONObject(sb.toString());
        }
    }

    private int extractHumidity(JSONObject json) {

        try {
            if (!json.has("hourly")) return 0;

            JSONObject hourly = json.getJSONObject("hourly");

            JSONArray times = hourly.getJSONArray("time");
            JSONArray hums = hourly.getJSONArray("relative_humidity_2m");

            if (times.length() == 0 || hums.length() == 0) return 0;

            // safer fallback: use last available value (more reliable than string matching)
            return hums.getInt(hums.length() - 1);

        } catch (Exception e) {
            return 0;
        }
    }

    private String[] mapCode(int code) {

        if (code == 0) return new String[]{"Clear", "clear sky"};
        if (code <= 3) return new String[]{"Cloudy", "partly cloudy"};
        if (code >= 95) return new String[]{"Storm", "thunderstorm"};
        if (code >= 51) return new String[]{"Rain", "rainy weather"};

        return new String[]{"Fair", "stable conditions"};
    }
}