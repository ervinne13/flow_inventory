/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.dao;

import com.flow.inventory.model.Item;
import java.util.List;

/**
 *
 * @author Ervinne Sodusta
 */
public interface ItemsDao {

    Item getById(long id);

    List<Item> listPartial(int offset, int fetchCount);

    void save(Item item);
    
}
