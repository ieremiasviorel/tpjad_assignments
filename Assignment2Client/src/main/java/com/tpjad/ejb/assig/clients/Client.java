package com.tpjad.ejb.assig.clients;

import com.tpjad.ejb.assig.beans.interfaces.CityServiceRemote;
import com.tpjad.ejb.assig.beans.interfaces.FlightServiceRemote;

import javax.naming.InitialContext;
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
        System.out.println("Client7JB");
        CityServiceRemote cityServiceProxy = (CityServiceRemote) (new InitialContext(JNDI).lookup(JNDICityService));
        FlightServiceRemote flightServiceProxy = (FlightServiceRemote) (new InitialContext(JNDI).lookup(JNDIFlightService));

        cityServiceProxy.getAllCountries().forEach(System.out::println);
    }
}
