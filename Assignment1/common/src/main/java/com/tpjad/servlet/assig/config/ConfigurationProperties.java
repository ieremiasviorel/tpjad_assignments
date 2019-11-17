package com.tpjad.servlet.assig.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationProperties {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigurationProperties.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getConfigProperty(String propertyKey) {
        return properties.getProperty(propertyKey);
    }
}
