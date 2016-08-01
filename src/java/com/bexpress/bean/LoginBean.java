/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.bean;

import com.bexpress.dao.LoginDao;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author FG
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{

    /**
     * Creates a new instance of LoginBean
     */
    private static final long serialVersionUID=1L;
    private String username;
    private String password;
    private String message;
    public LoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String loginBusinessExpress(){
       boolean result=LoginDao.login(username, password);
       if(result){
           HttpSession session=LoginUtil.getSession();
           session.setAttribute("username", username);
           return username;
       }else{
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Failed!","Please Try Again!"));
           return "registration";
       }
        
    }
    public String logout(){
        HttpSession session=LoginUtil.getSession();
        session.invalidate();
        return "logout";
    }
    
}
