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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author FG
 */
@ManagedBean
@SessionScoped
public class SupervisorBean {

    private String supId;
    private String supName;
    private String managerId;
    private String comId;
    private String area;

    public SupervisorBean() {
        
    }

    public void doSaveSup() {
        int id = Integer.parseInt(managerId);
        if (new BexpressDao().doSaveSup(Integer.parseInt(supId), supName, managerId, comId, area)) {
            this.addMessage("Data Saved");
        } else {
            this.addMessage("Data Not saved");
        }
    }
    public void doUpdateSup() {
        int id = Integer.parseInt(managerId);
        if (new BexpressDao().doUpdateSup(Integer.parseInt(supId), supName, managerId, comId, area)) {
            this.addMessage("Data Updated");
        } else {
            this.addMessage("Data Not Updated");
        }
    }
    public void doDeleteSup() {
        int id = Integer.parseInt(managerId);
        if (new BexpressDao().doDeleteSup(Integer.parseInt(supId), supName, managerId, comId, area)) {
            this.addMessage("Data Deleted");
        } else {
            this.addMessage("Data Not Deleted");
        }
    }
    public void supIdQuery() throws SQLException {
        Connection con = Database.getConnection();
        try {

            String sql = "select * from supervisor where sup_id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(supId));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                setSupName(rs.getString(2));
                setManagerId(rs.getString(3));
                setComId(rs.getString(4));
                setArea(rs.getString(5));

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

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
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

}
