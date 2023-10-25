package com.youcode.airafrika.services;

import com.youcode.airafrika.models.Admin;
import com.youcode.airafrika.Utilities.HibernateUtil;
import com.youcode.airafrika.Utilities.LocalStorage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class AdminService {
    private final SessionFactory sessionFactory;

    public AdminService() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public boolean login(String email, String password) {
        try(Session session = sessionFactory.openSession())  {
            session.beginTransaction();
            String hql = "FROM Admin A WHERE A.email = :email";
            Admin admin = session.createQuery(hql, Admin.class).setParameter("email", email).uniqueResult();
            if(admin == null) {
                LocalStorage.getProperties().setProperty("allowAdmin", "false");
                return false;
            } else if(admin.getPassword().equals(String.valueOf(password.hashCode()))) {
                LocalStorage.getProperties().setProperty("allowAdmin", "true");
                return true;
            }
            session.getTransaction().commit();
            return false;
        } catch (Exception e) {
            System.out.println("something went wrong while connecting admin");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
