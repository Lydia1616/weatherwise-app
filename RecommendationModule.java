package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RecommendationModule {

    private final DatabaseManager db = new DatabaseManager();
    private final WeatherModule weatherModule = new WeatherModule();

    public List<PlaceInfo> recommend(String cityKey) {

        // 1. Get places
        List<PlaceInfo> places = db.getPlaces(cityKey);

        if (places == null || places.isEmpty()) {
            return new ArrayList<>();
        }

        // 2. Get weather safely
        WeatherData weather = weatherModule.fetchWeather(cityKey);

        // FIX: make it effectively final for lambda
        final WeatherData safeWeather = (weather != null)
                ? weather
                : new WeatherData(cityKey, "Clear", "default", 25.0, 60, 5.0);

        // 3. Copy list
        List<PlaceInfo> sorted = new ArrayList<>(places);

        // 4. Sort using safeWeather (FIXED)
        sorted.sort(
                Comparator.comparingInt((PlaceInfo p) -> score(p, safeWeather))
                          .reversed()
        );

        return sorted;
    }

    private int score(PlaceInfo p, WeatherData w) {

        int score = p.getPopularity();

        // Weather logic
        String condition = (w.getCondition() == null)
                ? ""
                : w.getCondition().toLowerCase();

        if (condition.contains("rain") && p.isIndoor()) {
            score += 20;
        }

        if (condition.contains("clear") && !p.isIndoor()) {
            score += 15;
        }

        // Nature boost
        if (p.getCategory() != null &&
            p.getCategory().equalsIgnoreCase("Nature")) {
            score += 10;
        }

        return score;
    }
}