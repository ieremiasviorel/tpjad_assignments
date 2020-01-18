package com.tpjad.ejb.assig.beans.interfaces;

import com.tpjad.ejb.assig.entities.City;

import java.util.List;

public interface CityServiceRemote {

    List<City> getAll();

    City getByName(String name);

    List<City> getByCountry(String country);

    List<String> getAllCountries();
}
