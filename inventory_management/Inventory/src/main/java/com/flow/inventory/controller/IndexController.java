/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.controller;

import com.flow.inventory.model.User;
import com.flow.inventory.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ervinne Sodusta
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {        

        ModelAndView mv = new ModelAndView("index");

        User authenticatedUser = userService.getCurrentlyAuthenticatedUser();
        if (authenticatedUser == null) {
            throw new RuntimeException("Authenticated user null on access: please check your security configuration or the userService implementation.");
        }

        mv.addObject("authenticatedUser", authenticatedUser);

        return mv;
    }

    @RequestMapping(value = "/denied")
    public ResponseEntity<?> denied() {
        System.out.println("403");
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

}
