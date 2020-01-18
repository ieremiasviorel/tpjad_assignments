package com.tpjad.ejb.assig.beans.interfaces;

import com.tpjad.ejb.assig.entities.City;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CityServiceRemote {

    List<City> getAll();

    City getByName(String name);

    List<City> getByCountry(String country);

    List<String> getAllCountries();
}
