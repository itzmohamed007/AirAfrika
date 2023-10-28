package com.youcode.airafrika.DAOimplementation;

import com.youcode.airafrika.Utilities.HibernateUtil;
import com.youcode.airafrika.dao.Dao;
import com.youcode.airafrika.models.Reservation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.UUID;

public class ReservationDAO implements Dao<Reservation> {
    private final SessionFactory sessionFactory;

    public ReservationDAO () {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    @Override
    public boolean create(Reservation reservation) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(reservation);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("something went wrong while creating new reservation record");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Reservation get(UUID uuid) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, uuid);
            session.getTransaction().commit();
            return reservation;
        } catch (Exception e) {
            System.out.println("something went wrong while fetching reservation record");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reservation> getAll() {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String hql = "FROM Reservation";
            List<Reservation> reservations = session.createQuery(hql, Reservation.class).list();
            session.getTransaction().commit();
            return reservations;
        } catch (Exception e) {
            System.out.println("something went wrong while fetching reservation records");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Reservation reservation) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Reservation oldReservation = session.get(Reservation.class, reservation.getUuid());
            if(oldReservation == null)
                return false;
            session.merge(reservation);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("something went wrong while updating reservation record");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(UUID uuid) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, uuid);
            if(reservation== null) {
                return false;
            }
            session.remove(reservation);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("something went wrong while deleting flight record");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
