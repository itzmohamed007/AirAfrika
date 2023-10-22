package com.youcode.airafrika.services;

import com.youcode.airafrika.models.Flight;
import com.youcode.airafrika.utils.HibernateUtil;
import com.youcode.airafrika.utils.LocalStorage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.UUID;

public class FlightService {
    private final SessionFactory sessionFactory;

    public FlightService () {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public boolean createFlight(Flight flight) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(flight);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("something went wrong while inserting new flight record");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public Flight getFlight(UUID uuid) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Flight flight = session.get(Flight.class, uuid);
            session.getTransaction().commit();
            return flight;
        } catch (Exception e) {
            System.out.println("something went wrong while fetching flight record");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateFlight(Flight newFlight) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Flight oldFlight = session.get(Flight.class, newFlight.getUuid());
            if(oldFlight == null)
                return false;
            session.merge(newFlight);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("something went wrong while updating flight record");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFlight(UUID uuid) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Flight flight = session.get(Flight.class, uuid);
            if(flight == null) {
                return false;
            }
            session.remove(flight);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("something went wrong while deleting flight record");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Flight> getAll() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String hql = "FROM Flight";
            Query<Flight> query = session.createQuery(hql, Flight.class);
            List<Flight> flights = query.list();
            session.getTransaction().commit();
            return flights;
        } catch (Exception e) {
            System.out.println("something went wrong while fetching flights records");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
