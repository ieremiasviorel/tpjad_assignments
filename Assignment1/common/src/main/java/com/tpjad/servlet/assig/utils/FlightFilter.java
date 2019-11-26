package com.tpjad.servlet.assig.utils;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class FlightFilter {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private String departureCountry;
    private String departureCity;
    private String arrivalCountry;
    private String arrivalCity;
    private Date departureStartDate;
    private Date departureEndDate;

    public FlightFilter() {
        super();
    }

    public FlightFilter(String departureCountry, String departureCity, String arrivalCountry, String arrivalCity, Date departureStartDate, Date departureEndDate) {
        super();
        this.departureCountry = departureCountry;
        this.departureCity = departureCity;
        this.arrivalCountry = arrivalCountry;
        this.arrivalCity = arrivalCity;
        this.departureStartDate = departureStartDate;
        this.departureEndDate = departureEndDate;
    }

    public String getDepartureCountry() {
        return departureCountry;
    }

    public void setDepartureCountry(String departureCountry) {
        this.departureCountry = departureCountry;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCountry() {
        return arrivalCountry;
    }

    public void setArrivalCountry(String arrivalCountry) {
        this.arrivalCountry = arrivalCountry;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Date getDepartureStartDate() {
        return departureStartDate;
    }

    public void setDepartureStartDate(Date departureStartDate) {
        this.departureStartDate = departureStartDate;
    }

    public Date getDepartureEndDate() {
        return departureEndDate;
    }

    public void setDepartureEndDate(Date departureEndDate) {
        this.departureEndDate = departureEndDate;
    }

    @Override
    public String toString() {
        return "FlightFilter{" +
                "departureCountry='" + departureCountry + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCountry='" + arrivalCountry + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", departureStartDate=" + departureStartDate +
                ", departureEndDate=" + departureEndDate +
                '}';
    }
}
