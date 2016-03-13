package com.flow.inventory.model;
// Generated Mar 10, 2016 2:37:53 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Address generated by hbm2java
 */
public class Address implements java.io.Serializable {

    private Integer id;
    private AddressType addressType;
    private String contactName;
    private String email;
    private String phone;
    private String mobile;
    private String address1;
    private String address2;
    private String website;
    private String notes;
    private Set partners = new HashSet(0);

    public Address() {
    }

    public Address(AddressType addressType, String contactName) {
        this.addressType = addressType;
        this.contactName = contactName;
    }

    public Address(AddressType addressType, String contactName, String email, String phone, String mobile, String address1, String address2, String website, String notes, Set partners) {
        this.addressType = addressType;
        this.contactName = contactName;
        this.email = email;
        this.phone = phone;
        this.mobile = mobile;
        this.address1 = address1;
        this.address2 = address2;
        this.website = website;
        this.notes = notes;
        this.partners = partners;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AddressType getAddressType() {
        return this.addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set getPartners() {
        return this.partners;
    }

    public void setPartners(Set partners) {
        this.partners = partners;
    }

}