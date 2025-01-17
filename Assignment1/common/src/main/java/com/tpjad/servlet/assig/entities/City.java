package com.tpjad.servlet.assig.entities;

public class City implements Comparable {

    private int id;
    private String name;
    private String country;
    private float latitude;
    private float longitude;

    public City() {
        super();
    }

    public City(int id, String name, float latitude, float longitude, String country) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
    }

    public City(int id, String name, String country, float latitude, float longitude) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (!(o instanceof City)) return -1;
        return getName().compareTo(((City) o).getName());
    }
}
