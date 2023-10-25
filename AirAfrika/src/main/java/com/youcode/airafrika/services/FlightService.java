package com.youcode.airafrika.services;

import com.youcode.airafrika.DAOimplementation.FlightDAO;
import com.youcode.airafrika.models.Flight;
import com.youcode.airafrika.Utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class FlightService {
    private final FlightDAO flightDAO;

    public FlightService () {
        flightDAO = new FlightDAO();
    }

    public boolean createFlight(Flight flight) {
        return flightDAO.create(flight);
    }

    public Flight getFlight(UUID uuid) {
        return flightDAO.get(uuid);
    }

    public List<Flight> getAll() {
        return flightDAO.getAll();
    }

    public boolean updateFlight(Flight newFlight) {
        return flightDAO.update(newFlight);
    }

    public boolean deleteFlight(UUID uuid) {
        return flightDAO.delete(uuid);
    }
}
