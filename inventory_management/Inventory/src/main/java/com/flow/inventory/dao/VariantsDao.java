/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.dao;

import com.flow.inventory.model.Variant;
import java.util.List;

/**
 *
 * @author Ervinne Sodusta
 */
public interface VariantsDao {

    public List<Variant> listVariants(int offset, int fetchCount, String filter);

    public void saveVariant(Variant variant);

}
