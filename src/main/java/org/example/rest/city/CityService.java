package org.example.rest.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepo;

    public List<City> getAllCities(){
        return cityRepo.findAll();
    }

    public City addCity(City city){
        return cityRepo.save(city);
    }

    public City updateCity(Long id, City city){
        city.setId(id);
        return cityRepo.save(city);
    }

    public void deleteCity(Long id){
        cityRepo.deleteById(id);
    }
}
