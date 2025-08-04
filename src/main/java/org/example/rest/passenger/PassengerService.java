package org.example.rest.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepo;

    public List<Passenger> getAllPassengers(){
        return passengerRepo.findAll();
    }

    public Passenger addPassenger(Passenger passenger){
        return passengerRepo.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger passenger){
        passenger.setId(id);
        return passengerRepo.save(passenger);
    }

    public void deletePassenger(Long id){
        passengerRepo.deleteById(id);
    }
}
