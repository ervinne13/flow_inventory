/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.service;

import com.flow.inventory.dao.VariantsDao;
import com.flow.inventory.model.Variant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ervinne Sodusta
 */
@Service("variantsService")
public class VariantsServiceImpl implements VariantsService {

    @Autowired
    private VariantsDao variantsDao;

    @Override
    public List<Variant> listVariants(int offset, int fetchCount, String filter) {
        return variantsDao.listVariants(offset, fetchCount, filter);
    }

    @Override
    public void saveVariant(Variant variant) {
        variantsDao.saveVariant(variant);
    }

}
