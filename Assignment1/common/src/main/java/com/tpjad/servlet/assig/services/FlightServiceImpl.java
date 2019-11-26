package com.tpjad.servlet.assig.services;

import com.tpjad.servlet.assig.entities.Flight;
import com.tpjad.servlet.assig.repositories.CityRepository;
import com.tpjad.servlet.assig.repositories.FlightRepository;
import com.tpjad.servlet.assig.utils.FlightFilter;

import java.util.List;


public class FlightServiceImpl {

    private FlightRepository flightRepository;
    private CityRepository cityRepository;

    public FlightServiceImpl() {
        this.flightRepository = new FlightRepository();
        this.cityRepository = new CityRepository();
    }

    public List<Flight> getAll() {
        return this.flightRepository.findAll();
    }

    public Flight getByFlightNumber(String flightNumber) {
        return this.flightRepository.findByFlightNumber(flightNumber);
    }

    public List<Flight> getByFilter(FlightFilter filter) {
        return this.flightRepository.findByFilter(filter);
    }

    public List<String> getCountriesWithFlights() {
        return this.cityRepository.getCountryList();
    }
}
