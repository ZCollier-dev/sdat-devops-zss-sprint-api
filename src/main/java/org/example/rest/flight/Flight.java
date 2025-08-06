package org.example.rest.flight;

import jakarta.persistence.*;
import org.example.rest.aircraft.Aircraft;
import org.example.rest.arrival.Arrival;
import org.example.rest.departure.Departure;
import org.example.rest.passenger.Passenger;

import java.util.List;

@Entity
public class Flight {

    @Id
    private Long id;

    @OneToOne
    private Departure departure;

    @OneToOne
    private Arrival arrival;

    @OneToMany
    private Aircraft aircraft;

    @ManyToMany
    private List<Passenger> passengers;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Departure getDeparture(){
        return departure;
    }
    public void setDeparture(Departure departure){
        this.departure = departure;
    }

    public Arrival getArrival(){
        return arrival;
    }
    public void setArrival(Arrival arrival){
        this.arrival = arrival;
    }

    public Aircraft getAircraft(){
        return aircraft;
    }
    public void setAircraft(Aircraft aircraft){
        this.aircraft = aircraft;
    }

    public List<Passenger> getPassengers(){
        return passengers;
    }
    public void setPassengers(List<Passenger> passengers){
        this.passengers = passengers;
    }
}
