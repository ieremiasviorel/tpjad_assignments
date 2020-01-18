package com.tpjad.servlet.assig.servlets;

import com.tpjad.servlet.assig.entities.City;
import com.tpjad.servlet.assig.services.CityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cities")
public class CitiesServlet extends HttpServlet {

    private static final long serialVersionUID = -2649091256199178934L;

    private CityServiceImpl cityService;

    @Override
    public void init() {
        this.cityService = new CityServiceImpl();
    }

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

    @Override
    public void destroy() {
    }
}
