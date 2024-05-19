package com.research.urbanwildlifetracker.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity


public class Sighting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String photoUrl;
    private LocalDateTime timestamp;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Appuser appuser;

    @ManyToMany
    @JoinTable(
            name = "sighting_species",
            joinColumns = @JoinColumn(name = "sighting_id"),
            inverseJoinColumns = @JoinColumn(name = "species_id")
    )
    private List<Species> species = new ArrayList<>();

    public Sighting() {
    }

    public Sighting(Long id, String location, String photoUrl, LocalDateTime timestamp, String description, Appuser appuser, List<Species> species) {
        this.id = id;
        this.location = location;
        this.photoUrl = photoUrl;
        this.timestamp = timestamp;
        this.description = description;
        this.appuser = appuser;
        this.species = species;
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

    public Appuser getUser() {
        return appuser;
    }

    public void setUser(Appuser appuser) {
        this.appuser = appuser;
    }

    public List<Species> getSpecies() {
        return species;
    }

    public void setSpecies(List<Species> species) {
        this.species = species;
    }
}
