/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.controller;

import com.flow.inventory.dao.UnitOfMeasurementDao;
import com.flow.inventory.model.Item;
import com.flow.inventory.service.UnitOfMeasurementService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ervinne Sodusta
 */
@Controller()
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private UnitOfMeasurementService unitOfMeasurementService;

    /*
     index
     show
     create
     store
     edit
     update
     delete
    
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)    
    public ModelAndView create() {
        ModelAndView mv = new ModelAndView("items/create");

        mv.addObject("itemBean", new Item());
        mv.addObject("uomList", unitOfMeasurementService.listUOM());

        return mv;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView store(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("itemBean") Item item) {

        System.out.println(item.getName());

        return new ModelAndView("index");
    }

}
