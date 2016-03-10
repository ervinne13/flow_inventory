/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.dao;

import com.flow.inventory.model.User;
import java.util.List;

/**
 *
 * @author Ervinne Sodusta
 */
public interface UserDao {

    void addUser(User user);

    List<User> listUsers();

    User getUserById(int id);

    User getUserByEmail(String email);

}
