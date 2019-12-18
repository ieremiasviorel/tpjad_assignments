package com.tpjad.ejb.assig.beans.interfaces;

import com.tpjad.ejb.assig.dtos.FlightFilter;
import com.tpjad.ejb.assig.entities.Flight;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface FlightServiceRemote {

    List<Flight> getAll();

    Flight getByFlightNumber(String flightNumber);

    List<Flight> getByFilter(FlightFilter filter);
}
