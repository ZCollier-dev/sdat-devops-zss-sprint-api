package org.example.rest.passenger;

import java.util.List;

import jakarta.persistence.*;
import org.example.rest.aircraft.Aircraft;
import org.example.rest.airport.Airport;
import org.example.rest.city.City;

@Entity
public class Passenger {

    @Id
    private Long id;

    private String name;     // matches “name” in data.sql
    private String email;    // matches “email” in data.sql

    /** join‐table passenger ⇄ airport */
    @ManyToMany
    @JoinTable(
        name = "passenger_airport",
        joinColumns = @JoinColumn(name = "passenger_id"),
        inverseJoinColumns = @JoinColumn(name = "airport_id")
    )
    private List<Airport> airports;

    @ManyToMany
    @JoinTable(
        name = "passenger_aircraft",
        joinColumns = @JoinColumn(name = "passenger_id"),
        inverseJoinColumns = @JoinColumn(name = "aircraft_id")
    )
    private List<Aircraft> aircraft;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Airport> getAirports() { return airports; }
    public void setAirports(List<Airport> airports) { this.airports = airports; }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

    public City getCity(){
        return city;
    }
    public void setCity(City city){
        this.city = city;
    }
}
