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

/**
 *
 * @author FG
 */
public class SalesService {

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

}
