package com.bexpress.pojo;
// Generated Jul 23, 2016 4:01:06 PM by Hibernate Tools 4.3.1



/**
 * Suppliers generated by hbm2java
 */
public class Suppliers  implements java.io.Serializable {


     private int suplierId;
     private String companyName;
     private String contactPersonName;
     private String contactTitle;
     private String address;
     private String phone;
     private Integer mobile;
     private String fax;
     private String email;
     private String website;

    public Suppliers() {
    }

	
    public Suppliers(int suplierId) {
        this.suplierId = suplierId;
    }
    public Suppliers(int suplierId, String companyName, String contactPersonName, String contactTitle, String address, String phone, Integer mobile, String fax, String email, String website) {
       this.suplierId = suplierId;
       this.companyName = companyName;
       this.contactPersonName = contactPersonName;
       this.contactTitle = contactTitle;
       this.address = address;
       this.phone = phone;
       this.mobile = mobile;
       this.fax = fax;
       this.email = email;
       this.website = website;
    }
   
    public int getSuplierId() {
        return this.suplierId;
    }
    
    public void setSuplierId(int suplierId) {
        this.suplierId = suplierId;
    }
    public String getCompanyName() {
        return this.companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getContactPersonName() {
        return this.contactPersonName;
    }
    
    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }
    public String getContactTitle() {
        return this.contactTitle;
    }
    
    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getMobile() {
        return this.mobile;
    }
    
    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getWebsite() {
        return this.website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }




}


