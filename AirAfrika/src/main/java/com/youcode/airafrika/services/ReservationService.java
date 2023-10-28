package com.youcode.airafrika.services;

import com.youcode.airafrika.DAOimplementation.ReservationDAO;
import com.youcode.airafrika.models.Reservation;

import java.util.List;
import java.util.UUID;

public class ReservationService {
    private final ReservationDAO reservationDAO;

    public ReservationService () {
        reservationDAO = new ReservationDAO();
    }

    public boolean createReservation(Reservation reservation) {
        return reservationDAO.create(reservation);
    }

    public Reservation getReservation(UUID uuid) {
        return reservationDAO.get(uuid);
    }

    public List<Reservation> getAll() {
        return reservationDAO.getAll();
    }

    public boolean update(Reservation reservation) {
        return reservationDAO.update(reservation);
    }

    public boolean delete(UUID uuid) {
        return reservationDAO.delete(uuid);
    }
}
