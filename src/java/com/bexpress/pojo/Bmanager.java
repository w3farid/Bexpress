package com.bexpress.pojo;
// Generated Jul 23, 2016 4:01:06 PM by Hibernate Tools 4.3.1



/**
 * Bmanager generated by hbm2java
 */
public class Bmanager  implements java.io.Serializable {


     private int bmanagerId;
     private String username;
     private String name;
     private Integer comId;
     private String designation;
     private String email;
     private String password;

    public Bmanager() {
    }

	
    public Bmanager(int bmanagerId) {
        this.bmanagerId = bmanagerId;
    }
    public Bmanager(int bmanagerId, String username, String name, Integer comId, String designation, String email, String password) {
       this.bmanagerId = bmanagerId;
       this.username = username;
       this.name = name;
       this.comId = comId;
       this.designation = designation;
       this.email = email;
       this.password = password;
    }
   
    public int getBmanagerId() {
        return this.bmanagerId;
    }
    
    public void setBmanagerId(int bmanagerId) {
        this.bmanagerId = bmanagerId;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Integer getComId() {
        return this.comId;
    }
    
    public void setComId(Integer comId) {
        this.comId = comId;
    }
    public String getDesignation() {
        return this.designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}

