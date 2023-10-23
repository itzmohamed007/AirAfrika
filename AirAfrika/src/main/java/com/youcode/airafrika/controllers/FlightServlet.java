package com.youcode.airafrika.controllers;

import com.youcode.airafrika.models.Flight;
import com.youcode.airafrika.services.FlightService;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
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

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "create": {
                Flight flight = extractFlight(request);
                if(flightService.createFlight(flight))
                    response.sendRedirect(request.getContextPath() + "/views/admin/success.jsp");
                else
                    response.sendRedirect(request.getContextPath() + "/views/admin/error.jsp");
                break;
            }
            case "update": {
                doPut(request, response);
                break;
            }
            case "delete": {
                doDelete(request, response);
                break;
            }
            default: {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                break;
            }
        }
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Flight flight = extractFlight(request);
        if(flightService.updateFlight(flight))
            response.sendRedirect(request.getContextPath() + "/views/admin/success.jsp");
        else
            response.sendRedirect(request.getContextPath() + "/views/admin/error.jsp");
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID uuid = UUID.fromString(request.getParameter("uuid"));
        if(flightService.deleteFlight(uuid))
            response.sendRedirect(request.getContextPath() + "/views/admin/success.jsp");
        else
            response.sendRedirect(request.getContextPath() + "/views/admin/error.jsp");
    }

    private boolean isAdminAuthenticated(HttpServletRequest request) {
        if (request.getSession().getAttribute("isAuthenticated") != null) {
            return Boolean.parseBoolean(request.getSession().getAttribute("isAuthenticated").toString());
        } else {
            request.getSession().setAttribute("isAuthenticated", false);
            return false;
        }
    }

    private Flight extractFlight(HttpServletRequest request) {
        Flight flight = new Flight();
        flight.setUuid(UUID.fromString(request.getParameter("uuid")));
        UUID uuid = UUID.fromString(request.getParameter("uuid"));
        flight.setDepartureCity(request.getParameter("departure-city"));
        flight.setArrivalCity(request.getParameter("arrival-city"));
        flight.setDepartureDate(LocalDate.parse(request.getParameter("departure-date")));
        flight.setArrivalDate(LocalDate.parse(request.getParameter("arrival-date")));
        flight.setDepartureTime(LocalTime.parse(request.getParameter("departure-time")));
        flight.setArrivalTime(LocalTime.parse(request.getParameter("arrival-time")));
        flight.setSeatsNumber(Integer.parseInt(request.getParameter("seats-number")));
        flight.setPrice(Float.parseFloat(request.getParameter("price")));
        flight.setDescription(request.getParameter("description"));
        return flight;
    }
}
