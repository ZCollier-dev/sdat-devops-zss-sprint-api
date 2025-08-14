package org.example.rest.airline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository airlineRepo;

    public List<Airline> getAllAirlines() {
        return airlineRepo.findAll();
    }

    public Airline addAirline(Airline airline) {
        return airlineRepo.save(airline);
    }

    public Airline updateAirline(Long id, Airline airline){
        airline.setId(id);
        return airlineRepo.save(airline);
    }

    public void deleteAirline(Long id) {
        airlineRepo.deleteById(id);
    }
}
