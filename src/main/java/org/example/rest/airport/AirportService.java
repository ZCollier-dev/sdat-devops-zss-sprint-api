package org.example.rest.airport;

import org.example.rest.aircraft.Aircraft;
import org.example.rest.aircraft.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepo;

    @Autowired
    private AircraftRepository aircraftRepo;

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

    public Airport linkAirportToAircraft(Long airportId, Long aircraftId){
        Optional<Airport> airportOptional = airportRepo.findById(airportId);
        Optional<Aircraft> aircraftOptional = aircraftRepo.findById(aircraftId);

        if (airportOptional.isPresent() && aircraftOptional.isPresent()) {
            Airport airport = airportOptional.get();
            Aircraft aircraft = aircraftOptional.get();
            List<Aircraft> aircraftList = airport.getAircraft();
            aircraftList.add(aircraft);
            airport.setAircraft(aircraftList);
            return airportRepo.save(airport);
        }
        return null;
    }

    public void deleteAirport(Long id){
        airportRepo.deleteById(id);
    }
}
