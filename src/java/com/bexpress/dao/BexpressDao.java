/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bexpress.dao;

import com.bexpress.database.SC;
import com.bexpress.pojo.Category;
import com.bexpress.pojo.Managers;
import com.bexpress.pojo.Orders;
import com.bexpress.pojo.Product;
import com.bexpress.pojo.Purchases;
import com.bexpress.pojo.PurchasesCost;
import com.bexpress.pojo.Representatives;
import com.bexpress.pojo.Return;
import com.bexpress.pojo.Supervisor;
import com.bexpress.pojo.Suppliers;
import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author FG
 */
public class BexpressDao {

    public boolean doSaveCat(int id, String catName) {
        Session s = new SC().doSession();
        Category cat = new Category(id, catName);
        try {
            s.beginTransaction();
            s.save(cat);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }
    public boolean doSaveSupplier(int suplierId, String companyName, String contactPersonName, String contactTitle, String address, String phone, Integer mobile, String fax, String email, String website) {
        Session s = new SC().doSession();
        Suppliers suppliers=new Suppliers(suplierId, companyName, contactPersonName, contactTitle, address, phone, mobile, fax, email, website);
        try {
            s.beginTransaction();
            s.update(suppliers);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }
    public boolean doUpdateSupplier(int suplierId, String companyName, String contactPersonName, String contactTitle, String address, String phone, Integer mobile, String fax, String email, String website) {
        Session s = new SC().doSession();
        Suppliers suppliers=new Suppliers(suplierId, companyName, contactPersonName, contactTitle, address, phone, mobile, fax, email, website);
        try {
            s.beginTransaction();
            s.update(suppliers);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }
    public boolean doDeleteSupplier(int suplierId, String companyName, String contactPersonName, String contactTitle, String address, String phone, Integer mobile, String fax, String email, String website) {
        Session s = new SC().doSession();
        Suppliers suppliers=new Suppliers(suplierId, companyName, contactPersonName, contactTitle, address, phone, mobile, fax, email, website);
        try {
            s.beginTransaction();
            s.delete(suppliers);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }
    public boolean doSaveSup(int supId, String supName, String managerId, String comId, String area) {
        Session s = new SC().doSession();
        Supervisor sup=new Supervisor(supId, supName, managerId, comId, area);
        try {
            s.beginTransaction();
            s.save(sup);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }
    public boolean doUpdateSup(int supId, String supName, String managerId, String comId, String area) {
        Session s = new SC().doSession();
        Supervisor sup=new Supervisor(supId, supName, managerId, comId, area);
        try {
            s.beginTransaction();
            s.update(sup);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }
    public boolean doDeleteSup(int supId, String supName, String managerId, String comId, String area) {
        Session s = new SC().doSession();
        Supervisor sup=new Supervisor(supId, supName, managerId, comId, area);
        try {
            s.beginTransaction();
            s.delete(sup);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }
    public boolean doSaveReturn(int returnId, Integer repId, String repName, Integer proId, String proName, Integer stock, Date date) {
        Session s = new SC().doSession();
        Return rt=new Return(returnId, repId, repName, proId, proName, stock, date);
        try {
            s.beginTransaction();
            s.save(rt);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }
    public boolean doSavePurCost(Integer costId, Integer representiveId, String costName, String costType, String costValue, Date costDate) {
        Session s = new SC().doSession();
        PurchasesCost purcost=new PurchasesCost(costId, representiveId, costName, costType, costValue, costDate);
        try {
            s.beginTransaction();
            s.save(purcost);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }
    public boolean doSaveRep(Integer repId, String repName, String comId, String supId, String managerId, String area) {
        Session s = new SC().doSession();
        Representatives rep=new Representatives(repId, repName, comId, supId, managerId, area);
        try {
            s.beginTransaction();
            s.save(rep);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }

    public boolean doSavePur(Integer purId,Integer proid,String proName,String supplierName,String serialNo, String catName,Date purDate,Integer stock, Double purPrice,String remarks) {
        Session s = new SC().doSession();
        Purchases pur = new Purchases(purId, proid, proName, supplierName, serialNo, catName, purDate, stock, purPrice, remarks);

        try {
            s.beginTransaction();
            s.save(pur);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }

    public boolean doSaveManager(int id, String mname, String comid, String area) {
        Session s = new SC().doSession();
        try {
            Managers m = new Managers(id, mname, comid, area);
            s.beginTransaction();
            s.save(m);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }

    public boolean doSaveOrders(int orderId, String repName, int proId, String proName, int stock, Date dateTime) {
        Session s = new SC().doSession();
        try {
            Orders or = new Orders(orderId, repName, proId, proName, proId, dateTime);
            s.beginTransaction();
            s.save(or);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }

    public boolean doSaveProduct(int proId, String proName, int suplierId, int catId, double proPrice, int stock, String productcol) {
        Session s = new SC().doSession();
        try {
            Product pro = new Product(proId, proName, suplierId, catId, proPrice, stock, productcol);
            s.beginTransaction();
            s.save(pro);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }

    public boolean doUpdateManager(int id, String mname, String comid, String area) {
        Session s = new SC().doSession();
        try {
            Managers m2 = new Managers(id, mname, comid, area);
            s.beginTransaction();
            s.update(m2);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }

    public boolean doUpdateCat(int catid, String catName) {
        Session s = new SC().doSession();
        try {

            Category cat = new Category(catid, catName);
            s.beginTransaction();
            s.update(cat);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }

    public boolean doDeleteCat(int catid) {
        Session s = new SC().doSession();
        try {

            Category cat = new Category(catid);
            s.beginTransaction();
            s.delete(cat);
            s.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            s.close();
        }
    }

//    public static void main(String[] args) {
//        new BexpressDao().doUpdateCat(111, "abc");
//    }
}
