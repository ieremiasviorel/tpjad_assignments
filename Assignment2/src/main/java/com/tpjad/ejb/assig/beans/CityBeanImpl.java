package com.tpjad.ejb.assig.beans;

import com.tpjad.ejb.assig.beans.interfaces.CityServiceLocal;
import com.tpjad.ejb.assig.beans.interfaces.CityServiceRemote;
import com.tpjad.ejb.assig.entities.City;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CityBeanImpl implements CityServiceLocal, CityServiceRemote {
    @PersistenceContext(unitName = "tpjad_assig2_ejb")
    private EntityManager manager;

    @Override
    public City getByName(String name) {
        TypedQuery<City> query = manager.createQuery("SELECT c FROM City AS c WHERE c.name = :name", City.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public List<City> getAll() {
        TypedQuery<City> query = manager.createQuery("SELECT c FROM City c", City.class);
        return query.getResultList();
    }

    @Override
    public List<City> getByCountry(String country) {
        TypedQuery<City> query = manager.createQuery("SELECT c FROM City AS c WHERE c.country = :country", City.class);
        query.setParameter("country", country);
        return query.getResultList();
    }

    @Override
    public List<String> getAllCountries() {
        return getAll().stream()
                .map(City::getCountry)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
