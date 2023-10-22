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
import java.util.UUID;

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
        if(isAdminAuthenticated(request)) {
            System.out.println("isAuthentiatedValue: " + request.getSession().getAttribute("isAuthenticated"));
            String action = request.getParameter("action");
            if(action == null) {
                action = "list";
            }
            switch (action) {
                case "list": {
                    List<Flight> flights = flightService.getAll();
                    request.setAttribute("flights", flights);
                    request.getRequestDispatcher("/views/admin/flights.jsp").forward(request, response);
                    break;
                }
                case "create": {
                    request.getRequestDispatcher("/views/admin/create-flight.jsp").forward(request, response);
                    break;
                }
                case "update": {
                    String uuid = request.getParameter("uuid");
                    Flight flight = flightService.getFlight(UUID.fromString(uuid));
                    if(flight != null) {
                        request.setAttribute("flight", flight);
                        request.getRequestDispatcher("/views/admin/update-flight.jsp").forward(request, response);
                    } else {
                        response.sendRedirect(request.getContextPath() + "/index");
                    }
                    break;
                }
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    break;
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    private boolean isAdminAuthenticated(HttpServletRequest request) {
        if (request.getSession().getAttribute("isAuthenticated") != null) {
            return Boolean.parseBoolean(request.getSession().getAttribute("isAuthenticated").toString());
        } else {
            request.getSession().setAttribute("isAuthenticated", false);
            return false;
        }
    }
}
