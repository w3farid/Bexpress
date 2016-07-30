/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.bean;

import com.bexpress.dao.BexpressDao;
import com.bexpress.database.Database;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author FG
 */
@ManagedBean
@SessionScoped
public class RepresentativesBean {

    private String repId;
    private String repName;
    private String comId;
    private String supId;
    private String managerId;
    private String area;
    private UploadedFile file;
    private String imageName;

    public RepresentativesBean() {
    }

    public String getRepId() {
        return repId;
    }

    public void doSaveRep() {

        if (new BexpressDao().doSaveRep(Integer.parseInt(repId), repName, comId, supId, managerId, area)) {
            this.addMessage("Saved");
        } else {
            this.addMessage("Not saved");
        }
    }
    public void imageUpdateRep(){
        imageUpload();
        Connection con = Database.getConnection();
        try {
            PreparedStatement stm=con.prepareStatement("update representatives set image=? where rep_id=?");
            stm.setString(1, imageName);
            stm.setInt(2, Integer.parseInt(repId));
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepresentativesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void imageUpload() {
        if (file != null) {
            try {
                FacesContext context = FacesContext.getCurrentInstance();
                ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
                String dbpath = servletContext.getRealPath("/");
                String webcut = dbpath.substring(0, dbpath.lastIndexOf("\\"));
                String buildcut = webcut.substring(0, webcut.lastIndexOf("\\"));
                String mainURLPath = buildcut.substring(0, buildcut.lastIndexOf("\\"));
                InputStream inputStream = file.getInputstream();
                String path = mainURLPath + "\\web\\resources\\images\\repImages\\" + file.getFileName();
                File destFile = new File(path);
                if (!destFile.exists()) {
                    FileUtils.copyInputStreamToFile(inputStream, destFile);
                }
                setImageName(file.getFileName().toString());

            } catch (Exception e) {
            }finally{
                
            }
        }
    }
    public void repIdLidst(){
        
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
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

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

}
