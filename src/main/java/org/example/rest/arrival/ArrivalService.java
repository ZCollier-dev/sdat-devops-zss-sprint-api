package org.example.rest.arrival;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrivalService {

    @Autowired
    private ArrivalRepository arrivalRepo;

    public List<Arrival> getAllArrivals(){
        return arrivalRepo.findAll();
    }

    public Arrival addArrival(Arrival arrival){
        return arrivalRepo.save(arrival);
    }

    public Arrival updateArrival(Long id, Arrival arrival){
        arrival.setId(id);
        return arrivalRepo.save(arrival);
    }

    public void deleteArrival(Long id){
        arrivalRepo.deleteById(id);
    }
}
