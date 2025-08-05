package org.example.rest.gate;

import org.example.rest.airport.Airport;

import jakarta.persistence.*;

@Entity
public class Gate {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gateNumber;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

    public Gate() {}

    public Gate(String gateNumber, Airport airport) {
        this.gateNumber = gateNumber;
        this.airport = airport;
    }

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
