package com.example.turistguidedel2.Controller;
import com.example.turistguidedel2.Service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String getAllTouristAttractions(Model model){ //ResponseEntity<List<TouristAttraction>> getAllTouristAttractions(){
       List<TouristAttraction> attractions = touristService.getAllTouristAttractions();
       model.addAttribute("allTouristAttractions", attractions);
        return "attractionList"; 
    }
    @GetMapping("/{name}")
    public String getTouristAttractionByName(@PathVariable String name, Model model){
        model.addAttribute("tourisAttractionName",touristService.getTouristAttractionByName(name).getName());
        return "test";
    }
    @GetMapping("/{name}/tags")
    public String getTouristAttractionByTags(@PathVariable String name, Model model){
        model.addAttribute("tags",touristService.getTouristAttractionByName(name).getTags());
        model.addAttribute("name",name);
        return "tags";
    }
    
    @PostMapping("/add")
    public String getTouristAttraction(@ModelAttribute("TouristAttraction touristAttraction")){
        touristService.addTouristAttraction(touristAttraction);
        return "redirect:/attractions";
    }

    @PostMapping("/save")
    public String saveTouristAttractions(@ModelAttribute("attractions") List<TouristAttraction> touristAttractions){
        touristService.saveTouristAttractions(touristAttractions);
        return "redirect:/attractions";
    }


    @PostMapping("/update")
    public String updateTouristAttraction(@ModelAttribute TouristAttraction touristAttraction){
        touristService.updateTouristAttraction(touristAttraction);
        return "redirect:/attractions";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteTouristAttraction(@ModelAttribute int index) {
        touristService.deleteTouristAttraction(index);
        return "redirect:/attractions";
    }

}
