/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.controller;

import com.flow.inventory.adapters.JsonView;
import com.flow.inventory.model.Partner;
import com.flow.inventory.service.PartnersService;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Ervinne Sodusta
 */
@Controller
@RequestMapping("/partners")
public class PartnersController {

    @Autowired
    private PartnersService partnersService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {

        List<Partner> partners = partnersService.listPartners();

        ModelAndView mv = new ModelAndView("/partners/index");
        mv.addObject("partners", partners);

        return mv;
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public ModelAndView create() {

        ModelAndView mv = new ModelAndView("/partners/create");
        mv.addObject("partner", new Partner());

        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView store(HttpServletRequest request, HttpServletResponse response, @RequestBody Partner partner) {

        String responseType = request.getParameter("responseType");

        System.out.println("store");
        System.out.println(partner.getName());

        try {
            partnersService.addPartner(partner);
        } catch (javax.validation.ConstraintViolationException e) {
            //  TODO: return error here about constraint violation
            e.printStackTrace();
        }

        if (responseType != null && "JSON".equals(responseType.toUpperCase())) {
            return JsonView.Render(partner, response);
        } else {
            return new ModelAndView("redirect:partners/edit/" + 1);
        }

    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public Object edit(@PathVariable("id") String id) {

        Partner partner;
        ModelAndView mv;

        try {
            partner = partnersService.getById(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Bad request, id is not numeric", HttpStatus.BAD_REQUEST);
        }

        if (partner != null) {
            mv = new ModelAndView("/partners/edit");
            mv.addObject("partner", partner);

            return mv;
        } else {
            return new ResponseEntity<>("Partner not found", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Object update(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id, @RequestBody Partner partner) {

        String responseType = request.getParameter("responseType");

        try {
            partner.setId(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            return new ResponseEntity<>("Bad request, id is not numeric", HttpStatus.BAD_REQUEST);
        }

        partnersService.updatePartner(partner);

        if (responseType != null && "JSON".equals(responseType.toUpperCase())) {
            return JsonView.Render(partner, response);
        } else {
            return new ModelAndView("redirect:partners/edit/" + 1);
        }

    }

}
