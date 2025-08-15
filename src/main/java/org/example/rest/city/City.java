package org.example.rest.city;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.rest.airport.Airport;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.example.rest.passenger.Passenger;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // you insert id’s manually in data.sql

    private String name;
    private String state;
    private int population;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Airport> airports;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Passenger> passengers;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }

    public List<Airport> getAirports() { return airports; }
    public void setAirports(List<Airport> airports) { this.airports = airports; }

    public List<Passenger> getPassengers(){
        return passengers;
    }
    public void setPassengers(List<Passenger> passengers){
        this.passengers = passengers;
    }
}
