package org.example.rest.departure;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.example.rest.flight.Flight;
import org.example.rest.gate.Gate;

import java.util.Calendar;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Departure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Calendar departureTime;
    private String status;

    @OneToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    // Destination Airport Gate
    @ManyToOne
    @JoinColumn(name = "gate_id")
    @JsonManagedReference
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
