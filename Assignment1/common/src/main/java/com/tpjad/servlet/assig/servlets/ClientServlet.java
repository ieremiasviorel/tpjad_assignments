package com.tpjad.servlet.assig.servlets;

import com.tpjad.servlet.assig.entities.City;
import com.tpjad.servlet.assig.entities.Flight;
import com.tpjad.servlet.assig.services.CityServiceImpl;
import com.tpjad.servlet.assig.services.FlightServiceImpl;
import com.tpjad.servlet.assig.utils.FlightFilter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("")
public class ClientServlet extends HttpServlet {

    private static final long serialVersionUID = 183010968341969780L;
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private FlightServiceImpl flightService;
    private CityServiceImpl cityService;

    @Override
    public void init() {
        this.flightService = new FlightServiceImpl();
        this.cityService = new CityServiceImpl();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/client-home.jsp");

        List<Flight> flights = this.flightService.getAll();
        request.setAttribute("flights", flights);

        List<String> countries = this.flightService.getCountriesWithFlights();
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
        String departureDateStartStr = request.getParameter("departure_date_start");
        if (departureDateStartStr != null && !departureDateStartStr.isEmpty()) {
            flightFilter.setDepartureStartDate(Date.valueOf(departureDateStartStr));

        }
        String departureDateEndStr = request.getParameter("departure_date_end");
        if (departureDateEndStr != null && !departureDateEndStr.isEmpty()) {
            flightFilter.setDepartureEndDate(Date.valueOf(departureDateEndStr));

        }
        request.setAttribute("flightFilter", flightFilter);

        List<String> countries = this.flightService.getCountriesWithFlights();
        request.setAttribute("countries", countries);

        if (flightFilter.getDepartureCountry() != null && !flightFilter.getDepartureCountry().isEmpty()) {
            List<City> departureCities = this.cityService.getByCountry(flightFilter.getDepartureCountry());
            request.setAttribute("departureCities", departureCities);
        } else {
            request.setAttribute("departureCities", null);
        }

        if (flightFilter.getArrivalCountry() != null && !flightFilter.getArrivalCountry().isEmpty()) {
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
