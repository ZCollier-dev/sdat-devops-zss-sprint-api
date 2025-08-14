package org.example.rest.airport;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.example.rest.aircraft.Aircraft;
import org.example.rest.arrival.Arrival;
import org.example.rest.city.City;
import org.example.rest.departure.Departure;
import org.example.rest.gate.Gate;
import org.example.rest.passenger.Passenger;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Airport {

    @Id
    private Long id;

    private String name;
    private String code;

    /** Many airports belong to one city */
    @ManyToOne
    @JoinColumn(name = "city_id")
    @JsonBackReference // Prevent circular serialization with City
    private City city;

    /** Many airports can be visited by many passengers */
    @ManyToMany(mappedBy = "airports", fetch = FetchType.LAZY)
    @JsonIgnore // Avoid loops when serializing passengers
    private List<Passenger> passengers;

    /** Many airports can be visited by many aircraft */
    @ManyToMany(mappedBy = "airports", fetch = FetchType.LAZY)
    @JsonManagedReference // Avoid loops when serializing aircraft
    private List<Aircraft> aircraft;

    @OneToMany(mappedBy = "airport", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Gate> gates;

    // Getters / Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }

    public List<Passenger> getPassengers() { return passengers; }
    public void setPassengers(List<Passenger> passengers) { this.passengers = passengers; }

    public List<Aircraft> getAircraft() { return aircraft; }
    public void setAircraft(List<Aircraft> aircraft) { this.aircraft = aircraft; }

    public List<Gate> getGates(){
        return gates;
    }
    public void setGates(List<Gate> gates){
        this.gates = gates;
    }
}
