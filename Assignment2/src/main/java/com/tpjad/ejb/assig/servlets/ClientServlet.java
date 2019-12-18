package com.tpjad.ejb.assig.servlets;


import com.tpjad.ejb.assig.beans.interfaces.CityServiceLocal;
import com.tpjad.ejb.assig.beans.interfaces.FlightServiceLocal;
import com.tpjad.ejb.assig.dtos.FlightFilter;
import com.tpjad.ejb.assig.entities.City;
import com.tpjad.ejb.assig.entities.Flight;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("")
public class ClientServlet extends HttpServlet {
    @EJB
    private FlightServiceLocal flightService;
    @EJB
    private CityServiceLocal cityService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/client-home.jsp");

        List<Flight> flights = this.flightService.getAll();
        request.setAttribute("flights", flights);

        List<String> countries = this.cityService.getAllCountries();
        request.setAttribute("countries", countries);

        rd.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FlightFilter flightFilter = new FlightFilter();

        flightFilter.setDepartureCountry(request.getParameter("departure_country"));
        flightFilter.setDepartureCity(request.getParameter("departure_city"));
        flightFilter.setArrivalCountry(request.getParameter("arrival_country"));
        flightFilter.setArrivalCity(request.getParameter("arrival_city"));
        if (!request.getParameter("departure_date_start").isEmpty()) {
            flightFilter.setDepartureStartDate(Date.valueOf(request.getParameter("departure_date_start")));
        }
        if (!request.getParameter("departure_date_end").isEmpty()) {
            flightFilter.setDepartureEndDate(Date.valueOf(request.getParameter("departure_date_end")));
        }
        if (!request.getParameter("arrival_date_start").isEmpty()) {
            flightFilter.setArrivalStartDate(Date.valueOf(request.getParameter("arrival_date_start")));
        }
        if (!request.getParameter("arrival_date_end").isEmpty()) {
            flightFilter.setArrivalEndDate(Date.valueOf(request.getParameter("arrival_date_end")));
        }

        request.setAttribute("flightFilter", flightFilter);

        List<String> countries = this.cityService.getAllCountries();
        request.setAttribute("countries", countries);

        if (!flightFilter.getDepartureCountry().isEmpty()) {
            List<City> departureCities = this.cityService.getByCountry(flightFilter.getDepartureCountry());
            request.setAttribute("departureCities", departureCities);
        } else {
            request.setAttribute("departureCities", null);
        }

        if (!flightFilter.getArrivalCountry().isEmpty()) {
            List<City> arrivalCities = this.cityService.getByCountry(flightFilter.getArrivalCountry());
            request.setAttribute("arrivalCities", arrivalCities);
        } else {
            request.setAttribute("arrivalCities", null);
        }

        List<Flight> flights = this.flightService.getByFilter(flightFilter);
        request.setAttribute("flights", flights);

        RequestDispatcher rd = request.getRequestDispatcher("/client-home.jsp");
        rd.forward(request, response);
    }
}
