/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.dao;

import com.bexpress.pojo.Bmanager;
import com.bexpress.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author FG
 */
public class BmanagerDao {
    public void doSave(Bmanager bm){
        Session s=HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.saveOrUpdate(bm);
        s.getTransaction().commit();
        s.close();
    }    
}
