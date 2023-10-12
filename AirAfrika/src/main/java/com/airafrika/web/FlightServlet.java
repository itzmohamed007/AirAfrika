package com.airafrika.web;

import com.airafrika.dao.FlightDAO;
import com.airafrika.model.Flight;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class FlightServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlightDAO flightDAO = new FlightDAO();
        Flight flight = flightDAO.getFlight("2071772f-063e-4bb5-93a5-8c23874c31e1"); // Replace 1 with the ID of the flight you want to retrieve.

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Flight Details</h1>");
        out.println("<p>UUID: " + flight.getUuid() + "</p>");
        out.println("<p>Departure City: " + flight.getDepartureCity() + "</p>");
        // Add more properties as needed
        out.println("</body></html>");
    }
}
