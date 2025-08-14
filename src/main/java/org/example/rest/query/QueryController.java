package org.example.rest.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class QueryController {

    @Autowired
    private QueryService queryService;

    @GetMapping("/airports/by-city")
    public List<String> getAirportsByCity() {
        return queryService.getAirportsByCity();
    }

    @GetMapping("/aircraft/by-passenger")
    public List<String> getAircraftByPassenger() {
        return queryService.getAircraftByPassenger();
    }

    @GetMapping("/airports/by-aircraft")
    public List<String> getAirportsByAircraft() {
        return queryService.getAirportsByAircraft();
    }

    @GetMapping("/airports/by-passenger")
    public List<String> getAirportsByPassenger() {
        return queryService.getAirportsByPassenger();
    }

    @GetMapping("/db-check")
    public ResponseEntity checkDB(){
        return queryService.checkDB();
    }
}
