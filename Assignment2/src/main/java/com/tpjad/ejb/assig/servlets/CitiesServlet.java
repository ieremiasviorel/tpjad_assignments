package com.tpjad.ejb.assig.servlets;

import com.tpjad.ejb.assig.beans.interfaces.CityServiceLocal;
import com.tpjad.ejb.assig.entities.City;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/city")
public class CitiesServlet extends HttpServlet {
    @EJB
    private CityServiceLocal cityService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        List<City> citiesByCountry = this.cityService.getByCountry(country);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        StringBuilder textResponse = new StringBuilder();
        for (City c : citiesByCountry) {
            textResponse.append("\"").append(c.getName()).append("\", ");
        }
        textResponse = new StringBuilder("[" + textResponse.substring(0, textResponse.length() - 2) + "]");
        out.println(textResponse);
    }
}
