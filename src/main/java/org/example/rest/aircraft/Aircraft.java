package org.example.rest.aircraft;

import java.util.List;

import jakarta.persistence.*;
import org.example.rest.airline.Airline;
import org.example.rest.airport.Airport;
import org.example.rest.passenger.Passenger;

@Entity
public class Aircraft {

    @Id
    private Long id;

    private String model;     // matches “model” in data.sql
    private int capacity;     // matches “capacity” in data.sql

    /** join‐table aircraft ⇄ airport */
    @ManyToMany
    @JoinTable(
        name = "aircraft_airport",
        joinColumns = @JoinColumn(name = "aircraft_id"),
        inverseJoinColumns = @JoinColumn(name = "airport_id")
    )
    private List<Airport> airports;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public List<Airport> getAirports() { return airports; }
    public void setAirports(List<Airport> airports) { this.airports = airports; }

    public Airline getAirline(){
        return airline;
    }
    public void setAirline(Airline airline){
        this.airline = airline;
    }
}
