package com.research.urbanwildlifetracker.model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppUserRepository extends JpaRepository<Appuser, Long> {

    // Derived query method to find user by username
    Appuser findByUsername(String username);

    // Derived query method to find users by last name
    List<Appuser> findByLastName(String lastName);

    // Custom query using JPQL to find user by email
    @Query("SELECT u FROM Appuser u WHERE u.email = :email")
    Appuser findByEmail(@Param("email") String email);

    // Custom query using JPQL to find users by first name containing a substring
    @Query("SELECT u FROM Appuser u WHERE u.firstName LIKE %:substring%")
    List<Appuser> findByFirstNameContaining(@Param("substring") String substring);

    // Custom query using JPQL to find all users with sightings
    @Query("SELECT u FROM Appuser u JOIN FETCH u.sightings")
    List<Appuser> findAllUsersWithSightings();

    // Custom query using JPQL to find species by user
    @Query("SELECT s.species FROM Sighting s WHERE s.appuser = :user")
    List<Species> findSpeciesByUser(@Param("user") Appuser user);

    // Custom query using JPQL to find species by user ID
    @Query("SELECT s.species FROM Sighting s WHERE s.appuser.id = :userId")
    List<Species> findSpeciesByUserId(@Param("userId") Long userId);

    // Custom query using JPQL to find species by username
    @Query("SELECT s.species FROM Sighting s WHERE s.appuser.username = :username")
    List<Species> findSpeciesByUsername(@Param("username") String username);
}
