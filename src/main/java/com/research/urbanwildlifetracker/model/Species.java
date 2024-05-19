package com.research.urbanwildlifetracker.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String photoUrl;
    private LocalDateTime timestamp;
    private String description;
    @ManyToMany(mappedBy = "species")
    private List<Sighting> sightings = new ArrayList<>();
    public Species() {
    }

    public Species(Long id, String location, String photoUrl, LocalDateTime timestamp, String description, List<Sighting> sightings) {
        this.id = id;
        this.location = location;
        this.photoUrl = photoUrl;
        this.timestamp = timestamp;
        this.description = description;
        this.sightings = sightings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Sighting> getSightings() {
        return sightings;
    }

    public void setSightings(List<Sighting> sightings) {
        this.sightings = sightings;
    }
}