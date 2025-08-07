package org.example.rest.gate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.example.rest.airport.Airport;

import jakarta.persistence.*;

@Entity
public class Gate {
    
    @Id
    private Long id;

    private String gateNumber;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    @JsonBackReference
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
