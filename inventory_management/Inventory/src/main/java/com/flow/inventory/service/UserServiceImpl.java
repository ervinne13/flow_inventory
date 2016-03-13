/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.service;

import com.flow.inventory.beans.LoginBean.Validity;
import com.flow.inventory.dao.UserDao;
import com.flow.inventory.dao.UserDao.UserDaoException;
import com.flow.inventory.model.User;
import com.flow.inventory.model.UserRole;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ervinne Sodusta
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getCurrentlyAuthenticatedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        return userDao.getUserByEmail(email);

    }

    @Override
    @Transactional
    public Validity authenticate(String email, String password) {
        User user = userDao.getUserByEmail(email);

        if (user != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            if (passwordEncoder.matches(password, user.getPassword())) {
                List<GrantedAuthority> authorizations = new ArrayList<>();
                Set<UserRole> roles = user.getUserRoles();

                roles.stream().forEach((role) -> {
                    authorizations.add(new SimpleGrantedAuthority(role.getRoleName()));
                });

                Authentication token = new UsernamePasswordAuthenticationToken(email, password, authorizations);
                SecurityContextHolder.getContext().setAuthentication(token);
                return Validity.VALID;
            } else {
                return Validity.INCORRECT_PASSWORD;
            }

        } else {
            return Validity.UNREGISTERED;
        }

    }

    @Override
    @Transactional
    public void registerUser(User user) throws UserDao.UserDaoException {
        User existingUser = userDao.getUserByEmail(user.getEmail());

        if (existingUser == null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            userDao.addUser(user);
        } else {
            String message = String.format("User with email %s already exists", user.getEmail());
            throw new UserDaoException(message);
        }

    }

}
