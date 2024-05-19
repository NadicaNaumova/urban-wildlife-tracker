package com.research.urbanwildlifetracker.service;



import com.research.urbanwildlifetracker.model.Appuser;
import com.research.urbanwildlifetracker.model.Species;
import com.research.urbanwildlifetracker.model.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository userRepo;

    public Appuser getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public List<Appuser> getUsersByLastName(String lastName) {
        return userRepo.findByLastName(lastName);
    }

    public Appuser getUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    public List<Appuser> getUsersByFirstNameContaining(String substring) {
        return userRepo.findByFirstNameContaining(substring);
    }

    public List<Appuser> getAllUsersWithSightings() {
        return userRepo.findAllUsersWithSightings();
    }

    public List<Species> getSpeciesByUserId(Long userId) {
        return userRepo.findSpeciesByUserId(userId);
    }

    public List<Species> getSpeciesByUsername(String username) {
        return userRepo.findSpeciesByUsername(username);
    }

    public List<Species> getSpeciesByUser(Appuser appuser) {
        return userRepo.findSpeciesByUser(appuser);
    }

    public Appuser saveUser(Appuser appuser) {
        return userRepo.save(appuser);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public List<Appuser> getAllUsers() {
        return userRepo.findAll();
    }


    public Appuser getUserById(Long id) {
        return userRepo.findById(id).get();
    }

    public List<Appuser> findAllUsers() {
        return userRepo.findAll();
    }

    public Appuser create(Appuser appuser) {
        return userRepo.save(appuser);
    }
}