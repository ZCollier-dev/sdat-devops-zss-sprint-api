package org.example.rest.city;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.example.rest.airport.Airport;

@Entity
public class City {

    @Id
    private Long id;          // you insert id’s manually in data.sql

    private String name;
    private String state;
    private int population;

    /** One city → many airports */
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<Airport> airports;

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public int getPopulation() { return population; }
    public void setPopulation(int population) { this.population = population; }

    public List<Airport> getAirports() { return airports; }
    public void setAirports(List<Airport> airports) { this.airports = airports; }
}
