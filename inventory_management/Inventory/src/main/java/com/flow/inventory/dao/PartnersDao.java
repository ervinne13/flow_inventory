/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.dao;

import com.flow.inventory.model.Partner;
import java.util.List;

/**
 *
 * @author Ervinne Sodusta
 */
public interface PartnersDao {

    List<Partner> listVendors();

    void addPartner(Partner partner);

}
