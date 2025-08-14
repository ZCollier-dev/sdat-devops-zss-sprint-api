package org.example.rest.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getAll() {
        return cityService.getAllCities();
    }

    @PostMapping
    public City add(@RequestBody City city) {
        return cityService.addCity(city);
    }

    @PutMapping("/{id}")
    public City update(@PathVariable Long id, @RequestBody City city) {
        return cityService.updateCity(id, city);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}
