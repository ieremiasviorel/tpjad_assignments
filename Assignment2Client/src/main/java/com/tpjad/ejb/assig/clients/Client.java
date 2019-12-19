package com.tpjad.ejb.assig.clients;

import com.tpjad.ejb.assig.beans.interfaces.CityServiceRemote;
import com.tpjad.ejb.assig.beans.interfaces.FlightServiceRemote;
import com.tpjad.ejb.assig.entities.City;

import javax.naming.InitialContext;
import java.util.List;
import java.util.Properties;

public class Client {
    static final Properties JNDI = new Properties();

    static {
        JNDI.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
        JNDI.put("java.naming.provider.url", "http-remoting://localhost:8080");
    }

    static final String JNDICityService = "Assig2WAR/CityBeanImpl!com.tpjad.ejb.assig.beans.interfaces.CityServiceRemote";
    static final String JNDIFlightService = "Assig2WAR/FlightBeanImpl!com.tpjad.ejb.assig.beans.interfaces.FlightServiceRemote";

    public static void main(String[] args) throws Exception {
        CityServiceRemote cityServiceProxy = (CityServiceRemote) (new InitialContext(JNDI).lookup(JNDICityService));
        FlightServiceRemote flightServiceProxy = (FlightServiceRemote) (new InitialContext(JNDI).lookup(JNDIFlightService));

        List<String> countries = cityServiceProxy.getAllCountries();

        countries.forEach(country -> {
            List<City> cities = cityServiceProxy.getByCountry(country);

            System.out.println("[ " + country + " ]");
            cities.forEach(city -> System.out.println(" - " + city.getName()));
        });
    }
}
