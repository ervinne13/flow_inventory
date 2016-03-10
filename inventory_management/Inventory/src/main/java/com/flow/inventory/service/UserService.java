/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.service;

import com.flow.inventory.beans.LoginBean.Validity;

/**
 *
 * @author Ervinne Sodusta
 */
public interface UserService {

    public Validity getValidity(String email, String password);

}
