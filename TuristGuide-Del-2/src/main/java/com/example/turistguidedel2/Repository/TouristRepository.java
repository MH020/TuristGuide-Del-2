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
        ArrayList<String> tags = new ArrayList<String>();
        tags.add("Historical");
        tags.add("Museum");
        tags.add("Art");
        tags.add("Culture");
        tags.add("Sightseeing");
        tags.add("Nature");
        TouristAttraction attraction1 = new TouristAttraction("The Louvre", "The Louvre is the world's largest art museum and a historic monument in Paris, France.", "Paris", tags);
        touristAttractions.add(attraction1);
        TouristAttraction attraction2 = new TouristAttraction("Eiffel Tower", "The Eiffel Tower is a wrought-iron lattice tower on the Champ de Mars in Paris, France.", "Paris", tags);
        touristAttractions.add(attraction2);
        TouristAttraction attraction3 = new TouristAttraction("Big Ben", "Big Ben is the nickname for the Great Bell of the clock at the north end of the Palace of Westminster in London, England.", "London", tags);
        touristAttractions.add(attraction3);
        TouristAttraction attraction4 = new TouristAttraction("Tivoli", "test.", "London", tags);
        touristAttractions.add(attraction4);
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

public void saveTouristAttractions(List<TouristAttraction> touristAttractions){
    this.touristAttractions.addAll(touristAttractions);
    for (TouristAttraction attraction : touristAttractions) {
        if (attraction.getName().equals(name)) {
            return attraction;
        }
    }
    return null;
}

}


