package com.bexpress.pojo;
// Generated Jul 23, 2016 4:01:06 PM by Hibernate Tools 4.3.1



/**
 * Managers generated by hbm2java
 */
public class Managers  implements java.io.Serializable {


     private Integer managerId;
     private String managerName;
     private String comId;
     private String area;

    public Managers() {
    }

    public Managers(Integer managerId, String managerName, String comId, String area) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.comId = comId;
        this.area = area;
    }

    
   
    public Integer getManagerId() {
        return this.managerId;
    }
    
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
    public String getManagerName() {
        return this.managerName;
    }
    
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public String getComId() {
        return this.comId;
    }
    
    public void setComId(String comId) {
        this.comId = comId;
    }
    public String getArea() {
        return this.area;
    }
    
    public void setArea(String area) {
        this.area = area;
    }




}


