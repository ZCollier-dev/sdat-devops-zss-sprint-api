package org.example.rest.airline;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AirlineService {
    private final AirlineRepository airlineRepo;

    public AirlineService(AirlineRepository airlineRepo) {
        this.airlineRepo = airlineRepo;
    }

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
