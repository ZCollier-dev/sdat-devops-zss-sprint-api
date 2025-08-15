package org.example.rest.passenger;

import org.example.rest.airport.Airport;
import org.example.rest.airport.AirportRepository;
import org.example.rest.flight.Flight;
import org.example.rest.flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepo;

    @Autowired
    private AirportRepository airportRepo;

    @Autowired
    private FlightRepository flightRepo;

    public List<Passenger> getAllPassengers(){
        return passengerRepo.findAll();
    }

    public Passenger addPassenger(Passenger passenger){
        return passengerRepo.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger passenger){
        passenger.setId(id);
        return passengerRepo.save(passenger);
    }

    public Passenger linkPassengerToAirport(Long passengerId, Long airportId){
        Optional<Passenger> passengerOptional = passengerRepo.findById(passengerId);
        Optional<Airport> airportOptional = airportRepo.findById(airportId);

        if (passengerOptional.isPresent() && airportOptional.isPresent()) {
            Passenger passenger = passengerOptional.get();
            Airport airport = airportOptional.get();
            List<Airport> airportList = passenger.getAirports();
            airportList.add(airport);
            passenger.setAirports(airportList);
            return passengerRepo.save(passenger);
        }
        return null;
    }

    public Passenger linkPassengerToFlight(Long passengerId, Long flightId){
        Optional<Passenger> passengerOptional = passengerRepo.findById(passengerId);
        Optional<Flight> flightOptional = flightRepo.findById(flightId);

        if (passengerOptional.isPresent() && flightOptional.isPresent()) {
            Passenger passenger = passengerOptional.get();
            Flight flight = flightOptional.get();
            List<Flight> flightList = passenger.getFlights();
            flightList.add(flight);
            passenger.setFlights(flightList);
            return passengerRepo.save(passenger);
        }
        return null;
    }

    public void deletePassenger(Long id){
        passengerRepo.deleteById(id);
    }
}
