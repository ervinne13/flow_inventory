/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.service;

import com.flow.inventory.model.Partner;
import java.util.List;

/**
 *
 * @author Ervinne Sodusta
 */
public interface PartnersService {

    List<Partner> listPartners();

    List<Partner> listVendors();

    Partner getById(int id);

    void addPartner(Partner partner);

    void updatePartner(Partner partner);
}
