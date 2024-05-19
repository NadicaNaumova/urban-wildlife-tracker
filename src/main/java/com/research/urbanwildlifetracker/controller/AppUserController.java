package com.research.urbanwildlifetracker.controller;

import com.research.urbanwildlifetracker.model.Appuser;
import com.research.urbanwildlifetracker.model.Species;
import com.research.urbanwildlifetracker.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping
    public List<Appuser> getAllUsers() {
        return appUserService.findAllUsers();
    }

    @PostMapping
    public Appuser createUser(@RequestBody Appuser appuser) {
        return appUserService.create(appuser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appuser> getUserById(@PathVariable Long id) {
        Appuser appuser = appUserService.getUserById(id);
        return appuser != null ? ResponseEntity.ok(appuser) : ResponseEntity.notFound().build();
    }

    @GetMapping("/lastName/{lastName}")
    public List<Appuser> getUsersByLastName(@PathVariable String lastName) {
        return appUserService.getUsersByLastName(lastName);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Appuser> getUserByEmail(@PathVariable String email) {
        Appuser appuser = appUserService.getUserByEmail(email);
        return appuser != null ? ResponseEntity.ok(appuser) : ResponseEntity.notFound().build();
    }

    @GetMapping("/firstNameContains/{substring}")
    public List<Appuser> getUsersByFirstNameContaining(@PathVariable String substring) {
        return appUserService.getUsersByFirstNameContaining(substring);
    }

    @GetMapping("/withSightings")
    public List<Appuser> getAllUsersWithSightings() {
        return appUserService.getAllUsersWithSightings();
    }

    @GetMapping("/{userId}/species")
    public List<Species> getSpeciesByUserId(@PathVariable Long userId) {
        return appUserService.getSpeciesByUserId(userId);
    }

    @GetMapping("/username/{username}/species")
    public List<Species> getSpeciesByUsername(@PathVariable String username) {
        return appUserService.getSpeciesByUsername(username);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appuser> updateUser(@PathVariable Long id, @RequestBody Appuser appuserDetails) {
        Appuser appuser = appUserService.getUserById(id);
        if (appuser != null) {
            appuser.setPassword(appuserDetails.getPassword());
            appuser.setFirstName(appuserDetails.getFirstName());
            appuser.setLastName(appuserDetails.getLastName());
            appuser.setEmail(appuserDetails.getEmail());
            Appuser updatedAppuser = appUserService.saveUser(appuser);
            return ResponseEntity.ok(updatedAppuser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Appuser appuser = appUserService.getUserById(id);
        if (appuser != null) {
            appUserService.deleteUser(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}