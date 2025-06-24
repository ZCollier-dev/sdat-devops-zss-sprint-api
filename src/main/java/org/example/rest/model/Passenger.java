package org.example.rest.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Passenger {

    @Id
    private Long id;

    private String name;     // matches “name” in data.sql
    private String email;    // matches “email” in data.sql

    /** join‐table passenger ⇄ aircraft */
    @ManyToMany(mappedBy = "passengers")
    private List<Aircraft> aircraft;

    /** join‐table passenger ⇄ airport */
    @ManyToMany
    @JoinTable(
        name = "passenger_airport",
        joinColumns = @JoinColumn(name = "passenger_id"),
        inverseJoinColumns = @JoinColumn(name = "airport_id")
    )
    private List<Airport> airports;

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Aircraft> getAircraft() { return aircraft; }
    public void setAircraft(List<Aircraft> aircraft) { this.aircraft = aircraft; }

    public List<Airport> getAirports() { return airports; }
    public void setAirports(List<Airport> airports) { this.airports = airports; }
}
