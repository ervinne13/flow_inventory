/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flow.inventory.dao;

import com.flow.inventory.model.Address;
import com.flow.inventory.model.Contact;
import com.flow.inventory.model.Partner;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ervinne Sodusta
 */
@Repository("partnersDao")
public class PartnersDaoImpl implements PartnersDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Partner> listPartners() {
        return sessionFactory.getCurrentSession().createCriteria(Partner.class).list();
    }

    @Override
    public List<Partner> listVendors() {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("Partner.listVendors");
        return query.list();
    }

    @Override
    public Partner getById(int id) {
        return (Partner) sessionFactory.getCurrentSession().get(Partner.class, id);

    }

    @Override
    public void addPartner(Partner partner) {
        sessionFactory.getCurrentSession().save(assignChildrenParentReferences(partner));
    }

    @Override
    public void updatePartner(Partner partner) {
        sessionFactory.getCurrentSession().saveOrUpdate(assignChildrenParentReferences(partner));
    }

    private Partner assignChildrenParentReferences(Partner partner) {

        //  assign contacts' parent
        Iterator<Contact> contactListIterator = partner.getContactList().iterator();
        while (contactListIterator.hasNext()) {
            contactListIterator.next().setPartner(partner);
        }

        //  assign addresses' parent        
        Iterator<Address> addressListIterator = partner.getAddressList().iterator();
        while (addressListIterator.hasNext()) {
            addressListIterator.next().setPartner(partner);
        }

        return partner;
    }

}
