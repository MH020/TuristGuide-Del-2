package com.example.turistguidedel2.Controller;
import com.example.turistguidedel2.Service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.turistguidedel2.Model.TouristAttraction;
import java.util.List;


@Controller
public class TouristController {
    // This class is a controller class
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("/attractions")
    public String getAllTouristAttractions(Model model){ //ResponseEntity<List<TouristAttraction>> getAllTouristAttractions(){
        List<TouristAttraction> attractions = touristService.getAllTouristAttractions();
        model.addAttribute("allTouristAttractions", attractions);
        return "attractionList";
    }
    @GetMapping("/attractions/{name}")
    public String getTouristAttractionByName(@PathVariable String name, Model model){
        model.addAttribute("tourisAttractionName",touristService.getTouristAttractionByName(name).getName());
        return "test";
    }
    @GetMapping("/attractions/{name}/tags")
    public String getTouristAttractionByTags(@PathVariable String name, Model model){
        model.addAttribute("tags",touristService.getTouristAttractionByName(name));
        model.addAttribute("name",name);
        return "tags";
    }

    @PostMapping("/attractions/save")
    public String saveTouristAttractions(@ModelAttribute TouristAttraction touristAttraction) {
        touristService.saveTouristAttractions(touristAttraction);
        return "redirect:/attractions";
    }
    @GetMapping("/attractions/add")
    public String addTouristAttraction(Model model){
        model.addAttribute("TouristAttraction", new TouristAttraction());
        model.addAttribute("taglist", touristService.getTouristAttractionTags());
        return "add";
    }
    @PostMapping("/attractions/update")
    public String updateTouristAttraction(@ModelAttribute TouristAttraction touristAttraction){
        touristService.updateTouristAttraction(touristAttraction);
        return "redirect:/attractions";
    }
    @GetMapping("/attractions/edit")
    public String editTouristAttraction(@ModelAttribute String name, Model model){
        model.addAttribute("touristAttraction", touristService.getTouristAttractionByName(name));
        return "edit";
    }

    @PostMapping("/attractions/delete/{index}")
    public String deleteTouristAttraction(@ModelAttribute int index) {
        touristService.deleteTouristAttraction(index);
        return "redirect:/attractions";
    }
//still up to date
}

