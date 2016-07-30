/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.list;

import com.bexpress.database.Database;
import com.bexpress.database.SC;
import com.bexpress.pojo.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean
@SessionScoped
public class ListDao {

    private List<Integer> list = new ArrayList<Integer>();
    private List<Integer> catIdList = new ArrayList<Integer>();
    private List<Integer> catIdQuery = new ArrayList<Integer>();
    private List<Integer> managerIdQuery = new ArrayList<Integer>();
    private List<Integer> supplierIdList = new ArrayList<Integer>();
    private List<Integer> supIdList = new ArrayList<Integer>();
    private List<Integer> returnIdList = new ArrayList<Integer>();
    private List<Integer> repIdList = new ArrayList<Integer>();

    public ListDao() throws SQLException {
        list.add(451);
        list.add(454);
        list.add(45);
        list.add(42);
        
        listcatId();
        listManagerId();
        listSupplier();
        listSupId();
        listReturnId();
        listRepId();
    }

    public void listcatId() throws SQLException {
        Connection con = Database.getConnection();
        try {

            String sql = "select cat_id from category";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
             while (rs.next()) {
                 catIdList.add(rs.getInt(1));                
        }
        } catch (SQLException ex) {
            Logger.getLogger(ListDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            
        }    

    }
    public void listRepId() throws SQLException {
        Connection con = Database.getConnection();
        try {

            String sql = "select rep_id from representatives";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
             while (rs.next()) {
                 repIdList.add(rs.getInt(1));                
        }
        } catch (SQLException ex) {
            Logger.getLogger(ListDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            
        }    

    }
    public void listManagerId() throws SQLException {
        Connection con = Database.getConnection();
        try {

            String sql = "select manager_id from managers";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
             while (rs.next()) {
                 managerIdQuery.add(rs.getInt(1));                
        }
        } catch (SQLException ex) {
            Logger.getLogger(ListDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            
        }    

    }
    public void listSupplier() throws SQLException {
        Connection con = Database.getConnection();
        try {

            String sql = "select suplier_Id from suppliers";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
             while (rs.next()) {
                 supplierIdList.add(rs.getInt(1));                
        }
        } catch (SQLException ex) {
            Logger.getLogger(ListDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            
        }    

    }
    public void listSupId() throws SQLException {
        Connection con = Database.getConnection();
        try {

            String sql = "select sup_id from supervisor";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
             while (rs.next()) {
                 supIdList.add(rs.getInt(1));                
        }
        } catch (SQLException ex) {
            Logger.getLogger(ListDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            
        }    

    }
    public void listReturnId() throws SQLException {
        Connection con = Database.getConnection();
        try {

            String sql = "select return_id from return";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
             while (rs.next()) {
                 supIdList.add(rs.getInt(1));                
        }
        } catch (SQLException ex) {
            Logger.getLogger(ListDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();
            
        }    

    }


    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> getCatIdList() {
        return catIdList;
    }

    public void setCatIdList(List<Integer> catIdList) {
        this.catIdList = catIdList;
    }
//    public static void main(String[] args) throws SQLException {
//        new ListDao().listcatId();
//    }

    public List<Integer> getCatIdQuery() {
        return catIdQuery;
    }

    public void setCatIdQuery(List<Integer> catIdQuery) {
        this.catIdQuery = catIdQuery;
    }

    public List<Integer> getManagerIdQuery() {
        return managerIdQuery;
    }

    public void setManagerIdQuery(List<Integer> managerIdQuery) {
        this.managerIdQuery = managerIdQuery;
    }

    public List<Integer> getSupplierIdList() {
        return supplierIdList;
    }

    public void setSupplierIdList(List<Integer> supplierIdList) {
        this.supplierIdList = supplierIdList;
    }

    public List<Integer> getSupIdList() {
        return supIdList;
    }

    public void setSupIdList(List<Integer> supIdList) {
        this.supIdList = supIdList;
    }

    public List<Integer> getReturnIdList() {
        return returnIdList;
    }

    public void setReturnIdList(List<Integer> returnIdList) {
        this.returnIdList = returnIdList;
    }

    public List<Integer> getRepIdList() {
        return repIdList;
    }

    public void setRepIdList(List<Integer> repIdList) {
        this.repIdList = repIdList;
    }

   
}
