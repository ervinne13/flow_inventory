/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.service;

import com.flow.inventory.dao.PartnersDao;
import com.flow.inventory.model.Partner;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ervinne Sodusta
 */
@Service("partnersService")
public class PartnersServiceImpl implements PartnersService {

    @Autowired
    private PartnersDao partnersDao;

    @Override
    @Transactional
    public List<Partner> listPartners() {
        return partnersDao.listPartners();
    }

    @Override
    @Transactional
    public List<Partner> listVendors() {
        return partnersDao.listVendors();
    }

    @Override
    @Transactional
    public Partner getById(int id) {
        return partnersDao.getById(id);
    }

    @Override
    @Transactional
    public void addPartner(Partner partner) {
        partnersDao.addPartner(partner);
    }

    @Override
    @Transactional
    public void updatePartner(Partner partner) {
        partnersDao.updatePartner(partner);
    }

}
