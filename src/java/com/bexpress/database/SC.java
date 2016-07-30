/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.database;

import com.bexpress.util.HibernateUtil;
import org.hibernate.Session;

public class SC {
    public Session doSession(){
        Session s=HibernateUtil.getSessionFactory().openSession();
        return s;
    }
}
