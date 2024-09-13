package com.example.turistguidedel2.Repository;

import org.springframework.stereotype.Repository;
import com.example.turistguidedel2.Model.TouristAttraction;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    // this is a list of tourist attractions that will be used to store the tourist attractions
    private  ArrayList<TouristAttraction> touristAttractions = new ArrayList<>(); //Using a map (name, desc) could be beneficial.

    //trying to implitment the CRUD operations as i understand them:

    public TouristRepository() {
        populateAttractions();
    }

    private void populateAttractions() {
        touristAttractions.add(new TouristAttraction("Den Blå Plant", "En masse fisk"));
        touristAttractions.add(new TouristAttraction("Tivoli", "Forlystelsespark midt i København"));
        touristAttractions.add(new TouristAttraction("Rundetårn", "En rund bygning"));
    }

    //create. add a tourist attraction to the list
    public void addTouristAttraction(TouristAttraction attraction){
        touristAttractions.add(attraction);
    }

    //read. simply return the list of tourist attractions and print them out
    public List<TouristAttraction> getAllTouristAttractions() {
        return new ArrayList<>(touristAttractions);
    }

    //update. find the tourist attraction by name and update the description of it to the new description given in the parameters
    public void updateTouristAttraction(String name, String newDesc){
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equals(name)) {
                attraction.setDescription(newDesc);
            }
        }
    }
    //delete. simply remove the object at the index given
    public void deleteTouristAttraction(int index){
        if (index < 0 || index >= touristAttractions.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        touristAttractions.remove(index);
    }
        //get name. get tourist attraction by name and return it if it exists in the list of tourist attractions
    public TouristAttraction getTouristAttractionByName(String name){
        for (TouristAttraction attraction : touristAttractions) {
            if (attraction.getName().equals(name)) {
                return attraction;
            }
        }
        return null;
    }



}


