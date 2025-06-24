package org.example.controller;

import org.example.repository.CityRepository;
import org.example.model.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @PostMapping
    public City add(@RequestBody City city) {
        return cityRepository.save(city);
    }

    @PutMapping("/{id}")
    public City update(@PathVariable Long id, @RequestBody City city) {
        city.setId(id);
        return cityRepository.save(city);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cityRepository.deleteById(id);
    }
}
