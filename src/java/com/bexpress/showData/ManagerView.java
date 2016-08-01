/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.showData;

import com.bexpress.database.Database;
import com.bexpress.pojo.Managers;
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
public class ManagerView {
    private List<Managers> list=new ArrayList<>();
    public ManagerView() {
        Connection con = null;
        try {
            con = Database.getConnection();
            PreparedStatement stm=con.prepareStatement("select * from managers");
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
               list.add(new Managers(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception e) {
        }
    }

    public List<Managers> getList() {
        return list;
    }

    public void setList(List<Managers> list) {
        this.list = list;
    }
    
}
