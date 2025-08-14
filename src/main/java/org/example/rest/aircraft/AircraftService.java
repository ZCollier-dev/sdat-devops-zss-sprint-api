package org.example.rest.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService {
    @Autowired
    private AircraftRepository aircraftRepo;

    public List<Aircraft> getAllAircraft(){
        return aircraftRepo.findAll();
    }

    public Aircraft addAircraft(Aircraft aircraft){
        return aircraftRepo.save(aircraft);
    }

    public Aircraft updateAircraft(Long id, Aircraft aircraft){
        aircraft.setId(id);
        return aircraftRepo.save(aircraft);
    }

    public void deleteAircraft(Long id){
        aircraftRepo.deleteById(id);
    }
}
