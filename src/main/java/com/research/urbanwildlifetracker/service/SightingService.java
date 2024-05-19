package com.research.urbanwildlifetracker.service;


import com.research.urbanwildlifetracker.model.Sighting;
import com.research.urbanwildlifetracker.model.SightingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SightingService {

    @Autowired
    private SightingRepository sightingRepository;

    public List<Sighting> getAllSightings() {
        return sightingRepository.findAll();
    }

    public Sighting getSightingById(Long id) {
        return sightingRepository.findById(id).orElse(null);
    }

    public Sighting saveSighting(Sighting sighting) {
        return sightingRepository.save(sighting);
    }

    public void deleteSighting(Long id) {
        sightingRepository.deleteById(id);
    }
}