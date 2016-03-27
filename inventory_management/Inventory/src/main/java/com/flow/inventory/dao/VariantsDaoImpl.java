/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.dao;

import com.flow.inventory.model.Variant;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ervinne Sodusta
 */
@Repository("variantsDao")
public class VariantsDaoImpl implements VariantsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Variant> listVariants(int offset, int fetchCount, String filter) {

        Query query;

        if (filter != null) {
            query = sessionFactory.getCurrentSession().getNamedQuery("Variant.findFiltered");
            query.setString("filter", filter);
        } else {
            query = sessionFactory.getCurrentSession().getNamedQuery("Variant.findWithRange");
        }

        query.setInteger("offset", offset);
        query.setInteger("fetchCount", fetchCount);

        return query.list();

    }

    @Override
    public void saveVariant(Variant variant) {
        sessionFactory.getCurrentSession().saveOrUpdate(variant);
    }

}
