package org.example.rest.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.rest.aircraft.Aircraft;
import org.example.rest.airport.Airport;
import org.example.rest.city.City;
import org.example.rest.flight.Flight;
import org.example.rest.passenger.Passenger;
import org.example.rest.aircraft.AircraftRepository;
import org.example.rest.city.CityRepository;
import org.example.rest.passenger.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

    private final CityRepository      cityRepo;
    private final PassengerRepository passengerRepo;
    private final AircraftRepository  aircraftRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public QueryService(CityRepository cityRepo,
                        PassengerRepository passengerRepo,
                        AircraftRepository aircraftRepo) {
        this.cityRepo      = cityRepo;
        this.passengerRepo = passengerRepo;
        this.aircraftRepo  = aircraftRepo;
    }

    /* 1. Airports in each city */
    public List<String> getAirportsByCity() {
        List<String> out = new ArrayList<>();
        for (City c : cityRepo.findAll()) {
            String names = c.getAirports().stream()
                    .map(Airport::getName)
                    .reduce((a,b)->a+", "+b).orElse("No airports");
            out.add(c.getName() + ": " + names);
        }
        return out;
    }

    /* 2. Aircraft flown by each passenger */
    public List<String> getAircraftByPassenger() {
        List<String> out = new ArrayList<>();
        for (Passenger p : passengerRepo.findAll()) {
            String planes = p.getFlights().stream()
                    .map(Flight::getAircraft)
                    .map(Aircraft::getModel)
                    .reduce((a,b)->a+", "+b).orElse("None");
            out.add(p.getName() + ": " + planes);
        }
        return out;
    }

    /* 3. Airports used by each aircraft */
    public List<String> getAirportsByAircraft() {
        List<String> out = new ArrayList<>();
        for (Aircraft a : aircraftRepo.findAll()) {
            String airports = a.getAirports().stream()
                    .map(Airport::getName)
                    .reduce((x,y)->x+", "+y).orElse("None");
            out.add(a.getModel() + ": " + airports);
        }
        return out;
    }

    /* 4. Airports visited by each passenger */
    public List<String> getAirportsByPassenger() {
        List<String> out = new ArrayList<>();
        for (Passenger p : passengerRepo.findAll()) {
            String airports = p.getAirports().stream()
                    .map(Airport::getCode)
                    .reduce((x,y)->x+", "+y).orElse("None");
            out.add(p.getName() + ": " + airports);
        }
        return out;
    }

    /* Check for DB readiness */
    public Map<String, Object> checkDb() {
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return Map.of(
                    "components", Map.of(
                            "db", Map.of("status", "UP")
                    )
            );
        } catch (Exception e) {
            return Map.of(
                    "components", Map.of(
                            "db", Map.of("status", "DOWN")
                    )
            );
        }
    }
}
