package com.tpjad.ejb.assig.beans;

import com.tpjad.ejb.assig.beans.interfaces.CityService;
import com.tpjad.ejb.assig.entities.City;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@Local(CityService.class)
@Remote(CityService.class)
public class CityBeanImpl implements CityService {
    @PersistenceContext(unitName = "ejb7")
    private EntityManager manager;

    @Override
    public City getByName(String name) {
        return null;
    }

    @Override
    public List<City> getAll() {
        return null;
    }

    @Override
    public List<City> getByCountry(String country) {
        return null;
    }
}
