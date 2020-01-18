package com.tpjad.ejb.assig.beans.interfaces;

import com.tpjad.ejb.assig.entities.City;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CityServiceLocal {

    List<City> getAll();

    City getByName(String name);

    List<City> getByCountry(String country);

    List<String> getAllCountries();
}
