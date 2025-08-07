package org.example.rest.airline;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.example.rest.aircraft.Aircraft;

import java.util.List;

@Entity
public class Airline {
    
    @Id
    private Long id;

    private String name; // Air Canada
    private String code; // AC

    @OneToMany(mappedBy = "airline")
    @JsonIgnore
    private List<Aircraft> aircraft;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public List<Aircraft> getAircraft(){
        return aircraft;
    }
    public void setAircraft(List<Aircraft> aircraft){
        this.aircraft = aircraft;
    }
}
