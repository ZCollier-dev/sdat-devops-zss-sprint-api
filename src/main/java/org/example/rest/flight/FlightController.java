package org.example.rest.flight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getAll(){
        return flightService.getAllFlights();
    }

    @PostMapping
    public Flight add(@RequestBody Flight flight){
        return flightService.addFlight(flight);
    }

    @PutMapping("/{id}")
    public Flight update(@PathVariable Long id, @RequestBody Flight flight){
        return flightService.updateFlight(id, flight);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        flightService.deleteFlight(id);
    }
}
