/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.reports;

import java.util.Date;

/**
 *
 * @author FG
 */
public class ReturnSales {
    private int return_id;
    private int rep_id;
    private String rep_name;
    private double xiongshiA;
    private double YitongB;
    private double YITONGC;
    private double YITONGD;
    private double XiongshiE;
    private int target_outlet;
    private int achieve_outlet;
    private double totalTaka;
    private Date date;

    public ReturnSales(int return_id) {
        this.return_id = return_id;
    }

    public ReturnSales() {
    }

    public ReturnSales(int return_id, int rep_id, String rep_name, double xiongshiA, double YitongB, double YITONGC, double YITONGD, double XiongshiE, int target_outlet, int achieve_outlet, double totalTaka, Date date) {
        this.return_id = return_id;
        this.rep_id = rep_id;
        this.rep_name = rep_name;
        this.xiongshiA = xiongshiA;
        this.YitongB = YitongB;
        this.YITONGC = YITONGC;
        this.YITONGD = YITONGD;
        this.XiongshiE = XiongshiE;
        this.target_outlet = target_outlet;
        this.achieve_outlet = achieve_outlet;
        this.totalTaka = totalTaka;
        this.date = date;
    }

    public int getReturn_id() {
        return return_id;
    }

    public void setReturn_id(int return_id) {
        this.return_id = return_id;
    }

    public int getRep_id() {
        return rep_id;
    }

    public void setRep_id(int rep_id) {
        this.rep_id = rep_id;
    }

    public String getRep_name() {
        return rep_name;
    }

    public void setRep_name(String rep_name) {
        this.rep_name = rep_name;
    }

    public double getXiongshiA() {
        return xiongshiA;
    }

    public void setXiongshiA(double xiongshiA) {
        this.xiongshiA = xiongshiA;
    }

    public double getYitongB() {
        return YitongB;
    }

    public void setYitongB(double YitongB) {
        this.YitongB = YitongB;
    }

    public double getYITONGC() {
        return YITONGC;
    }

    public void setYITONGC(double YITONGC) {
        this.YITONGC = YITONGC;
    }

    public double getYITONGD() {
        return YITONGD;
    }

    public void setYITONGD(double YITONGD) {
        this.YITONGD = YITONGD;
    }

    public double getXiongshiE() {
        return XiongshiE;
    }

    public void setXiongshiE(double XiongshiE) {
        this.XiongshiE = XiongshiE;
    }

    public int getTarget_outlet() {
        return target_outlet;
    }

    public void setTarget_outlet(int target_outlet) {
        this.target_outlet = target_outlet;
    }

    public int getAchieve_outlet() {
        return achieve_outlet;
    }

    public void setAchieve_outlet(int achieve_outlet) {
        this.achieve_outlet = achieve_outlet;
    }

    public double getTotalTaka() {
        return totalTaka;
    }

    public void setTotalTaka(double totalTaka) {
        this.totalTaka = totalTaka;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   
    
}
