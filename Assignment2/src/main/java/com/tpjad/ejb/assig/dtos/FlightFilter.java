package com.tpjad.ejb.assig.dtos;

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
    private Date arrivalStartDate;
    private Date arrivalEndDate;

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

    public FlightFilter(String departureCountry, String departureCity, String arrivalCountry, String arrivalCity, Date departureStartDate, Date departureEndDate, Date arrivalStartDate, Date arrivalEndDate) {
        this.departureCountry = departureCountry;
        this.departureCity = departureCity;
        this.arrivalCountry = arrivalCountry;
        this.arrivalCity = arrivalCity;
        this.departureStartDate = departureStartDate;
        this.departureEndDate = departureEndDate;
        this.arrivalStartDate = arrivalStartDate;
        this.arrivalEndDate = arrivalEndDate;
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

    public String getDepartureStartDateStr() {
        return departureStartDate != null ? dateFormat.format(departureStartDate) : "";
    }

    public void setDepartureStartDate(Date departureStartDate) {
        this.departureStartDate = departureStartDate;
    }

    public Date getDepartureEndDate() {
        return departureEndDate;
    }

    public String getDepartureEndDateStr() {
        return departureEndDate != null ? dateFormat.format(departureEndDate) : "";
    }

    public void setDepartureEndDate(Date departureEndDate) {
        this.departureEndDate = departureEndDate;
    }

    public Date getArrivalStartDate() {
        return arrivalStartDate;
    }

    public String getArrivalStartDateStr() {
        return arrivalStartDate != null ? dateFormat.format(arrivalStartDate) : "";
    }

    public void setArrivalStartDate(Date arrivalStartDate) {
        this.arrivalStartDate = arrivalStartDate;
    }

    public Date getArrivalEndDate() {
        return arrivalEndDate;
    }

    public String getArrivalEndDateStr() {
        return arrivalEndDate != null ? dateFormat.format(arrivalEndDate) : "";
    }

    public void setArrivalEndDate(Date arrivalEndDate) {
        this.arrivalEndDate = arrivalEndDate;
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
