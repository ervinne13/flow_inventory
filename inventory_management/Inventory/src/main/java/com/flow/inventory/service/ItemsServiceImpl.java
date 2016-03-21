/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.service;

import com.flow.inventory.dao.ItemsDao;
import com.flow.inventory.model.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ervinne Sodusta
 */
@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsDao itemsDao;

    @Override
    @Transactional
    public Item getById(long id) {
        return itemsDao.getById(id);
    }

    @Override
    public List<Item> listPartial(int offset, int fetchCount) {
        return itemsDao.listPartial(offset, fetchCount);
    }

    @Override
    public void save(Item item) {
        itemsDao.save(item);
    }

}
