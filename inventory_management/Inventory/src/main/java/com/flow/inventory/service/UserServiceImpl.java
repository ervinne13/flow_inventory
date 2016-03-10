/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.service;

import com.flow.inventory.beans.LoginBean.Validity;
import com.flow.inventory.dao.UserDao;
import com.flow.inventory.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ervinne Sodusta
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Validity getValidity(String email, String password) {
        User user = userDao.getUserByEmail(email);

        if (user != null) {
            //  check password

            //  TODO: add encryption
            if (user.getPassword().equals(password)) {
                return Validity.VALID;
            } else {
                return Validity.INCORRECT_PASSWORD;
            }

        } else {
            return Validity.UNREGISTERED;
        }

    }

}
