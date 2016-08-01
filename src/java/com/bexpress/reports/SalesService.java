/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.reports;

import com.bexpress.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author FG
 */
@ManagedBean(name = "salesService")
@ApplicationScoped
public class SalesService {

    public SalesService() {
    }

    public List<Sales> createSales() {
        List<Sales> list = new ArrayList<Sales>();
       
        Connection con = null;
        try {
            con = Database.getConnection();
            PreparedStatement stm=con.prepareStatement("select * from sales");
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
               list.add(new Sales(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getDouble(9), rs.getInt(10), rs.getDate(11)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<ReturnSales> createSales2() {
        List<ReturnSales> list = new ArrayList<ReturnSales>();
       
        Connection con = null;
        try {
            con = Database.getConnection();
            PreparedStatement stm=con.prepareStatement("select * from return_sales");
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
               list.add(new ReturnSales( rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7),rs.getDouble(8), rs.getInt(9), rs.getInt(10), rs.getDouble(11), rs.getDate(12)));
             
            }
        } catch (Exception e) {
        }
        return list;
    }
   
    
   

}
