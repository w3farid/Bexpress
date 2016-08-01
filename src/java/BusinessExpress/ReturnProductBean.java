/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessExpress;

import com.bexpress.database.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class ReturnProductBean {

    private String routesalesid;
    private String srName;
    private List repIdandName = new ArrayList();
    private int targetMemo;
    private int achieveMemo;
    private double priceA;
    private double priceB;
    private double pricec;
    private double priceD;
    private double priceE;
    private double totalTaka;

    private double pa;
    private double pb;
    private double pc;
    private double pd;
    private double pe;

    private double rpa;
    private double rpb;
    private double rpc;
    private double rpd;
    private double rpe;

    private double salesA;
    private double salesB;
    private double salesC;
    private double salesD;
    private double salesE;

    private double psalesA;

    public ReturnProductBean() {
        salesId();
        pricesTable();
    }

    public void doSave() {
        String checkDate = null;
        String checkrepId = null;
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(rightNow.getTime());
        Connection con = null;
        try {
            con = Database.getConnection();
            PreparedStatement stm = con.prepareStatement("select * from return_sales where rep_id=? and date=?");
            stm.setInt(1, Integer.parseInt(srName.substring(0, 5)));
            stm.setDate(2, java.sql.Date.valueOf(date));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                checkDate = rs.getString("date");
                checkrepId = rs.getString("rep_id");
            }
            if (checkrepId != null && checkDate != null) {
                PreparedStatement stm2 = con.prepareStatement("update return_sales set rep_name=?, xiongshiA=?,YitongB=?,YITONGC=?,YITONGD=?,XiongshiE=?,target_outlet=?,achieve_outlet=?,totalTaka=? where rep_id=? and date=?");
                stm2.setString(1, srName.substring(6));
                stm2.setDouble(2, salesA);
                stm2.setDouble(3, salesB);
                stm2.setDouble(4, salesC);
                stm2.setDouble(5, salesD);
                stm2.setDouble(6, salesE);
                stm2.setInt(7, targetMemo);
                stm2.setInt(8, achieveMemo);
                stm2.setDouble(9, totalTaka);
                stm2.setInt(10, Integer.parseInt(srName.substring(0, 5)));
                stm2.setDate(11, java.sql.Date.valueOf(date));
                int r = stm2.executeUpdate();
                if (r > 0) {
                    this.addMessage("Updated");
                } else {
                    this.addMessage("Not Updated");
                }

            } else {
                PreparedStatement stm2 = con.prepareStatement("insert into return_sales (rep_id, rep_name, xiongshiA, YitongB, YITONGC, YITONGD, XiongshiE, target_outlet, achieve_outlet, totalTaka, date) values(?,?,?,?,?,?,?,?,?,?,?)");
                stm2.setInt(1, Integer.parseInt(srName.substring(0, 5)));
                stm2.setString(2, srName.substring(6));
                stm2.setDouble(3, salesA);
                stm2.setDouble(4, salesB);
                stm2.setDouble(5, salesC);
                stm2.setDouble(6, salesD);
                stm2.setDouble(7, salesE);
                stm2.setInt(8, targetMemo);
                stm2.setInt(9, achieveMemo);
                stm2.setDouble(10, totalTaka);
                stm2.setDate(11, java.sql.Date.valueOf(date));
                int r = stm2.executeUpdate();
                if (r > 0) {
                    this.addMessage("Inserted");
                } else {
                    this.addMessage("Not Inserted");
                }
            }

        } catch (Exception e) {
            this.addMessage(e.getMessage());
        }
    }

    public void paSales() {
        double cA = getPa() - getRpa();
        setSalesA(cA);
        setTotalTaka(getSalesA() * getPriceA());

    }

    public void pbSales() {
        double cA = getPb() - getRpb();
        setSalesB(cA);
        setTotalTaka((getSalesA() * getPriceA()) + (getSalesB() * getPriceB()));

    }

    public void pcSales() {
        double cA = getPc() - getRpc();
        setSalesC(cA);
        setTotalTaka((getSalesA() * getPriceA()) + (getSalesB() * getPriceB()) + (getSalesC() * getPricec()));
    }

    public void pdSales() {
        double cA = getPd() - getRpd();
        setSalesD(cA);
        setTotalTaka((getSalesA() * getPriceA()) + (getSalesB() * getPriceB()) + (getSalesC() * getPricec()) + (getSalesD() * getPriceD()));
    }

    public void peSales() {
        double cA = getPe() - getRpe();
        setSalesE(cA);
        setTotalTaka((getSalesA() * getPriceA()) + (getSalesB() * getPriceB()) + (getSalesC() * getPricec()) + (getSalesD() * getPriceD()) + (getSalesE() * getPriceE()));
    }

    public void salesQuery() {
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(rightNow.getTime());
        Connection con = null;
        try {
            con = Database.getConnection();
            PreparedStatement stm = con.prepareStatement("Select xiongshiA,YitongB,YITONGC,YITONGD,XiongshiE from sales where rep_name=? and date=?");
            stm.setString(1, srName.substring(6));
            stm.setDate(2, java.sql.Date.valueOf(date));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                setPa(rs.getDouble("xiongshiA"));
                setPb(rs.getDouble("YitongB"));
                setPc(rs.getDouble("YITONGC"));
                setPd(rs.getDouble("YITONGD"));
                setPe(rs.getDouble("XiongshiE"));
            }

        } catch (Exception e) {
        }
    }

    public void sales() {

        Connection con = null;
        try {
            con = Database.getConnection();
            PreparedStatement stm = con.prepareStatement("Select * from sales where=?");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

            }
        } catch (Exception e) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReturnProductBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void salesId() {
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(rightNow.getTime());
        Connection con = null;
        try {
            con = Database.getConnection();
            PreparedStatement stm = con.prepareStatement("Select rep_id,rep_name from sales where date=?");
            stm.setDate(1, java.sql.Date.valueOf(date));

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                repIdandName.add(rs.getString("rep_id") + "-" + rs.getString("rep_name"));
                //System.out.println((rs.getString("rep_id") + "-" + rs.getString("rep_name")).substring(6));
            }
        } catch (Exception e) {
        }

    }

    public void pricesTable() {
        Connection con = null;
        try {
            con = Database.getConnection();
            PreparedStatement stm = con.prepareStatement("Select * from prices");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                setPriceA(rs.getDouble(2));
                setPriceB(rs.getDouble(3));
                setPricec(rs.getDouble(4));
                setPriceD(rs.getDouble(5));
                setPriceE(rs.getDouble(6));
                System.out.println(rs.getDouble(6));
            }
        } catch (Exception e) {
        }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List getRepIdandName() {
        return repIdandName;
    }

    public void setRepIdandName(List repIdandName) {
        this.repIdandName = repIdandName;
    }

    public static void main(String[] args) {
        ReturnProductBean rpb = new ReturnProductBean();
        rpb.salesId();
    }

    public String getRoutesalesid() {
        return routesalesid;
    }

    public void setRoutesalesid(String routesalesid) {
        this.routesalesid = routesalesid;
    }

    public String getSrName() {
        return srName;
    }

    public void setSrName(String srName) {
        this.srName = srName;
    }

    public double getPa() {
        return pa;
    }

    public void setPa(double pa) {
        this.pa = pa;
    }

    public double getPb() {
        return pb;
    }

    public void setPb(double pb) {
        this.pb = pb;
    }

    public double getPc() {
        return pc;
    }

    public void setPc(double pc) {
        this.pc = pc;
    }

    public double getPd() {
        return pd;
    }

    public void setPd(double pd) {
        this.pd = pd;
    }

    public double getPe() {
        return pe;
    }

    public void setPe(double pe) {
        this.pe = pe;
    }

    public double getPsalesA() {
        return psalesA;
    }

    public void setPsalesA(double psalesA) {
        this.psalesA = psalesA;
    }

    public void setRpe(int rpe) {
        this.rpe = rpe;
    }

    public double getSalesA() {
        return salesA;
    }

    public void setSalesA(double salesA) {
        this.salesA = salesA;
    }

    public double getSalesB() {
        return salesB;
    }

    public void setSalesB(double salesB) {
        this.salesB = salesB;
    }

    public double getSalesC() {
        return salesC;
    }

    public void setSalesC(double salesC) {
        this.salesC = salesC;
    }

    public double getSalesD() {
        return salesD;
    }

    public void setSalesD(double salesD) {
        this.salesD = salesD;
    }

    public double getSalesE() {
        return salesE;
    }

    public void setSalesE(double salesE) {
        this.salesE = salesE;
    }

    public double getRpa() {
        return rpa;
    }

    public void setRpa(double rpa) {
        this.rpa = rpa;
    }

    public double getRpb() {
        return rpb;
    }

    public void setRpb(double rpb) {
        this.rpb = rpb;
    }

    public double getRpc() {
        return rpc;
    }

    public void setRpc(double rpc) {
        this.rpc = rpc;
    }

    public double getRpd() {
        return rpd;
    }

    public void setRpd(double rpd) {
        this.rpd = rpd;
    }

    public double getRpe() {
        return rpe;
    }

    public void setRpe(double rpe) {
        this.rpe = rpe;
    }

    public double getPriceA() {
        return priceA;
    }

    public void setPriceA(double priceA) {
        this.priceA = priceA;
    }

    public double getPriceB() {
        return priceB;
    }

    public void setPriceB(double priceB) {
        this.priceB = priceB;
    }

    public double getPricec() {
        return pricec;
    }

    public void setPricec(double pricec) {
        this.pricec = pricec;
    }

    public double getPriceD() {
        return priceD;
    }

    public void setPriceD(double priceD) {
        this.priceD = priceD;
    }

    public double getPriceE() {
        return priceE;
    }

    public void setPriceE(double priceE) {
        this.priceE = priceE;
    }

    public double getTotalTaka() {
        return totalTaka;
    }

    public void setTotalTaka(double totalTaka) {
        this.totalTaka = totalTaka;
    }

    public int getTargetMemo() {
        return targetMemo;
    }

    public void setTargetMemo(int targetMemo) {
        this.targetMemo = targetMemo;
    }

    public int getAchieveMemo() {
        return achieveMemo;
    }

    public void setAchieveMemo(int achieveMemo) {
        this.achieveMemo = achieveMemo;
    }
}
