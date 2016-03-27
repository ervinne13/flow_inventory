/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ervinne Sodusta
 */
@Entity
@Table(name = "partners")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partner.findAll", query = "SELECT p FROM Partner p"),
    @NamedQuery(name = "Partner.listVendors", query = "SELECT p FROM Partner p WHERE p.vendor = 1"),
    @NamedQuery(name = "Partner.listCustomers", query = "SELECT p FROM Partner p WHERE p.customer = 1")
})
public class Partner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vendor")
    private boolean vendor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customer")
    private boolean customer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @Size(max = 32)
    @Column(name = "primary_contact")
    private String primaryContact;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partner", fetch = FetchType.EAGER)
    private Set<Address> addressList;
    @OneToMany(mappedBy = "vendor")
    private Set<Item> itemList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partner", fetch = FetchType.EAGER)
    private Set<Contact> contactList;

    public Partner() {
    }

    public Partner(Integer id) {
        this.id = id;
    }

    public Partner(Integer id, boolean isActive, boolean vendor, boolean customer, String name) {
        this.id = id;
        this.isActive = isActive;
        this.vendor = vendor;
        this.customer = customer;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getVendor() {
        return vendor;
    }

    public void setVendor(boolean vendor) {
        this.vendor = vendor;
    }

    public boolean getCustomer() {
        return customer;
    }

    public void setCustomer(boolean customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryContact() {
        return primaryContact;
    }

    public void setPrimaryContact(String primaryContact) {
        this.primaryContact = primaryContact;
    }

    public Set<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Set<Address> addressList) {
        this.addressList = addressList;
    }

    public Set<Item> getItemList() {
        return itemList;
    }

    public void setItemList(Set<Item> itemList) {
        this.itemList = itemList;
    }

    public Set<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(Set<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partner)) {
            return false;
        }
        Partner other = (Partner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.flow.inventory.model.Partner[ id=" + id + " ]";
    }

}
