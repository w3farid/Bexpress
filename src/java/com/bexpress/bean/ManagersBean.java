/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.bean;

import com.bexpress.dao.BexpressDao;
import com.bexpress.database.Database;
import com.bexpress.list.ListDao;
import com.bexpress.pojo.Managers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author FG
 */
@ManagedBean
@RequestScoped
public class ManagersBean {

    private String managerId;
    private String managerName;
    private String comId;
    private String area;
    private Managers m=new Managers();
    

    public ManagersBean() {
    }
    public void doSaveManager() {
        int id=Integer.parseInt(managerId);        
        if (new BexpressDao().doSaveManager(id, managerName, comId, area)) {
            this.addMessage("Data Saved");
        } else {
            this.addMessage("Data Not saved");
        }
    }
   
    public void managerIdQuery() throws SQLException {
        Connection con = Database.getConnection();
        try {

            String sql = "select * from managers where manager_id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(managerId));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                setManagerId(rs.getString(1));
                setManagerName(rs.getString(2));
                setComId(rs.getString(3));
                setArea(rs.getString(4));
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
    
    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Managers getM() {
        return m;
    }

    public void setM(Managers m) {
        this.m = m;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

}
