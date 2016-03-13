/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.controller;

import com.flow.inventory.adapter.UserAdapter;
import com.flow.inventory.beans.LoginBean;
import com.flow.inventory.beans.LoginBean.Validity;
import com.flow.inventory.model.User;
import com.flow.inventory.service.UserService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ervinne Sodusta
 */
@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin() {

        ModelAndView mv = new ModelAndView("auth/login");

        LoginBean loginBean = new LoginBean();
        mv.addObject("loginBean", loginBean);

        return mv;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean") LoginBean loginBean) {

        Validity validity = userService.authenticate(loginBean.getEmail(), loginBean.getPassword());

        if (validity == Validity.VALID) {
            System.out.println("Valid!");
            return new ModelAndView("redirect:/");
        } else {
            System.out.println("Login Failed!");
            loginBean.setValidity(validity);
            Map<String, Object> model = new HashMap<>();
            model.put("loginBean", loginBean);
            return new ModelAndView("auth/login", model);
        }

    }

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<Object> apiLogin(@RequestParam("email") String email, @RequestParam("password") String password) {

        Validity validity = userService.authenticate(email, password);

        switch (validity) {
            case VALID:
                System.out.println("Valid!");
                User authenticatedUser = userService.getCurrentlyAuthenticatedUser();
                return new ResponseEntity<>(UserAdapter.toMultiValueMap(authenticatedUser), HttpStatus.OK);
            case UNREGISTERED:
                return new ResponseEntity<>("Unregistered email", HttpStatus.BAD_REQUEST);
            case INCORRECT_PASSWORD:
                return new ResponseEntity<>("Incorrect password", HttpStatus.BAD_REQUEST);
            default:
                return new ResponseEntity<>("Unknown error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
