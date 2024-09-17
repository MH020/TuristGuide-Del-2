package com.example.turistguidedel2.Controller;
import com.example.turistguidedel2.Service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.turistguidedel2.Model.TouristAttraction;
import java.util.List;


@Controller
@RequestMapping ("/attractions")
public class TouristController {
    // This class is a controller class
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping
    public String getAllTouristAttractions(){ //ResponseEntity<List<TouristAttraction>> getAllTouristAttractions(){
       List<TouristAttraction> attractions = touristService.getAllTouristAttractions();
        return "attractions"; //new ResponseEntity<>(attractions, HttpStatus.OK);
    }
    @GetMapping("/{name}")
    public String getTouristAttractionByName(@PathVariable String name){
        TouristAttraction ta = touristService.getTouristAttractionByName(name);
        return "name";
    }
    
    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> getTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        touristService.addTouristAttraction(touristAttraction);
      return new ResponseEntity<>(touristAttraction, HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@RequestBody TouristAttraction touristAttraction){
        touristService.updateTouristAttraction(touristAttraction);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{index}")
    public ResponseEntity<TouristAttraction> deleteTouristAttraction(@PathVariable int index){
        touristService.deleteTouristAttraction(index);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
