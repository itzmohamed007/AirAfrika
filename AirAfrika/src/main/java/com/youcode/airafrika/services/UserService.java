package com.youcode.airafrika.services;

import com.youcode.airafrika.models.User;
import com.youcode.airafrika.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        users = session.createQuery("FROM User", User.class).list();
        return users;
    }
}
