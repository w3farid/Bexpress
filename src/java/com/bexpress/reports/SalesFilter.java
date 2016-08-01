/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.reports;

import com.bexpress.database.Database;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author FG
 */
@ManagedBean
@ViewScoped
public class SalesFilter implements Serializable{
    private List<Sales> sales;
     private List<Sales> filteredSales;
     private List<String> srName=new ArrayList<>();
     
    @PostConstruct
    public void init() {
        sales = new SalesService().createSales();        
        srName();
    }
     public void srName() {
        Connection con = null;
        try {
            con = Database.getConnection();
            PreparedStatement stm=con.prepareStatement("select rep_name from representatives");
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
               srName.add(rs.getString("rep_name").toUpperCase());
            }
        } catch (Exception e) {
        }
        
    }
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Double.valueOf(filterText)) > 0;
    }
    

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    

    public List<String> getSrName() {
        return srName;
    }

    public void setSrName(List<String> srName) {
        this.srName = srName;
    }

    public List<Sales> getFilteredSales() {
        return filteredSales;
    }

    public void setFilteredSales(List<Sales> filteredSales) {
        this.filteredSales = filteredSales;
    }

}
