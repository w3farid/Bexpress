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
public class SupView {
    private List<Supervisor> list=new ArrayList<>();
    public SupView() {
        Connection con = null;
        try {
            con = Database.getConnection();
            PreparedStatement stm=con.prepareStatement("select * from supervisor");
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
               list.add(new Supervisor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception e) {
        }
    }

    public List<Supervisor> getList() {
        return list;
    }

    public void setList(List<Supervisor> list) {
        this.list = list;
    }

    

   
}
