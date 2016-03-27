/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ervinne Sodusta
 */
@Entity
@Table(name = "items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i"),
    @NamedQuery(name = "Item.findById", query = "SELECT i FROM Item i WHERE i.id = :id"),
    @NamedQuery(name = "Item.findByIsActive", query = "SELECT i FROM Item i WHERE i.isActive = :isActive"),
    @NamedQuery(name = "Item.findByName", query = "SELECT i FROM Item i WHERE i.name = :name"),
    @NamedQuery(name = "Item.findByPurchasable", query = "SELECT i FROM Item i WHERE i.purchasable = :purchasable"),
    @NamedQuery(name = "Item.findBySellable", query = "SELECT i FROM Item i WHERE i.sellable = :sellable")})
public class Item implements Serializable {

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
    @Size(min = 1, max = 32)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchasable")
    private boolean purchasable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sellable")
    private boolean sellable;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "uom_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private UnitOfMeasurement uom;

    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    @ManyToOne
    private Partner vendor;

    public Item() {
    }

    public Item(Integer id) {
        this.id = id;
    }

    public Item(Integer id, boolean isActive, String name, boolean purchasable, boolean sellable) {
        this.id = id;
        this.isActive = isActive;
        this.name = name;
        this.purchasable = purchasable;
        this.sellable = sellable;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getPurchasable() {
        return purchasable;
    }

    public void setPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
    }

    public boolean getSellable() {
        return sellable;
    }

    public void setSellable(boolean sellable) {
        this.sellable = sellable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UnitOfMeasurement getUom() {
        return uom;
    }

    public void setUom(UnitOfMeasurement uom) {
        this.uom = uom;
    }

    public Partner getVendor() {
        return vendor;
    }

    public void setVendor(Partner vendor) {
        this.vendor = vendor;
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
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.flow.inventory.model.Item[ id=" + id + " ]";
    }

}
