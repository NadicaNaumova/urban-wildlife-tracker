package com.research.urbanwildlifetracker.model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Appuser {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String username;
     private String password;
     private String firstName;
     private String lastName;
     private String email;
     @OneToMany(mappedBy = "appuser", cascade = CascadeType.ALL, orphanRemoval = true)
     private List<Sighting> sightings = new ArrayList<>();

     public Appuser() {
     }

    public Appuser(Long id, String username, String password, String firstName, String lastName, String email, List<Sighting> sightings) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.sightings = sightings;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Sighting> getSightings() {
        return sightings;
    }

    public void setSightings(List<Sighting> sightings) {
        this.sightings = sightings;
    }
}