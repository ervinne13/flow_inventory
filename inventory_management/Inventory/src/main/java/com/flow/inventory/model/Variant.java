/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "variants")
@XmlRootElement
@NamedQueries({
    @NamedQuery(
            name = "Variant.findAll",
            query = "SELECT v FROM Variant v"
    ),
    @NamedQuery(
            name = "Variant.findFiltered",
            query = "SELECT v FROM Variant v "
            + "WHERE v.sku LIKE '%:filter%' OR v.name LIKE '%:filter%' "
            + "ORDER BY v.item.id DESC"
    )
})
public class Variant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @JsonIgnore
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Item item;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "sku")
    private String sku;
    @Basic(optional = false)
    @NotNull
    @Column(name = "default_variant")
    private boolean defaultVariant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @Size(max = 64)
    @Column(name = "supplier_code")
    private String supplierCode;
    @Column(name = "wholesale_price")
    private Long wholesalePrice;
    @Column(name = "retail_price")
    private Long retailPrice;
    @Column(name = "purchase_price")
    private Long purchasePrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expires_in_days")
    private int expiresInDays;

    public Variant() {
    }

    public Variant(Integer id) {
        this.id = id;
    }

    public Variant(Integer id, String sku, boolean defaultVariant, String name, int expiresInDays) {
        this.id = id;
        this.sku = sku;
        this.defaultVariant = defaultVariant;
        this.name = name;
        this.expiresInDays = expiresInDays;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public boolean getDefaultVariant() {
        return defaultVariant;
    }

    public void setDefaultVariant(boolean defaultVariant) {
        this.defaultVariant = defaultVariant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public Long getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(Long wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public Long getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Long retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getExpiresInDays() {
        return expiresInDays;
    }

    public void setExpiresInDays(int expiresInDays) {
        this.expiresInDays = expiresInDays;
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
        if (!(object instanceof Variant)) {
            return false;
        }
        Variant other = (Variant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.flow.inventory.model.Variant[ id=" + id + " ]";
    }

}
