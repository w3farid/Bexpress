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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ReturnsBean {
    private String returnId;
    private String repId;
    private String repName;
    private String proId;
    private String proName;
    private String stock;
    private Date date;

    public ReturnsBean() {
    }
     public void doSaveReturn() {
        
        if (new BexpressDao().doSaveReturn(Integer.parseInt(returnId), Integer.parseInt(repId), repName, Integer.parseInt(proId), proName, Integer.parseInt(stock), date)){
            
            this.addMessage("Saved");
        } else {
            this.addMessage("Not saved");
            
        }
    }
     
     public void returnQuery() throws SQLException {
        Connection con = Database.getConnection();
        try {

            String sql = "select * from return where return_id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(returnId));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                setRepId(rs.getString(2));
                setRepName(rs.getString(3));
                setProId(rs.getString(4));
                setProName(rs.getString(5));
                setStock(rs.getString(6));
                setDate(rs.getDate(6));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();

        }
    }
     
     public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
     
    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public String getRepId() {
        return repId;
    }

    public void setRepId(String repId) {
        this.repId = repId;
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

}
