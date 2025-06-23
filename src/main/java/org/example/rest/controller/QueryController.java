package org.example.rest.controller;

import org.example.rest.model.Airport;
import org.example.rest.model.Aircraft;
import org.example.rest.model.Passenger;
import org.example.rest.repository.AirportRepository;
import org.example.rest.repository.AircraftRepository;
import org.example.rest.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    // 1. What airports are there in each city?
    @GetMapping("/cities/{cityId}/airports")
    public List<Airport> getAirportsByCity(@PathVariable Long cityId) {
        return airportRepository.findByCityId(cityId);
    }

    // 2. What aircraft has each passenger flown on?
    @GetMapping("/passengers/{passengerId}/aircraft")
    public List<Aircraft> getAircraftByPassenger(@PathVariable Long passengerId) {
        return passengerRepository.findById(passengerId)
                .map(Passenger::getAircraft)
                .orElse(Collections.emptyList());
    }

    // 3. What airports do aircraft take off from and land at?
    @GetMapping("/aircraft/{aircraftId}/airports")
    public List<Airport> getAirportsForAircraft(@PathVariable Long aircraftId) {
        return aircraftRepository.findById(aircraftId)
                .map(Aircraft::getAirports)
                .orElse(Collections.emptyList());
    }

    // 4. What airports have passengers used?
    @GetMapping("/passengers/{passengerId}/airports")
    public List<Airport> getAirportsUsedByPassenger(@PathVariable Long passengerId) {
        return passengerRepository.findById(passengerId)
                .map(passenger -> passenger.getAircraft().stream()
                        .flatMap(ac -> ac.getAirports().stream())
                        .distinct()
                        .toList())
                .orElse(Collections.emptyList());
    }
}
