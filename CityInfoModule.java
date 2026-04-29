package com.example;

import java.util.List;

public class CityInfoModule 
{

    private final DatabaseManager db = new DatabaseManager();

    public CityInfo getCityInfo(String cityKey) 
    {
        return db.getCity(cityKey);
    }

    public List<PlaceInfo> getPlacesForCity(String cityKey) 
    {
        return db.getPlaces(cityKey);
    }

    public void displayCityInfo(String cityKey) 
    {
        CityInfo info = getCityInfo(cityKey);
        if (info == null) {
            System.out.println("  City not found: " + cityKey);
            System.out.println("  Available: dehradun, mussoorie, rishikesh, haridwar");
            return;
        }
        System.out.println("\n    City: " + info.getName());
        System.out.println("  ─────────────────────────────────────────");
        System.out.println("    Location : " + info.getCountryState());
        System.out.println("    About    : " + info.getDescription());
        System.out.println("  ─────────────────────────────────────────");
    }
}