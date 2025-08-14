package org.example.rest.flight;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.example.rest.aircraft.Aircraft;
import org.example.rest.arrival.Arrival;
import org.example.rest.departure.Departure;
import org.example.rest.passenger.Passenger;

import java.util.List;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "departure_id")
    private Departure departure;

    @OneToOne
    @JoinColumn(name = "arrival_id")
    private Arrival arrival;

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    @JsonManagedReference
    private Aircraft aircraft;

    @ManyToMany(mappedBy = "flights")
    @JsonIgnore
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
