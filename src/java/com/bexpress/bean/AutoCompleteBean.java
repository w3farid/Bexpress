/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.bean;

import com.bexpress.database.Database;
import com.bexpress.pojo.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author FG
 */
@ManagedBean
@SessionScoped
public class AutoCompleteBean {

    private Integer suplierId;
    private Suppliers suppliers=new Suppliers();

    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        try {
            Connection con = Database.getConnection();
            PreparedStatement stm = con.prepareStatement("select suplier_Id from suppliers where suplier_Id like '" + Integer.parseInt(query) + "'");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                results.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoCompleteBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return results;
    }
    public List<String> completeCatId(String query) {
        List<String> results = new ArrayList<String>();
        try {
            Connection con = Database.getConnection();
            PreparedStatement stm = con.prepareStatement("select cat_id from category where cat_id like '" + Integer.parseInt(query) + "'");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                results.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoCompleteBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return results;
    }
    public List<String> completeManagerId(String query) {
        List<String> results = new ArrayList<String>();
        try {
            Connection con = Database.getConnection();
            PreparedStatement stm = con.prepareStatement("select manager_id from managers where manager_id like '" + Integer.parseInt(query) + "'");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                results.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AutoCompleteBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return results;
    }

    public Integer getSuplierId() {
        return suplierId;
    }

    public void setSuplierId(Integer suplierId) {
        this.suplierId = suplierId;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }

}
