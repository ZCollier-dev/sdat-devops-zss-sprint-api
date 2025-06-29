package org.example.rest.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Airport {

    @Id
    private Long id;

    private String name;
    private String code;

    /** Many airports belong to one city */
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    /** join‐table side for aircraft ⇄ airport */
    @ManyToMany(mappedBy = "airports")
    private List<Aircraft> aircraft;

    /** join‐table side for passenger ⇄ airport */
    @ManyToMany(mappedBy = "airports")
    private List<Passenger> passengers;

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }

    public List<Aircraft> getAircraft() { return aircraft; }
    public void setAircraft(List<Aircraft> aircraft) { this.aircraft = aircraft; }

    public List<Passenger> getPassengers() { return passengers; }
    public void setPassengers(List<Passenger> passengers) { this.passengers = passengers; }
}
