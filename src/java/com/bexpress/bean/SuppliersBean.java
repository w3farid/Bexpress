/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.bean;

import com.bexpress.dao.BexpressDao;
import com.bexpress.database.Database;
import com.bexpress.list.ListDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author FG
 */
@ManagedBean
@RequestScoped
public class SuppliersBean {

    private String suplierId;
    private String companyName;
    private String contactPersonName;
    private String contactTitle;
    private String address;
    private String phone;
    private String mobile;
    private String fax;
    private String email;
    private String website;

    public SuppliersBean(){
       
    }
    public void doSaveSup() {
        if (new BexpressDao().doSaveSupplier(Integer.parseInt(suplierId), companyName, contactPersonName, contactTitle, address, phone, Integer.parseInt(mobile), fax, email, website)) {
            this.addMessage("Data Saved");
        } else {
            this.addMessage("Data Not saved");
        }
    }
    public void doUpdateSup() {
        if (new BexpressDao().doUpdateSupplier(Integer.parseInt(suplierId), companyName, contactPersonName, contactTitle, address, phone, Integer.parseInt(mobile), fax, email, website)) {
            this.addMessage("Data Saved");
        } else {
            this.addMessage("Data Not saved");
        }
    }
    public void doDeleteSup() {
        if (new BexpressDao().doDeleteSupplier(Integer.parseInt(suplierId), companyName, contactPersonName, contactTitle, address, phone, Integer.parseInt(mobile), fax, email, website)) {
            this.addMessage("Data Saved");
        } else {
            this.addMessage("Data Not saved");
        }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public void supplierIdQuery() throws SQLException {
        Connection con = Database.getConnection();
        try {

            String sql = "select * from suppliers where suplier_Id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(suplierId));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                setCompanyName(rs.getString(2));
                setContactPersonName(rs.getString(3));
                setContactTitle(rs.getString(4));
                setAddress(rs.getString(5));
                setPhone(rs.getString(6));
                setMobile(rs.getString(7));
                setFax(rs.getString(8));
                setEmail(rs.getString(9));
                setWebsite(rs.getString(10));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();

        }
    }
    public String getSuplierId() {
        return suplierId;
    }

    public void setSuplierId(String suplierId) {
        this.suplierId = suplierId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

 
    
        
    

}
