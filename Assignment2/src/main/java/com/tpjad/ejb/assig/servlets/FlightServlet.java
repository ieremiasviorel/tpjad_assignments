package com.tpjad.ejb.assig.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tpjad.ejb.assig.beans.interfaces.FlightServiceLocal;
import com.tpjad.ejb.assig.entities.Flight;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flight")
public class FlightServlet extends HttpServlet {
    @EJB
    private FlightServiceLocal flightService;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightNumber = request.getParameter("flightNumber");
        Flight flight = this.flightService.getByFlightNumber(flightNumber);

        response.setContentType("text/json");
        PrintWriter out = response.getWriter();
        objectMapper.writeValue(out, flight);
    }
}
