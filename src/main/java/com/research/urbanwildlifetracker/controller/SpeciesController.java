package com.research.urbanwildlifetracker.controller;

import com.research.urbanwildlifetracker.controller.ResourceNotFoundException;
import com.research.urbanwildlifetracker.model.Species;
import com.research.urbanwildlifetracker.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {

    @Autowired
    private SpeciesService speciesService;

    @GetMapping
    public List<Species> getAllSpecies() {
        return speciesService.getAllSpecies();
    }

    @GetMapping("/{id}")
    public Species getSpeciesById(@PathVariable Long id) {
        Species species = speciesService.getSpeciesById(id);
        if (species == null) {
            throw new ResourceNotFoundException("Species not found with id " + id);
        }
        return species;
    }

    @PostMapping
    public Species createSpecies(@RequestBody Species species) {
        return speciesService.saveSpecies(species);
    }

    @PutMapping("/{id}")
    public Species updateSpecies(@PathVariable Long id, @RequestBody Species speciesDetails) {
        Species species = speciesService.getSpeciesById(id);
        if (species != null) {
            species.setDescription(speciesDetails.getDescription());
            return speciesService.saveSpecies(species);
        } else {
            throw new ResourceNotFoundException("Species not found with id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSpecies(@PathVariable Long id) {
        Species species = speciesService.getSpeciesById(id);
        if (species == null) {
            throw new ResourceNotFoundException("Species not found with id " + id);
        }
        speciesService.deleteSpecies(id);
    }
}

