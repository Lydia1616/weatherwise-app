package com.example;

public class PlaceInfo {

    private final int    id;
    private final String cityKey;
    private final String name;
    private final String category;   // Park, Museum, Cafe, Temple, Market...
    private final String placeType;  // INDOOR or OUTDOOR
    private final int    popularity; // 1-100

    public PlaceInfo(int id, String cityKey, String name,
                     String category, String placeType, int popularity) {
        this.id         = id;
        this.cityKey    = cityKey;
        this.name       = name;
        this.category   = category;
        this.placeType  = placeType;
        this.popularity = popularity;
    }

    public int    getId()         { return id;         }
    public String getCityKey()    { return cityKey;    }
    public String getName()       { return name;       }
    public String getCategory()   { return category;   }
    public String getPlaceType()  { return placeType;  }
    public int    getPopularity() { return popularity; }

    public boolean isIndoor() { return "INDOOR".equalsIgnoreCase(placeType); }
}