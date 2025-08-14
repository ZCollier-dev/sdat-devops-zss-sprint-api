package org.example.rest.arrival;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.rest.flight.Flight;
import org.example.rest.gate.Gate;

import java.util.Calendar;

@Entity
public class Arrival {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Calendar arrivalTime;
    private String status;

    @OneToOne
    @JoinColumn(name = "flight_id")
    @JsonIgnore
    private Flight flight;

    // Origin Airport Gate
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

    public Calendar getArrivalTime(){
        return arrivalTime;
    }
    public void setArrivalTime(Calendar arrivalTime){
        this.arrivalTime = arrivalTime;
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
