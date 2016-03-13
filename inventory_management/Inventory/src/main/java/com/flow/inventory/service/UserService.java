/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.service;

import com.flow.inventory.beans.LoginBean.Validity;
import com.flow.inventory.dao.UserDao;
import com.flow.inventory.model.User;

/**
 *
 * @author Ervinne Sodusta
 */
public interface UserService {

    public User getCurrentlyAuthenticatedUser();
    
    public Validity authenticate(String email, String password);

    public void registerUser(User user) throws UserDao.UserDaoException;

}
