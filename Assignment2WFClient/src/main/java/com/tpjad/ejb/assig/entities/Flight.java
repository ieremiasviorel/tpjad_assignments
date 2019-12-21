package com.tpjad.ejb.assig.entities;

import java.io.Serializable;
import java.util.Date;

public class Flight implements Serializable {
    private int id;
    private String flightNumber;
    private String airplaneType;
    private City departureCity;
    private Date departureDate;
    private City arrivalCity;
    private Date arrivalDate;

    public Flight() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) {
        this.airplaneType = airplaneType;
    }

    public City getDepartureCity() {
        return departureCity;
    }

    public String getDepartureCountry() {
        return departureCity.getCountry();
    }

    public void setDepartureCity(City departureCity) {
        this.departureCity = departureCity;
    }

    public City getArrivalCity() {
        return arrivalCity;
    }

    public String getArrivalCountry() {
        return arrivalCity.getCountry();
    }

    public void setArrivalCity(City arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
