/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.bean;

import com.bexpress.pojo.Bmanager;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author FG
 */
@Named(value = "bmanagerMB")
@SessionScoped
public class BmanagerMB {
    private Bmanager bm=new Bmanager();
    private UploadedFile file;
    public BmanagerMB() {
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Bmanager getBm() {
        return bm;
    }

    public void setBm(Bmanager bm) {
        this.bm = bm;
    }
    
}
