/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.dao;

import com.flow.inventory.model.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ervinne Sodusta
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    public static final String TABLE = "User";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public List<User> listUsers() {
        try {
            sessionFactory.getCurrentSession().beginTransaction();
            List<User> users = sessionFactory.getCurrentSession().createCriteria(User.class).list();

            System.out.println("User Count: " + users.size());

            users.stream().forEach((user) -> {
                System.out.println("User: " + user.getEmail());
            });

            return users;
        } finally {
            sessionFactory.getCurrentSession().close();
        }
    }

    @Override
    public User getUserById(int id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User getUserByEmail(String email) {
        String hql = "from " + TABLE + " where email = :email";
        Session session = null;

        try {

//            session = sessionFactory.openSession();
            session = sessionFactory.getCurrentSession();
            Query query = session.createQuery(hql);
            query.setParameter("email", email);
            List<User> users = query.list();

            System.out.println("Executed getUserByEmail:" + query.getQueryString());

            if (users.size() > 0) {
                return users.get(0);
            } else {
                return null;
            }
        } finally {
//            if (session != null && session.isOpen()) {
//                session.close();
//                session = null;
//            }
        }
    }

}
