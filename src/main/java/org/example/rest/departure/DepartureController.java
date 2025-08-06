package org.example.rest.departure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departures")
public class DepartureController {

    @Autowired
    private DepartureService departureService;

    @GetMapping
    public List<Departure> getAll(){
        return departureService.getAllDepartures();
    }

    @PostMapping
    public Departure add(@RequestBody Departure departure){
        return departureService.addDeparture(departure);
    }

    @PutMapping("/{id}")
    public Departure update(@PathVariable Long id, @RequestBody Departure departure){
        return departureService.updateDeparture(id, departure);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        departureService.deleteDeparture(id);
    }
}
