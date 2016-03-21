/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.controller;

import com.flow.inventory.model.Item;
import com.flow.inventory.service.ItemsService;
import com.flow.inventory.service.UnitOfMeasurementService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    private ItemsService itemsService;

    @Autowired
    private UnitOfMeasurementService unitOfMeasurementService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("items/index");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView show(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") long id) {
        System.out.println("ID: " + id);
        return new ModelAndView("items/index");
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mv = new ModelAndView("items/create");

        Item blankItem = new Item();

        blankItem.setPurchaseValue(0);
        blankItem.setSaleValue(0);

        mv.addObject("itemBean", blankItem);
        mv.addObject("uomList", unitOfMeasurementService.listUOM());

        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView store(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("itemBean") Item item) {

        //  TODO: Add validation here
        itemsService.save(item);

        return new ModelAndView("redirect:items");
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id) {
        ModelAndView mv = new ModelAndView("items/update");

        Item blankItem = new Item();

        blankItem.setPurchaseValue(0);
        blankItem.setSaleValue(0);

        mv.addObject("itemBean", blankItem);
        mv.addObject("uomList", unitOfMeasurementService.listUOM());

        return mv;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ModelAndView update(@PathVariable("id") String id, @RequestBody Item item) {

        System.out.println(item.getName());

        return new ModelAndView("redirect:items/" + id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {

        System.out.println("Delete: " + id);

    }

}
