/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.dao;

import com.flow.inventory.model.Item;
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
@Repository("itemsDao")
public class ItemsDaoImpl implements ItemsDao {

    public static final String TABLE_NAME = "items";

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Item getById(long id) {
        return (Item) sessionFactory.getCurrentSession().get(Item.class, id);
    }

    @Override
    public List<Item> listPartial(int offset, int fetchCount) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM " + TABLE_NAME);
        query.setFirstResult(offset);
        query.setMaxResults(fetchCount);

        List<Item> items = query.list();

        return items;

    }

    @Override
    public void save(Item item) {
        sessionFactory.getCurrentSession().saveOrUpdate(item);
    }

}
