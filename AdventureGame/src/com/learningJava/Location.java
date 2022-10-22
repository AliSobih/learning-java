package com.learningJava;

/**
 * Created by Ali Fathy on 6/1/2022
 */


import java.util.HashMap;
import java.util.Map;

public class Location {
    // variables
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    // constructor
    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null){
            this.exits = new HashMap<>(exits);

        }else {
            this.exits = new HashMap<>();
        }
        this.exits.put("Q", 0);
    }

    // getters
    public int getLocationID() {
        return locationID;
    }//end getter

    public String getDescription() {
        return description;
    }//end getter

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }//end getter
}
