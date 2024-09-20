package com.example.turistguidedel2.Controller;
import com.example.turistguidedel2.Service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.turistguidedel2.Model.TouristAttraction;

import java.util.ArrayList;
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
    @GetMapping("/{name}")
    public String getTouristAttractionByName(@PathVariable String name, Model model){
        model.addAttribute("tourisAttractionName",touristService.getTouristAttractionByName(name).getName());
        return "test";
    }
    @GetMapping("/{name}/tags")
    public String getTouristAttractionByTags(@PathVariable String name, Model model){
        TouristAttraction attraction = touristService.getTouristAttractionByName(name);
        model.addAttribute("touristAttraction",attraction);
        model.addAttribute("tags",touristService.getTouristAttractionTags());
        return "tags";
    }

    @PostMapping("/save")
    public String saveTouristAttractions(@ModelAttribute TouristAttraction touristAttraction) {
        touristService.saveTouristAttractions(touristAttraction);
        return "redirect:/attractions";
    }
    @GetMapping("/add")
    public String addTouristAttraction(Model model){
        model.addAttribute("TouristAttraction", new TouristAttraction("", "", "", new ArrayList<>()));
        model.addAttribute("taglist", touristService.getTouristAttractionTags());
        return "add";
    }
    @PostMapping("/update")
    public String updateTouristAttraction(@ModelAttribute TouristAttraction touristAttraction){
        touristService.updateTouristAttraction(touristAttraction);
        return "redirect:/attractions";
    }
    @GetMapping("/edit")
    public String editTouristAttraction(@ModelAttribute String name, Model model){
        model.addAttribute("touristAttraction", touristService.getTouristAttractionByName(name));
        return "edit";
    }

    @PostMapping("/delete/{index}")
    public String deleteTouristAttraction(@ModelAttribute int index) {
        touristService.deleteTouristAttraction(index);
        return "redirect:/attractions";
    }
//still up to date
}

