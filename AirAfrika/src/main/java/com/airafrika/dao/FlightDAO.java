package com.airafrika.dao;

import com.airafrika.model.Flight;
import com.airafrika.util.HibernateUTIL;
import jdk.jshell.spi.ExecutionControlProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Properties;

public class FlightDAO {
    // Get Flight
    public Flight getFlight(String id) {
        Transaction transaction = null;
        Flight flight = null;
        try (Session session = HibernateUTIL.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            flight = session.get(Flight.class, id);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("something went wrong while fetching flight object");
            e.printStackTrace();
        }
        return flight;
    }
}
