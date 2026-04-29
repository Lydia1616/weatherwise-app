package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseManager {

    private final Map<String, CityInfo> cityMap = new HashMap<>();
    private final List<PlaceInfo> allPlaces = new ArrayList<>();

    public DatabaseManager() {
        loadMockData();
    }

    private void loadMockData() {
        // ── Add Cities ────────────────────────────────────────
        cityMap.put("dehradun", new CityInfo("dehradun", "Dehradun", "India (UK)", "Capital of Uttarakhand in the Doon Valley."));
        cityMap.put("mussoorie", new CityInfo("mussoorie", "Mussoorie", "India (UK)", "Queen of Hills, ~35 km from Dehradun."));
        cityMap.put("rishikesh", new CityInfo("rishikesh", "Rishikesh", "India (UK)", "Yoga Capital of the World on the Ganga."));

        // ── Add Places (ID, CityKey, Name, Category, Type, Popularity) ──
        allPlaces.add(new PlaceInfo(1, "dehradun", "Robber's Cave", "Nature", "OUTDOOR", 85));
        allPlaces.add(new PlaceInfo(2, "dehradun", "Forest Research Institute", "Museum", "INDOOR", 90));
        allPlaces.add(new PlaceInfo(3, "dehradun", "Paltan Bazaar", "Market", "INDOOR", 70));
        allPlaces.add(new PlaceInfo(4, "dehradun", "Tapkeshwar Temple", "Temple", "OUTDOOR", 78));
        
        allPlaces.add(new PlaceInfo(5, "mussoorie", "Kempty Falls", "Nature", "OUTDOOR", 88));
        allPlaces.add(new PlaceInfo(6, "mussoorie", "Mall Road", "Market", "OUTDOOR", 85));
        
        allPlaces.add(new PlaceInfo(7, "rishikesh", "Lakshman Jhula", "Landmark", "OUTDOOR", 90));
        allPlaces.add(new PlaceInfo(8, "rishikesh", "Beatles Ashram", "Museum", "INDOOR", 78));
    }

    public CityInfo getCity(String cityKey) {
        return cityMap.get(cityKey.toLowerCase().trim());
    }

    public List<PlaceInfo> getPlaces(String cityKey) {
        String key = cityKey.toLowerCase().trim();
        List<PlaceInfo> result = new ArrayList<>();
        for (PlaceInfo p : allPlaces) {
            if (p.getCityKey().equals(key)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<PlaceInfo> searchPlaces(String keyword) {
        String k = keyword.toLowerCase().trim();
        List<PlaceInfo> result = new ArrayList<>();
        for (PlaceInfo p : allPlaces) {
            if (p.getName().toLowerCase().contains(k) || p.getCategory().toLowerCase().contains(k)) {
                result.add(p);
            }
        }
        return result;
    }
}