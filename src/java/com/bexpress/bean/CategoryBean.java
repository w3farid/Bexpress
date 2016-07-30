/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.bean;

import com.bexpress.dao.BexpressDao;
import com.bexpress.database.Database;
import com.bexpress.list.ListDao;
import com.bexpress.pojo.Category;
import com.bexpress.util.HibernateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;

/**
 *
 * @author FG
 */
@ManagedBean
@RequestScoped
public class CategoryBean {

    private String catId2;

    private String catname;
    private Category category = new Category();
    private List<Category> listCat = new ArrayList<Category>();

    public CategoryBean() {
        catList();
    }

    public void doSaveCategory() {
        int catId = Integer.parseInt(catId2);
        if (new BexpressDao().doSaveCat(catId, catname)) {
            this.addMessage("Saved");
        } else {
            this.addMessage("Not saved");
        }
    }
    public void doUPdateCategory() {
        int catId = Integer.parseInt(catId2);
        if (new BexpressDao().doUpdateCat(catId, catname)) {
            this.addMessage("Updated");
        } else {
            this.addMessage("Not Updated");
        }
    }
    public void doDeleteCategory() {
        int catId = Integer.parseInt(catId2);
        if (new BexpressDao().doDeleteCat(catId)) {
            this.addMessage("Deleted");
        } else {
            this.addMessage("Not Deleted");
        }
    }

    public void catList() {

        try {
            Connection con = new Database().getConnection();
            PreparedStatement stm = con.prepareStatement("select * from category");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Integer a = rs.getInt(1);
                String b = rs.getString(2);
                listCat.add(new Category(a, b));
            }

        } catch (Exception ex) {

        }
    }

    public void catIdQuery() throws SQLException {
        Connection con = Database.getConnection();
        try {

            String sql = "select * from category where cat_id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(catId2));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                setCatname(rs.getString(2));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.close();

        }

    }
    
    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

//    public static void main(String[] args) {
//        new CategoryBean().catList();
//    }

    public List<Category> getListCat() {
        return listCat;
    }

    public void setListCat(List<Category> listCat) {
        this.listCat = listCat;
    }

    public String getCatId2() {
        return catId2;
    }

    public void setCatId2(String catId2) {
        this.catId2 = catId2;
    }

}
