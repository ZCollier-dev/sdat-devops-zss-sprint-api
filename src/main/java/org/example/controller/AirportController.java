package org.example.controller;

import org.example.model.Airport;
import org.example.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportRepository airportRepository;

    @GetMapping
    public List<Airport> getAll() {
        return airportRepository.findAll();
    }

    @PostMapping
    public Airport add(@RequestBody Airport airport) {
        return airportRepository.save(airport);
    }

    @PutMapping("/{id}")
    public Airport update(@PathVariable Long id, @RequestBody Airport airport) {
        airport.setId(id);
        return airportRepository.save(airport);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        airportRepository.deleteById(id);
    }
}