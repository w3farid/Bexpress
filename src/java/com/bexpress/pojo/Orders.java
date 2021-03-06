package com.bexpress.pojo;
// Generated Jul 23, 2016 4:01:06 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Orders generated by hbm2java
 */
public class Orders  implements java.io.Serializable {


     private Integer orderId;
     private String repName;
     private Integer proId;
     private String proName;
     private Integer stock;
     private Date dateTime;

    public Orders(Integer orderId, String repName, Integer proId, String proName, Integer stock, Date dateTime) {
        this.orderId = orderId;
        this.repName = repName;
        this.proId = proId;
        this.proName = proName;
        this.stock = stock;
        this.dateTime = dateTime;
    }

    public Orders() {
    }

    public Orders(String repName, Integer proId, String proName, Integer stock, Date dateTime) {
       this.repName = repName;
       this.proId = proId;
       this.proName = proName;
       this.stock = stock;
       this.dateTime = dateTime;
    }
   
    public Integer getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public String getRepName() {
        return this.repName;
    }
    
    public void setRepName(String repName) {
        this.repName = repName;
    }
    public Integer getProId() {
        return this.proId;
    }
    
    public void setProId(Integer proId) {
        this.proId = proId;
    }
    public String getProName() {
        return this.proName;
    }
    
    public void setProName(String proName) {
        this.proName = proName;
    }
    public Integer getStock() {
        return this.stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public Date getDateTime() {
        return this.dateTime;
    }
    
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }




}


