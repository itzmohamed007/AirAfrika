package com.youcode.airafrika.controllers;

import com.youcode.airafrika.models.Reservation;
import com.youcode.airafrika.services.ReservationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/booking")
public class ReservationServlet extends HttpServlet {
    private ReservationService reservationService;

    @Override
    public void init() {
        reservationService = new ReservationService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null)
            action = "list";
        switch (action) {
            case "list": {
                request.setAttribute("reservations", reservationService.getAll());
                request.getRequestDispatcher("/views/reservation/reservations.jsp").forward(request, response);
                break;
            }
            case "view": {
                UUID uuid = UUID.fromString(request.getParameter("uuid"));
                Reservation reservation = reservationService.getReservation(uuid);
                request.setAttribute("reservation", reservation);
                request.getRequestDispatcher("/views/reservation/reservation.jsp").forward(request, response);
                break;
            }
        }
    }
}
