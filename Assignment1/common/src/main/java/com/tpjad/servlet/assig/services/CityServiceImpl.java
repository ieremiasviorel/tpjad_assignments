package com.tpjad.servlet.assig.services;

import com.tpjad.servlet.assig.entities.City;
import com.tpjad.servlet.assig.repositories.CityRepository;

import java.util.List;


public class CityServiceImpl {

	private CityRepository cityRepository;

	public CityServiceImpl() {
		this.cityRepository = new CityRepository();
	}

	public City getByName(String name) {
		return this.cityRepository.findByName(name);
	}

	public List<City> getAll() {
		return this.cityRepository.findAll();
	}

	public List<City> getByCountry(String country) {
		return this.cityRepository.findByCountry(country);
	}
}
