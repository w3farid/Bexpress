package com.bexpress.pojo;
// Generated Jul 23, 2016 4:01:06 PM by Hibernate Tools 4.3.1



/**
 * Representatives generated by hbm2java
 */
public class Representatives  implements java.io.Serializable {


     private Integer repId;
     private String repName;
     private String comId;
     private String supId;
     private String managerId;
     private String area;

    public Representatives() {
    }

    public Representatives(Integer repId, String repName, String comId, String supId, String managerId, String area) {
        this.repId = repId;
        this.repName = repName;
        this.comId = comId;
        this.supId = supId;
        this.managerId = managerId;
        this.area = area;
    }

   
   
    public Integer getRepId() {
        return this.repId;
    }
    
    public void setRepId(Integer repId) {
        this.repId = repId;
    }
    public String getRepName() {
        return this.repName;
    }
    
    public void setRepName(String repName) {
        this.repName = repName;
    }
    public String getComId() {
        return this.comId;
    }
    
    public void setComId(String comId) {
        this.comId = comId;
    }
    public String getSupId() {
        return this.supId;
    }
    
    public void setSupId(String supId) {
        this.supId = supId;
    }
    public String getManagerId() {
        return this.managerId;
    }
    
    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }
    public String getArea() {
        return this.area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }




}


