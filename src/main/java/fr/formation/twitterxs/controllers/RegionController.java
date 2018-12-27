package fr.formation.twitterxs.controllers;

import fr.formation.twitterxs.entities.Region;
import fr.formation.twitterxs.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @PostMapping("/save")
    protected Long save(@RequestBody Region region){
        return regionService.save(region);
    }

    @GetMapping("all")
    protected List<Region> allRegion(){
        return regionService.allRegion();
    }
}
