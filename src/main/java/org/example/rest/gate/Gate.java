package org.example.rest.gate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.example.rest.airport.Airport;

import jakarta.persistence.*;
import org.example.rest.arrival.Arrival;
import org.example.rest.departure.Departure;

import java.util.List;

@Entity
public class Gate {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gateNumber;

    @OneToMany(mappedBy = "gate", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Departure> departures;

    @OneToMany(mappedBy = "gate", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Arrival> arrivals;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    @JsonManagedReference
    private Airport airport;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(String gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}
