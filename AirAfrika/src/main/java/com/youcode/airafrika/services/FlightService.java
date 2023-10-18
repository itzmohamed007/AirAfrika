package com.youcode.airafrika.services;

import com.youcode.airafrika.models.Flight;
import com.youcode.airafrika.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class FlightService {
    private final SessionFactory sessionFactory;

    public FlightService () {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public boolean createFlight(Flight flight) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
//            session.save(flight); the save method is deprecated (replaced with more efficient methods) because its behavior can be ambiguous sometimes
            session.persist(flight);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("something went wrong while inserting new flight record");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Flight getFlight(String uuid) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Flight flight = session.get(Flight.class, uuid);
            session.getTransaction().commit();
            return flight;
        } catch (Exception e) {
            System.out.println("something went wrong while fetching flight record");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean updateFlight(Flight newFlight, String uuid) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Flight oldFlight = session.get(Flight.class, uuid);
            if(oldFlight == null) {
                return false;
            }
            Flight.updateFlight(oldFlight, newFlight);
            session.merge(newFlight);

            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("something went wrong while updating flight record");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteFlight(String uuid) {
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
            return null;
        }
    }
}
