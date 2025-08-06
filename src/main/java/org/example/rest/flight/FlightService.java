package org.example.rest.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepo;

    public List<Flight> getAllFlights(){
        return flightRepo.findAll();
    }

    public Flight addFlight(Flight flight){
        return flightRepo.save(flight);
    }

    public Flight updateFlight(Long id, Flight flight){
        flight.setId(id);
        return flightRepo.save(flight);
    }

    public  void deleteFlight(Long id){
        flightRepo.deleteById(id);
    }
}
