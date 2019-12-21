package com.tpjad.ejb.assig.clients;

import com.tpjad.ejb.assig.beans.interfaces.CityServiceRemote;
import com.tpjad.ejb.assig.entities.City;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.List;
import java.util.Properties;

public class Client {
    static final Properties JNDIProps = new Properties();

    static {
        JNDIProps.put("java.naming.factory.initial", "com.sun.enterprise.naming.impl.SerialInitContextFactory");
        JNDIProps.put("org.omg.CORBA.ORBInitialHost", "localhost");
        JNDIProps.put("org.omg.CORBA.ORBInitialPort", "3700");
    }

    public static void main(String[] args) throws Exception {
        Context context = new InitialContext(JNDIProps);
        CityServiceRemote cityServiceProxy = (CityServiceRemote) context.lookup(
                "java:global/Assig2WAR/CityBeanImpl!com.tpjad.ejb.assig.beans.interfaces.CityServiceRemote");

        List<String> countries = cityServiceProxy.getAllCountries();

        countries.forEach(country -> {
            System.out.println("[ " + country + " ]");
        });
    }
}
