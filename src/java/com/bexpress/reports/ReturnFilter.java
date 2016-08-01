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
public class ReturnFilter implements Serializable {

    private List<ReturnSales> returnsales;
    private List<ReturnSales> filteredReturnSales;
    private List<String> srName = new ArrayList<>();

    @PostConstruct
    public void init() {
        returnsales = new SalesService().createSales2();
        srName();
    }

    public void srName() {
        Connection con = null;
        try {
            con = Database.getConnection();
            PreparedStatement stm = con.prepareStatement("select rep_name from representatives");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                srName.add(rs.getString("rep_name").toUpperCase());
            }
        } catch (Exception e) {
        }

    }

    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }

        return ((Comparable) value).compareTo(Double.valueOf(filterText)) > 0;
    }

    public List<String> getSrName() {
        return srName;
    }

    public void setSrName(List<String> srName) {
        this.srName = srName;
    }

    public List<ReturnSales> getReturnsales() {
        return returnsales;
    }

    public void setReturnsales(List<ReturnSales> returnsales) {
        this.returnsales = returnsales;
    }

    public List<ReturnSales> getFilteredReturnSales() {
        return filteredReturnSales;
    }

    public void setFilteredReturnSales(List<ReturnSales> filteredReturnSales) {
        this.filteredReturnSales = filteredReturnSales;
    }

}
