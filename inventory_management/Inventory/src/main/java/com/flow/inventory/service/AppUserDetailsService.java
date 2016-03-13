/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.service;

import com.flow.inventory.adapters.UserAdapter;
import com.flow.inventory.dao.UserDao;
import com.flow.inventory.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ervinne Sodusta
 */
@Service("appUserDetailsService")
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.getUserByEmail(username);

        if (user != null) {
            System.out.println("User: " + user.getEmail());
            return UserAdapter.toUserDetails(user);
        } else {
            System.out.println("User " + username + " not found");
            throw new UsernameNotFoundException(username);
        }
    }

}
