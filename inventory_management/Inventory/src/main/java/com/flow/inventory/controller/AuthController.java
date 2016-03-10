/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.controller;

import com.flow.inventory.beans.LoginBean;
import com.flow.inventory.beans.LoginBean.Validity;
import com.flow.inventory.service.UserService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

        Validity validity = userService.getValidity(loginBean.getEmail(), loginBean.getPassword());

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

}
