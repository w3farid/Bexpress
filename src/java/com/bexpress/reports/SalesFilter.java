/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.reports;

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
public class SalesFilter {
    private List<Sales> sales;
     private List<Sales> filteredSales;
    @PostConstruct
    public void init() {
        sales = new SalesService().createSales();
    }
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    public List<Sales> getFilteredSales() {
        return filteredSales;
    }

    public void setFilteredSales(List<Sales> filteredSales) {
        this.filteredSales = filteredSales;
    }

   
}
