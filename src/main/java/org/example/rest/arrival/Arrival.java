package org.example.rest.arrival;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.rest.airport.Airport;
import org.example.rest.flight.Flight;

import java.util.Calendar;

@Entity
public class Arrival {

    @Id
    private Long id;

    private Calendar arrivalTime;
    private String status;

    @OneToOne
    @JoinColumn(name = "flight_id")
    @JsonIgnore
    private Flight flight;

    // Origin Airport
    @ManyToOne
    @JoinColumn(name = "airport_id")
    @JsonBackReference
    private Airport airport;

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

    public Airport getAirport(){
        return airport;
    }
    public void setAirport(Airport airport){
        this.airport = airport;
    }
}
