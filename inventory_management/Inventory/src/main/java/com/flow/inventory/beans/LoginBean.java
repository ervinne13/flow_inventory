/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.beans;

import java.io.Serializable;

/**
 *
 * @author Ervinne Sodusta
 */
public class LoginBean implements Serializable {

    public enum Validity {

        NOT_CHECKED, VALID, UNREGISTERED, INCORRECT_PASSWORD
    }

    private String email;
    private String password;

    private Validity validity;

    public LoginBean() {
        validity = Validity.NOT_CHECKED;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Validity getValidity() {
        return validity;
    }

    public void setValidity(Validity validity) {
        this.validity = validity;
    }

}
