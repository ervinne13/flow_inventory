/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.service;

import com.flow.inventory.dao.UnitOfMeasurementDao;
import com.flow.inventory.model.UnitOfMeasurement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ervinne Sodusta
 */
@Service("unitOfMeasurement")
public class UnitOfMeasurementServiceImpl implements UnitOfMeasurementService {

    @Autowired
    private UnitOfMeasurementDao unitOfMeasurementDao;

    @Override
    @Transactional
    public List<UnitOfMeasurement> listUOM() {
        return unitOfMeasurementDao.listUOM();
    }

}
