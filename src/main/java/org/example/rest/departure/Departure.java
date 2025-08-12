package org.example.rest.departure;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.rest.airport.Airport;
import org.example.rest.flight.Flight;
import org.example.rest.gate.Gate;

import java.util.Calendar;

@Entity
public class Departure {

    @Id
    private Long id;

    private Calendar departureTime;
    private String status;

    @OneToOne
    @JoinColumn(name = "flight_id")
    @JsonIgnore
    private Flight flight;

    // Destination Airport
    @ManyToOne
    @JoinColumn(name = "gate_id")
    @JsonBackReference
    private Gate gate;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public Calendar getDepartureTime(){
        return departureTime;
    }
    public void setDepartureTime(Calendar departureTime){
        this.departureTime = departureTime;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public Flight getFlight(){
        return flight;
    }
    public void setFlight(Flight flight){
        this.flight = flight;
    }

    public Gate getGate(){
        return gate;
    }
    public void setGate(Gate gate){
        this.gate = gate;
    }
}
