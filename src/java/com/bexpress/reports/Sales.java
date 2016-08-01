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
public class Sales {

    private int salseId;
    private String repId;
    private String repName;
    private int xiongshiA;
    private int yitongB;
    private int y1c;
    private int lyd;
    private int xiongshiE;
    private double unitPrice;
    private int offer;
    private Date date;

    public Sales(String repName) {
        this.repName = repName;
    }

    public Sales() {
    }

    public Sales(int salseId, String repId, String repName, int xiongshiA, int yitongB, int y1c, int lyd, int xiongshiE, double unitPrice, int offer, Date date) {
        this.salseId = salseId;
        this.repId = repId;
        this.repName = repName;
        this.xiongshiA = xiongshiA;
        this.yitongB = yitongB;
        this.y1c = y1c;
        this.lyd = lyd;
        this.xiongshiE = xiongshiE;
        this.unitPrice = unitPrice;
        this.offer = offer;
        this.date = date;
    }

   

    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSalseId() {
        return salseId;
    }

    public void setSalseId(int salseId) {
        this.salseId = salseId;
    }

    public String getRepId() {
        return repId;
    }

    public void setRepId(String repId) {
        this.repId = repId;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String repName) {
        this.repName = repName;
    }

    public int getXiongshiA() {
        return xiongshiA;
    }

    public void setXiongshiA(int xiongshiA) {
        this.xiongshiA = xiongshiA;
    }

    public int getYitongB() {
        return yitongB;
    }

    public void setYitongB(int yitongB) {
        this.yitongB = yitongB;
    }


    public int getXiongshiE() {
        return xiongshiE;
    }

    public void setXiongshiE(int xiongshiE) {
        this.xiongshiE = xiongshiE;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getOffer() {
        return offer;
    }

    public void setOffer(int offer) {
        this.offer = offer;
    }

    public int getY1c() {
        return y1c;
    }

    public void setY1c(int y1c) {
        this.y1c = y1c;
    }

    public int getLyd() {
        return lyd;
    }

    public void setLyd(int lyd) {
        this.lyd = lyd;
    }

   

}
