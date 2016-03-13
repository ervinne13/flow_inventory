/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.dao;

import com.flow.inventory.model.UnitOfMeasurement;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ervinne Sodusta
 */
@Repository("unitOfMeasurementDao")
public class UnitOfMeasurementDaoImpl implements UnitOfMeasurementDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<UnitOfMeasurement> listUOM() {
        List<UnitOfMeasurement> uomList = sessionFactory.getCurrentSession().createCriteria(UnitOfMeasurement.class).list();
        return uomList;
    }

}
