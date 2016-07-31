/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.salesTrend;

import com.bexpress.database.Database;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
public class SalesTrend implements Serializable {

    private BarChartModel barModel;
    private String dateforweb;
    private double totalSales=0;
    private double totalmemo=0;
    private int toutlet=0;
    private int aoutlet=0;
    private double weeklySales;
    private int weeklymemo;

    @PostConstruct
    public void init() {
        createBarModels();
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries rakib = new ChartSeries();
        rakib.setLabel("RAKIB");

        ChartSeries shahin = new ChartSeries();
        shahin.setLabel("SHAHIN");

        ChartSeries raihan = new ChartSeries();
        raihan.setLabel("RAIHAN");

        ChartSeries abdul = new ChartSeries();
        abdul.setLabel("ABDUL");

        ChartSeries jakaria = new ChartSeries();
        jakaria.setLabel("JAKARIA");

        ChartSeries niloy = new ChartSeries();
        niloy.setLabel("NILOY");

        Connection con = null;
        try {
            Calendar rightNow = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
            String date = sdf.format(rightNow.getTime());
            setDateforweb(date);
            con = Database.getConnection();
            PreparedStatement stm = con.prepareStatement("select * from return_sales where date between date_add(current_date(),interval -7 day) and date_sub(current_date(), interval 0 day)");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (rs.getString(2).equals("16005")) {
                    rakib.set(rs.getDate("date"), rs.getDouble("totalTaka"));
                }
                if (rs.getString(2).equals("16009")) {
                    shahin.set(rs.getDate("date"), rs.getDouble("totalTaka"));
                }
                if (rs.getString(2).equals("16004")) {
                    raihan.set(rs.getDate("date"), rs.getDouble("totalTaka"));
                }
                if (rs.getString(2).equals("16006")) {
                    abdul.set(rs.getDate("date"), rs.getDouble("totalTaka"));
                }
                if (rs.getString(2).equals("16007")) {
                    jakaria.set(rs.getDate("date"), rs.getDouble("totalTaka"));
                }
                if (rs.getString(2).equals("16008")) {
                    niloy.set(rs.getDate("date"), rs.getDouble("totalTaka"));
                }
                if(rs.getString("date").matches(date)){
                    setTotalSales(totalSales+rs.getDouble("totalTaka"));
                    setTotalmemo(totalmemo+rs.getInt("achieve_outlet"));
                }
                if(rs.getString("date").matches(date)){
                    setToutlet(toutlet+rs.getInt("target_outlet"));
                    setAoutlet(aoutlet+rs.getInt("achieve_outlet"));
                }
                setWeeklySales(weeklySales+rs.getDouble("totalTaka"));
                setWeeklymemo(weeklymemo+rs.getInt("achieve_outlet"));
            }
        } catch (Exception e) {
        }

        model.addSeries(rakib);
        model.addSeries(shahin);
        model.addSeries(raihan);
        model.addSeries(abdul);
        model.addSeries(jakaria);
        model.addSeries(niloy);

        return model;
    }

    private void createBarModels() {
        createBarModel();
    }

    private void createBarModel() {
        barModel = initBarModel();

        barModel.setTitle("Sales Trend Current Week");
        barModel.setLegendPosition("ne");

        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Weekly SR Sales Performances");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Saling Range");
        yAxis.setMin(0);
        yAxis.setMax(200000);
    }

    public String getDateforweb() {
        return dateforweb;
    }

    public void setDateforweb(String dateforweb) {
        this.dateforweb = dateforweb;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public double getTotalmemo() {
        return totalmemo;
    }

    public void setTotalmemo(double totalmemo) {
        this.totalmemo = totalmemo;
    }

    public int getToutlet() {
        return toutlet;
    }

    public void setToutlet(int toutlet) {
        this.toutlet = toutlet;
    }

    public int getAoutlet() {
        return aoutlet;
    }

    public void setAoutlet(int aoutlet) {
        this.aoutlet = aoutlet;
    }

    public double getWeeklySales() {
        return weeklySales;
    }

    public void setWeeklySales(double weeklySales) {
        this.weeklySales = weeklySales;
    }

    public int getWeeklymemo() {
        return weeklymemo;
    }

    public void setWeeklymemo(int weeklymemo) {
        this.weeklymemo = weeklymemo;
    }

}
