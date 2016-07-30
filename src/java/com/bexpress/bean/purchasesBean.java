/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.bean;

import com.bexpress.dao.BexpressDao;
import com.bexpress.pojo.Purchases;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author FG
 */
@ManagedBean
@SessionScoped
public class purchasesBean {
   private String purId;
     private String proId;
     private String proName;
     private String suplierName;
     private String serialNumber;
     private String catName;
     private Date purDate;
     private String stock;
     private String purPrice;
     private String remarks;

    public purchasesBean() {
    }
     
     public void doSavePurchases() {
        
        if (new BexpressDao().doSavePur(Integer.parseInt(purId), Integer.parseInt(proId), proName, suplierName, serialNumber, catName, purDate, Integer.parseInt(stock), Double.parseDouble(purPrice), remarks)) {
            this.addMessage("Saved");
        } else {
            this.addMessage("Not saved");
        }
    }
     public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getSuplierName() {
        return suplierName;
    }

    public void setSuplierName(String suplierName) {
        this.suplierName = suplierName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public Date getPurDate() {
        return purDate;
    }

    public void setPurDate(Date purDate) {
        this.purDate = purDate;
    }

    

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPurId() {
        return purId;
    }

    public void setPurId(String purId) {
        this.purId = purId;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPurPrice() {
        return purPrice;
    }

    public void setPurPrice(String purPrice) {
        this.purPrice = purPrice;
    }
    
}
