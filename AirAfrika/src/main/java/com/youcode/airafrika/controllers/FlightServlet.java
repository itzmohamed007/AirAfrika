package com.youcode.airafrika.controllers;

import com.youcode.airafrika.models.Flight;
import com.youcode.airafrika.services.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name="/FlightServlet", value="/flight")
public class FlightServlet extends HttpServlet {
    private FlightService flightService;

    @Override
    public void init() throws ServletException {
        super.init();
        flightService = new FlightService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            // not action specified => return all flights
            List<Flight> flights = flightService.getAll();
            request.setAttribute("flights", flights);
            request.getRequestDispatcher("/views/flights.jsp").forward(request, response);
        } else if(action.equals("view")) {
            // action specified => return wanted flight
            String uuid = request.getParameter("uuid");
            Flight flight = flightService.getFlight(uuid);
            if(flight != null) {
                request.setAttribute("flight", flight);
                request.getRequestDispatcher("/views/flight.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/flights");
            }
        } else {
            // bad request
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
