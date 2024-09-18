package com.example.turistguidedel2.Model;

import java.util.ArrayList;

public class 'TouristAttraction {
    private String name;
    private String description;
    private String city;
    private ArrayList<String> tags ;

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public ArrayList<String> getTags() {
        return tags;
    }

    public TouristAttraction(){

    }

    //constructor
    public TouristAttraction(String name, String description, String city, ArrayList<String> tags) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.tags = tags;
    }
}