package org.example.rest.arrival;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/arrivals")
public class ArrivalController {

    @Autowired
    private ArrivalService arrivalService;

    @GetMapping
    public List<Arrival> getAll(){
        return arrivalService.getAllArrivals();
    }

    @PostMapping
    public Arrival add(@RequestBody Arrival arrival){
        return arrivalService.addArrival(arrival);
    }

    @PutMapping("/{id}")
    public Arrival update(@PathVariable Long id, @RequestBody Arrival arrival){
        return arrivalService.updateArrival(id, arrival);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        arrivalService.deleteArrival(id);
    }
}
