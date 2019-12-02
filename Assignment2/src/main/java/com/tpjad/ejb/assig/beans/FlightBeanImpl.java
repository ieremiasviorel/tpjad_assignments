package com.tpjad.ejb.assig.beans;

import com.tpjad.ejb.assig.beans.interfaces.FlightService;
import com.tpjad.ejb.assig.dtos.FlightFilter;
import com.tpjad.ejb.assig.entities.Flight;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Local(FlightService.class)
@Remote(FlightService.class)
public class FlightBeanImpl implements FlightService {
    @PersistenceContext(unitName = "ejb7")
    private EntityManager manager;

    @Override
    public List<Flight> getAll() {
        return null;
    }

    @Override
    public Flight getByFlightNumber(String flightNumber) {
        return null;
    }

    @Override
    public List<Flight> getByFilter(FlightFilter filter) {
        return null;
    }

    @Override
    public List<String> getCountriesWithFlights() {
        return null;
    }
}
