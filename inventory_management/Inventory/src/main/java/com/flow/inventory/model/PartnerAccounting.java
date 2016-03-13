package com.flow.inventory.model;
// Generated Mar 10, 2016 2:37:53 PM by Hibernate Tools 4.3.1



/**
 * PartnerAccounting generated by hbm2java
 */
public class PartnerAccounting  implements java.io.Serializable {


     private int id;
     private ChartOfAccounts chartOfAccountsByAccountPayable;
     private ChartOfAccounts chartOfAccountsByAccountReceivable;
     private Partner partners;
     private PaymentTerm paymentTermsByCustomerPaymentTermId;
     private PaymentTerm paymentTermsByVendorPaymentTermId;
     private boolean isVendor;
     private boolean isCustomer;

    public PartnerAccounting() {
    }

	
    public PartnerAccounting(int id, Partner partners, boolean isVendor, boolean isCustomer) {
        this.id = id;
        this.partners = partners;
        this.isVendor = isVendor;
        this.isCustomer = isCustomer;
    }
    public PartnerAccounting(int id, ChartOfAccounts chartOfAccountsByAccountPayable, ChartOfAccounts chartOfAccountsByAccountReceivable, Partner partners, PaymentTerm paymentTermsByCustomerPaymentTermId, PaymentTerm paymentTermsByVendorPaymentTermId, boolean isVendor, boolean isCustomer) {
       this.id = id;
       this.chartOfAccountsByAccountPayable = chartOfAccountsByAccountPayable;
       this.chartOfAccountsByAccountReceivable = chartOfAccountsByAccountReceivable;
       this.partners = partners;
       this.paymentTermsByCustomerPaymentTermId = paymentTermsByCustomerPaymentTermId;
       this.paymentTermsByVendorPaymentTermId = paymentTermsByVendorPaymentTermId;
       this.isVendor = isVendor;
       this.isCustomer = isCustomer;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public ChartOfAccounts getChartOfAccountsByAccountPayable() {
        return this.chartOfAccountsByAccountPayable;
    }
    
    public void setChartOfAccountsByAccountPayable(ChartOfAccounts chartOfAccountsByAccountPayable) {
        this.chartOfAccountsByAccountPayable = chartOfAccountsByAccountPayable;
    }
    public ChartOfAccounts getChartOfAccountsByAccountReceivable() {
        return this.chartOfAccountsByAccountReceivable;
    }
    
    public void setChartOfAccountsByAccountReceivable(ChartOfAccounts chartOfAccountsByAccountReceivable) {
        this.chartOfAccountsByAccountReceivable = chartOfAccountsByAccountReceivable;
    }
    public Partner getPartners() {
        return this.partners;
    }
    
    public void setPartners(Partner partners) {
        this.partners = partners;
    }
    public PaymentTerm getPaymentTermsByCustomerPaymentTermId() {
        return this.paymentTermsByCustomerPaymentTermId;
    }
    
    public void setPaymentTermsByCustomerPaymentTermId(PaymentTerm paymentTermsByCustomerPaymentTermId) {
        this.paymentTermsByCustomerPaymentTermId = paymentTermsByCustomerPaymentTermId;
    }
    public PaymentTerm getPaymentTermsByVendorPaymentTermId() {
        return this.paymentTermsByVendorPaymentTermId;
    }
    
    public void setPaymentTermsByVendorPaymentTermId(PaymentTerm paymentTermsByVendorPaymentTermId) {
        this.paymentTermsByVendorPaymentTermId = paymentTermsByVendorPaymentTermId;
    }
    public boolean isIsVendor() {
        return this.isVendor;
    }
    
    public void setIsVendor(boolean isVendor) {
        this.isVendor = isVendor;
    }
    public boolean isIsCustomer() {
        return this.isCustomer;
    }
    
    public void setIsCustomer(boolean isCustomer) {
        this.isCustomer = isCustomer;
    }




}

