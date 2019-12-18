package com.tpjad.ejb.assig.beans.interfaces;

import com.tpjad.ejb.assig.dtos.FlightFilter;
import com.tpjad.ejb.assig.entities.Flight;

import javax.ejb.Local;
import java.util.List;

@Local
public interface FlightServiceLocal {

    List<Flight> getAll();

    Flight getByFlightNumber(String flightNumber);

    List<Flight> getByFilter(FlightFilter filter);
}
