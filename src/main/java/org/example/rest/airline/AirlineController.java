package org.example.rest.airline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @GetMapping
    public List<Airline> getAll() {
        return airlineService.getAllAirlines();
    }

    @PostMapping
    public Airline add(@RequestBody Airline airline) {
        return airlineService.addAirline(airline);
    }

    @PutMapping("/{id}")
    public Airline update(@PathVariable Long id, @RequestBody Airline airline) {
        return airlineService.updateAirline(id, airline);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        airlineService.deleteAirline(id);
    }
}
