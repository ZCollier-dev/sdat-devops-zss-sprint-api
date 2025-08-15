package org.example.rest.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public List<Passenger> getAll() {
        return passengerService.getAllPassengers();
    }

    @PostMapping
    public Passenger add(@RequestBody Passenger passenger) {
        return passengerService.addPassenger(passenger);
    }

    @PutMapping("/{id}")
    public Passenger update(@PathVariable Long id, @RequestBody Passenger passenger) {
        return passengerService.updatePassenger(id, passenger);
    }

    @PutMapping("/link-airport/{passenger_id}")
    public Passenger linkAirport(@PathVariable Long passenger_id, @RequestBody Long right){
        return passengerService.linkPassengerToAirport(passenger_id, right);
    }

    @PutMapping("/link-flight/{passenger_id}")
    public Passenger linkFlight(@PathVariable Long passenger_id, @RequestBody Long right){
        return passengerService.linkPassengerToFlight(passenger_id, right);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        passengerService.deletePassenger(id);
    }
}
