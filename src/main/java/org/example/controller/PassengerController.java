package org.example.controller;

import org.example.model.Passenger;
import org.example.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerRepository passengerRepository;

    @GetMapping
    public List<Passenger> getAll() {
        return passengerRepository.findAll();
    }

    @PostMapping
    public Passenger add(@RequestBody Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @PutMapping("/{id}")
    public Passenger update(@PathVariable Long id, @RequestBody Passenger passenger) {
        passenger.setId(id);
        return passengerRepository.save(passenger);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        passengerRepository.deleteById(id);
    }
}
