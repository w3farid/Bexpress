/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.bean;

import com.bexpress.pojo.Suppliers;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author FG
 */
@ManagedBean
@SessionScoped
public class MenuBean {
    public String transactionMenu() {
        if (checkDateTime()) {
            addMessage("Success", "Go on");
            return "success";
        } else {
            addMessage("Success", "Go on");
            return "abc";
        }

    }
    public String employeeMenu() {
        if (checkDateTime()) {
            addMessage("Success","");
            return "success";
        } else {
            addMessage("Success", "");
            return "abc";
        }

    }

    public void update() {
        addMessage("Success", "Data updated");
    }
    

    public void delete() {
        addMessage("Success", "Data deleted");
    }

    public boolean checkDateTime() {
        Calendar c = Calendar.getInstance(TimeZone.getDefault());
        Date date = c.getTime();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
        String d=sdf.format(date);
        if(d.matches("2016") || d.matches("2017") || d.matches("2018")){
            return true;
        }else{
            return false;
        }
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

//    public static void main(String[] args) {
//        
//    }
}
