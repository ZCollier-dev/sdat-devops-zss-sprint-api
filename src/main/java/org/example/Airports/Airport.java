package org.example.Airports;

import org.example.City.City;
import org.example.Passengers.Passenger;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String code;
    private String name;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "airport", cascade = CascadeType.ALL)
    private List<Passenger> passengers = new ArrayList<>();


    public Airport() {}

    public Airport(String code, String name, City city) {
        this.code = code;
        this.name = name;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        passenger.setAirport(this);
    }

    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
        passenger.setAirport(null);
    }
}
