/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.bean;

import com.bexpress.dao.BexpressDao;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author FG
 */
@ManagedBean
@SessionScoped
public class PurchasesCostBean {

    private String costId;
    private String representiveId;
    private String costName;
    private String costType;
    private String costValue;
    private Date costDate;

    public PurchasesCostBean() {
    }

    public void doSavePurCost() {
        
        if (new BexpressDao().doSavePurCost(Integer.parseInt(costId),Integer.parseInt(costId), costName, costType, costValue, costDate)){
            this.addMessage("Saved");
        } else {
            this.addMessage("Not saved");
        }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getCostId() {
        return costId;
    }

    public void setCostId(String costId) {
        this.costId = costId;
    }

    public String getCostName() {
        return costName;
    }

    public void setCostName(String costName) {
        this.costName = costName;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getCostValue() {
        return costValue;
    }

    public void setCostValue(String costValue) {
        this.costValue = costValue;
    }

    public Date getCostDate() {
        return costDate;
    }

    public void setCostDate(Date costDate) {
        this.costDate = costDate;
    }

    public String getRepresentiveId() {
        return representiveId;
    }

    public void setRepresentiveId(String representiveId) {
        this.representiveId = representiveId;
    }

}
