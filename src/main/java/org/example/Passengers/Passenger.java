package org.example.Passengers;

import org.example.City.City;
import org.example.Airports.Airport;
import org.example.Aircraft.Aircraft;

import java.util.Set;
import jakarta.persistence.*;
import java.util.HashSet;

@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNum;

    @ManyToOne
    private City city;

    @ManyToOne
    private Airport airport;

    private Set<Aircraft> aircraft = new HashSet<>();

    public Passenger(String firstName, String lastName, String phoneNum, City city, Airport airport) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.city = city;
        this.airport = airport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Set<Aircraft> getAircraft() {
        return aircraft;
    }

    public void setAircraft(Set<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

    public void addAircraft(Aircraft aircraft) {
        this.aircraft.add(aircraft);
        aircraft.getPassengers().add(this);
    }

    public void removeAircraft(Aircraft aircraft) {
        this.aircraft.remove(aircraft);
        aircraft.getPassengers().remove(this);
    }

}
