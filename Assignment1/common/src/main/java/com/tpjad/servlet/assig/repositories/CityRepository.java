package com.tpjad.servlet.assig.repositories;

import com.tpjad.servlet.assig.entities.City;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CityRepository {

    private static List<City> cities = new ArrayList<City>();

    public List<City> findAll() {
        return cities;
    }

    static City findById(int id) {
        return cities.stream()
                .filter(c -> c.getId() == id)
                .collect(Collectors.toList()).get(0);
    }

    public City findByName(String name) {
        return cities.stream()
                .filter(c -> c.getName().equals(name))
                .collect(Collectors.toList()).get(0);
    }

    public List<City> findByCountry(String country) {
        return cities.stream()
                .filter(c -> c.getCountry().equals(country))
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> getCountryList() {
        return cities.stream()
                .map(City::getCountry)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    static {
        cities.add(new City(1, "Mexico City", (float) 19.4424, (float) -99.131, "Mexico"));
        cities.add(new City(2, "Lagos", (float) 6.4433, (float) 3.3915, "Nigeria"));
        cities.add(new City(3, "Lima", (float) -12.048, (float) -77.0501, "Peru"));
        cities.add(new City(4, "Manila", (float) 14.6042, (float) 120.9822, "Philippines"));
        cities.add(new City(5, "Karachi", (float) 24.87, (float) 66.99, "Pakistan"));
        cities.add(new City(6, "Lahore", (float) 31.56, (float) 74.35, "Pakistan"));
        cities.add(new City(7, "Moscow", (float) 55.7522, (float) 37.6155, "Russia"));
        cities.add(new City(8, "Singapore", (float) 1.293, (float) 103.8558, "Singapore"));
        cities.add(new City(9, "Bangkok", (float) 13.75, (float) 100.5166, "Thailand"));
        cities.add(new City(10, "Istanbul", (float) 41.105, (float) 29.01, "Turkey"));
        cities.add(new City(11, "Taipei", (float) 25.0358, (float) 121.5683, "Taiwan"));
        cities.add(new City(12, "Ho Chi Minh City", (float) 10.78, (float) 106.695, "Vietnam"));
        cities.add(new City(13, "Luanda", (float) -8.8383, (float) 13.2344, "Angola"));
        cities.add(new City(14, "Buenos Aires", (float) -34.6025, (float) -58.3975, "Argentina"));
        cities.add(new City(15, "Dhaka", (float) 23.7231, (float) 90.4086, "Bangladesh"));
        cities.add(new City(16, "Belo Horizonte", (float) -19.915, (float) -43.915, "Brazil"));
        cities.add(new City(17, "Rio de Janeiro", (float) -22.925, (float) -43.225, "Brazil"));
        cities.add(new City(18, "Sao Paulo", (float) -23.5587, (float) -46.625, "Brazil"));
        cities.add(new City(19, "Toronto", (float) 43.7, (float) -79.42, "Canada"));
        cities.add(new City(20, "Kinshasa", (float) -4.3297, (float) 15.315, "Congo"));
        cities.add(new City(21, "Santiago", (float) -33.45, (float) -70.667, "Chile"));
        cities.add(new City(22, "Shanghai", (float) 31.2165, (float) 121.4365, "China"));
        cities.add(new City(23, "Tianjin", (float) 39.13, (float) 117.2, "China"));
        cities.add(new City(24, "Shenzhen", (float) 22.5524, (float) 114.1221, "China"));
        cities.add(new City(25, "Wuhan", (float) 30.58, (float) 114.27, "China"));
        cities.add(new City(26, "Guangzhou", (float) 23.145, (float) 113.325, "China"));
        cities.add(new City(27, "Beijing", (float) 39.9289, (float) 116.3883, "China"));
        cities.add(new City(28, "Chongqing", (float) 29.565, (float) 106.595, "China"));
        cities.add(new City(29, "Bogota", (float) 4.5964, (float) -74.0833, "Colombia"));
        cities.add(new City(30, "Cairo", (float) 30.05, (float) 31.25, "Egypt"));
        cities.add(new City(31, "Madrid", (float) 40.4, (float) -3.6834, "Spain"));
        cities.add(new City(32, "Paris", (float) 48.8667, (float) 2.3333, "France"));
        cities.add(new City(33, "London", (float) 51.5, (float) -0.1167, "United Kingdom"));
        cities.add(new City(34, "Hong Kong", (float) 22.305, (float) 114.185, "Hong Kong"));
        cities.add(new City(35, "Jakarta", (float) -6.1744, (float) 106.8294, "Indonesia"));
        cities.add(new City(36, "Ahmedabad", (float) 23.0301, (float) 72.58, "India"));
        cities.add(new City(37, "Mumbai", (float) 19.017, (float) 72.857, "India"));
        cities.add(new City(38, "Bangalore", (float) 12.97, (float) 77.56, "India"));
        cities.add(new City(39, "Hyderabad", (float) 17.4, (float) 78.48, "India"));
        cities.add(new City(40, "Chennai", (float) 13.09, (float) 80.28, "India"));
        cities.add(new City(41, "Kolkata", (float) 22.495, (float) 88.3247, "India"));
        cities.add(new City(42, "Delhi", (float) 28.67, (float) 77.23, "India"));
        cities.add(new City(43, "Baghdad", (float) 33.3386, (float) 44.3939, "Iraq"));
        cities.add(new City(44, "Tehran", (float) 35.6719, (float) 51.4243, "Iran"));
        cities.add(new City(45, "Tokyo", (float) 35.685, (float) 139.7514, "Japan"));
        cities.add(new City(46, "Osaka", (float) 34.75, (float) 135.4601, "Japan"));
        cities.add(new City(47, "Seoul", (float) 37.5663, (float) 126.9997, "South Korea"));
        cities.add(new City(48, "Washington", (float) 38.9047, (float) -77.0163, "United States"));
        cities.add(new City(49, "Miami", (float) 25.784, (float) -80.2102, "United States"));
        cities.add(new City(50, "Dallas", (float) 32.7938, (float) -96.7659, "United States"));
        cities.add(new City(51, "Houston", (float) 29.7871, (float) -95.3936, "United States"));
        cities.add(new City(52, "New York", (float) 40.6943, (float) -73.9249, "United States"));
        cities.add(new City(53, "Philadelphia", (float) 40.0076, (float) -75.134, "United States"));
        cities.add(new City(54, "Los Angeles", (float) 34.114, (float) -118.407, "United States"));
        cities.add(new City(55, "Chicago", (float) 41.8373, (float) -87.6861, "United States"));
        cities.add(new City(56, "Atlanta", (float) 33.7627, (float) -84.4231, "United States"));
    }
}
