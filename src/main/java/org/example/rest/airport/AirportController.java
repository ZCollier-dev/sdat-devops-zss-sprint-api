package org.example.rest.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public List<Airport> getAll() {
        return airportService.getAllAirports();
    }

    @PostMapping
    public Airport add(@RequestBody Airport airport) {
        return airportService.addAirport(airport);
    }

    @PutMapping("/{id}")
    public Airport update(@PathVariable Long id, @RequestBody Airport airport) {
        return airportService.updateAirport(id, airport);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        airportService.deleteAirport(id);
    }
}