package com.research.urbanwildlifetracker.model;


import com.research.urbanwildlifetracker.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, Long> {

}