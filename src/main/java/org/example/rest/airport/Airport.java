package org.example.rest.airport;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import org.example.rest.aircraft.Aircraft;
import org.example.rest.city.City;
import org.example.rest.passenger.Passenger;

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

    // getters / setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public City getCity() { return city; }
    public void setCity(City city) { this.city = city; }
}
