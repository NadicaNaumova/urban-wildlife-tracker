package com.research.urbanwildlifetracker.controller;
import  com.research.urbanwildlifetracker.controller.ResourceNotFoundException;
import com.research.urbanwildlifetracker.model.Sighting;
import com.research.urbanwildlifetracker.service.SightingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sightings")
public class SightingController {

    @Autowired
    private SightingService sightingService;

    @GetMapping
    public List<Sighting> getAllSightings() {
        return sightingService.getAllSightings();
    }

    @GetMapping("/{id}")
    public Sighting getSightingById(@PathVariable Long id) {
        return sightingService.getSightingById(id);
    }

    @PostMapping
    public Sighting createSighting(@RequestBody Sighting sighting) {
        return sightingService.saveSighting(sighting);
    }

    @PutMapping("/{id}")
    public Sighting updateSighting(@PathVariable Long id, @RequestBody Sighting sightingDetails) {
        Sighting sighting = sightingService.getSightingById(id);
        if (sighting != null) {
            sighting.setLocation(sightingDetails.getLocation());
            sighting.setPhotoUrl(sightingDetails.getPhotoUrl());
            sighting.setTimestamp(sightingDetails.getTimestamp());
            sighting.setDescription(sightingDetails.getDescription());
            sighting.setSpecies(sightingDetails.getSpecies());
            sighting.setUser(sightingDetails.getUser());
            return sightingService.saveSighting(sighting);
        } else {
            throw new ResourceNotFoundException("Sighting not found with id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSighting(@PathVariable Long id) {
        sightingService.deleteSighting(id);
    }
}