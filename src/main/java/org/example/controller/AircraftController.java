package org.example.controller;

import org.example.model.Aircraft;
import org.example.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {

    @Autowired
    private AircraftRepository aircraftRepository;

    @GetMapping
    public List<Aircraft> getAll() {
        return aircraftRepository.findAll();
    }

    @PostMapping
    public Aircraft add(@RequestBody Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @PutMapping("/{id}")
    public Aircraft update(@PathVariable Long id, @RequestBody Aircraft aircraft) {
        aircraft.setId(id);
        return aircraftRepository.save(aircraft);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        aircraftRepository.deleteById(id);
    }
}