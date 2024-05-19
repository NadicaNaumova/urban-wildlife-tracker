package com.research.urbanwildlifetracker.model;



import com.research.urbanwildlifetracker.model.Sighting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SightingRepository extends JpaRepository<Sighting, Long> {
}