/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.showData;

import com.bexpress.database.Database;
import com.bexpress.pojo.Managers;
import com.bexpress.pojo.Representatives;
import com.bexpress.pojo.Supervisor;
import com.bexpress.pojo.Suppliers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author FG
 */
@ManagedBean
@SessionScoped
public class SupplierView {
    private List<Suppliers> list=new ArrayList<>();
    public SupplierView() {
        Connection con = null;
        try {
            con = Database.getConnection();
            PreparedStatement stm=con.prepareStatement("select * from suppliers");
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
               list.add(new Suppliers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            }
        } catch (Exception e) {
        }
    }

    public List<Suppliers> getList() {
        return list;
    }

    public void setList(List<Suppliers> list) {
        this.list = list;
    }

}
