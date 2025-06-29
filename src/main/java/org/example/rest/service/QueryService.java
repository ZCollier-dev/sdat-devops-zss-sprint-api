package org.example.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.example.rest.model.Aircraft;
import org.example.rest.model.Airport;
import org.example.rest.model.City;
import org.example.rest.model.Passenger;
import org.example.rest.repository.AircraftRepository;
import org.example.rest.repository.CityRepository;
import org.example.rest.repository.PassengerRepository;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

    private final CityRepository      cityRepo;
    private final PassengerRepository passengerRepo;
    private final AircraftRepository  aircraftRepo;

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
            String planes = p.getAircraft().stream()
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
}
