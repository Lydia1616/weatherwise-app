package com.example;
import java.util.List;
public class SearchModule 
{

    private final DatabaseManager db = new DatabaseManager();

    public void search(String keyword) 
    {
        keyword = keyword.trim();
        if (keyword.isBlank()) 
        {
            System.out.println("  Please enter a keyword.");
            return;
        }
        System.out.println("\n  Search Results for: \"" + keyword + "\"");
        System.out.println("  ─────────────────────────────────────────");

        List<PlaceInfo> results = db.searchPlaces(keyword);

        if (results.isEmpty())
        {
            System.out.println("  No results found for \"" + keyword + "\".");
            System.out.println("  Try: temple, waterfall, park, museum, market, nature");
        }
        else 
        {
            int i = 1;
            for (PlaceInfo p : results) 
            {
                System.out.printf("  %2d. %-35s [%s] [%s] — %s%n",i++, p.getName(), p.getCategory(), p.getPlaceType(), p.getCityKey());
            }
        }
        System.out.println("  ─────────────────────────────────────────");
    }
}