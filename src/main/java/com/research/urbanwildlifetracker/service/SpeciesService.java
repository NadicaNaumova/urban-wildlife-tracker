package com.research.urbanwildlifetracker.service;


import com.research.urbanwildlifetracker.model.Species;
import com.research.urbanwildlifetracker.model.SpeciesRepository; // Ensure correct import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepo;

    public List<Species> getAllSpecies() {
        return speciesRepo.findAll();
    }

    public Species getSpeciesById(Long id) {
        return speciesRepo.findById(id).orElse(null);
    }

    public Species saveSpecies(Species species) {
        return speciesRepo.save(species);
    }

    public void deleteSpecies(Long id) {
        speciesRepo.deleteById(id);
    }

}