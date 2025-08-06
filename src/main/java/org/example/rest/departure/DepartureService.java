package org.example.rest.departure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureService {

    @Autowired
    private DepartureRepository departureRepo;

    public List<Departure> getAllDepartures(){
        return departureRepo.findAll();
    }

    public Departure addDeparture(Departure departure){
        return departureRepo.save(departure);
    }

    public Departure updateDeparture(Long id, Departure departure){
        departure.setId(id);
        return departureRepo.save(departure);
    }

    public void deleteDeparture(Long id){
        departureRepo.deleteById(id);
    }
}
