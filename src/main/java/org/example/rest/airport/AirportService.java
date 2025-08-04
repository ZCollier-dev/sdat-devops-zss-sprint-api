package org.example.rest.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepo;

    public List<Airport> getAllAirports(){
        return airportRepo.findAll();
    }

    public Airport addAirport(Airport airport){
        return airportRepo.save(airport);
    }

    public Airport updateAirport(Long id, Airport airport){
        airport.setId(id);
        return airportRepo.save(airport);
    }

    public void deleteAirport(Long id){
        airportRepo.deleteById(id);
    }
}
