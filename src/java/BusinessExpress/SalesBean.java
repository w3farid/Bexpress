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
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author FG
 */
@ManagedBean
@SessionScoped
public class SalesBean {

    private Date date;
    private String r1p1;
    private String ab1;
    private String r1p2;
    private String r1p3;
    private String r1p4;
    private String r1p5;

    //route 2 and product 1 to 5;
    private String r2p1;
    private String r2p2;
    private String r2p3;
    private String r2p4;
    private String r2p5;

    //route 3 and product 1 to 5;
    private String r3p1;
    private String r3p2;
    private String r3p3;
    private String r3p4;
    private String r3p5;

    //route 3 and product 1 to 5;
    private String r4p1;
    private String r4p2;
    private String r4p3;
    private String r4p4;
    private String r4p5;

    //route 3 and product 1 to 5;
    private String r5p1;
    private String r5p2;
    private String r5p3;
    private String r5p4;
    private String r5p5;

    //route 3 and product 1 to 5;
    private String r6p1;
    private String r6p2;
    private String r6p3;
    private String r6p4;
    private String r6p5;

    //Product Distribution
    private String pA1;
    private String pB2;
    private String pC3;
    private String pD4;
    private String pE5;

    private String proA1;
    private String proA2;
    private String proA3;
    private String proA4;
    private String proA5;

    private String gradeA;
    private String gradeB;
    private String gradeC;
    private String gradeD;

    private int repIdR1;
    private int repIdR2;
    private int repIdR3;
    private int repIdR4;
    private int repIdR5;
    private int repIdR6;

    private String repName1;
    private String repName2;
    private String repName3;
    private String repName4;
    private String repName5;
    private String repName6;

    private String route1;
    private String route1Grade;
    private String route2;
    private String route2Grade;
    private String route3;
    private String route3Grade;
    private String route4;
    private String route4Grade;
    private String route5;
    private String route5Grade;
    private String route6;
    private String route6Grade;

    private int opa;
    private int opb;
    private int opc;
    private int opd;
    private int ope;

    private double pricepa;
    private double pricepb;
    private double pricepc;
    private double pricepd;
    private double pricepe;

    private double ntpar1;
    private double ntpar2;
    private double ntpar3;
    private double ntpar4;
    private double ntpar5;
    private double ntpar6;

    private double ntpbr1;
    private double ntpbr2;
    private double ntpbr3;
    private double ntpbr4;
    private double ntpbr5;
    private double ntpbr6;

    private double ntpcr1;
    private double ntpcr2;
    private double ntpcr3;
    private double ntpcr4;
    private double ntpcr5;
    private double ntpcr6;

    private double ntpdr1;
    private double ntpdr2;
    private double ntpdr3;
    private double ntpdr4;
    private double ntpdr5;
    private double ntpdr6;

    private double ntper1;
    private double ntper2;
    private double ntper3;
    private double ntper4;
    private double ntper5;
    private double ntper6;

    public SalesBean() throws SQLException {
        gradeCheck();
        offerUpdate();
        calPAll();
    }

    public void gradeCheck() throws SQLException {
        Connection con = Database.getConnection();
        try {
            String sql = "select * from representatives";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (rs.getString("route_no").equals("1")) {
                    setRoute1Grade(rs.getString("gradeName"));
                    setRoute1(rs.getString("rep_name").toUpperCase() + "-" + rs.getString("route_no"));
                    setRepIdR1(rs.getInt(1));
                    setRepName1(rs.getString("rep_name").toUpperCase());
                }

                if (rs.getString("route_no").equals("2")) {
                    setRoute2Grade(rs.getString("gradeName"));
                    setRoute2(rs.getString("rep_name").toUpperCase() + "-" + rs.getString("route_no"));
                    setRepIdR2(rs.getInt(1));
                    setRepName2(rs.getString("rep_name").toUpperCase());
                }
                if (rs.getString("route_no").equals("3")) {
                    setRoute3Grade(rs.getString("gradeName"));
                    setRoute3(rs.getString("rep_name").toUpperCase() + "-" + rs.getString("route_no"));
                    setRepIdR3(rs.getInt(1));
                    setRepName3(rs.getString("rep_name").toUpperCase());
                   
                }

                if (rs.getString("route_no").equals("4")) {
                    setRoute4Grade(rs.getString("gradeName"));
                    setRoute4(rs.getString("rep_name").toUpperCase() + "-" + rs.getString("route_no"));
                    setRepIdR4(rs.getInt(1));
                    setRepName4(rs.getString("rep_name").toUpperCase());
                }
                if (rs.getString("route_no").equals("5")) {
                    setRoute5Grade(rs.getString("gradeName"));
                    setRoute5(rs.getString("rep_name").toUpperCase() + "-" + rs.getString("route_no"));
                    setRepIdR5(rs.getInt(1));
                    setRepName5(rs.getString("rep_name").toUpperCase());
                }
                if (rs.getString("route_no").equals("6")) {
                    setRoute6Grade(rs.getString("gradeName"));
                    setRoute6(rs.getString("rep_name").toUpperCase() + "-" + rs.getString("route_no"));
                    setRepIdR6(rs.getInt(1));
                    setRepName6(rs.getString("rep_name").toUpperCase());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            con.close();
        }
    }

    public void PDist() {
        Connection con = null;
        ResultSet rs = null;
        ResultSet rs2 = null;

        try {

            con = Database.getConnection();
            String sql = "select * from representatives";
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            int route1counterA = 0;
            int route1counterB = 0;
            int route1counterC = 0;
            int route1counterD = 0;

            while (rs.next()) {
                if (rs.getString("gradeName").toUpperCase().equals("A")) {
                    route1counterA += 1;

                } else if (rs.getString("gradeName").toUpperCase().equals("B")) {
                    route1counterB += 1;
                } else if (rs.getString("gradeName").toUpperCase().equals("C")) {
                    route1counterC += 1;
                } else if (rs.getString("gradeName").toUpperCase().equals("D")) {
                    route1counterD += 1;
                }
            }
            String sql2 = "select * from representatives";
            PreparedStatement stm2 = con.prepareStatement(sql2);
            rs2 = stm2.executeQuery();

            while (rs2.next()) {
                if (rs2.getString("route_no").equals("1")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR1p1(String.valueOf(Math.round(route1ifA)));
                            double taka = ((Math.round(route1ifA) * pricepa) - ((Math.round(route1ifA) * pricepa) / 100 * opa)) / 1000;
                            setNtpar1(taka);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR1p1(String.valueOf(Math.round(route1ifB)));
                            double taka1 = ((Math.round(route1ifB) * pricepa) - ((Math.round(route1ifB) * pricepa) / 100 * opa)) / 1000;
                            setNtpar1(taka1);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR1p1(String.valueOf(Math.round(route1ifC)));
                            double taka2 = ((Math.round(route1ifC) * pricepa) - ((Math.round(route1ifC) * pricepa) / 100 * opa)) / 1000;
                            setNtpar1(taka2);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR1p1(String.valueOf(Math.round(route1ifD)));
                            double taka3 = ((Math.round(route1ifD) * pricepa) - ((Math.round(route1ifD) * pricepa) / 100 * opa)) / 1000;
                            setNtpar1(taka3);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("2")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route2ifA = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR2p1(String.valueOf(Math.round(route2ifA)));
                            double taka1 = ((Math.round(route2ifA) * pricepa) - ((Math.round(route2ifA) * pricepa) / 100 * opa)) / 1000;
                            setNtpar2(taka1);
                            break;
                        case "B":
                            double route2ifB = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR2p1(String.valueOf(Math.round(route2ifB)));
                            double taka2 = ((Math.round(route2ifB) * pricepa) - ((Math.round(route2ifB) * pricepa) / 100 * opa)) / 1000;
                            setNtpar2(taka2);
                            break;
                        case "C":
                            double route2ifC = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR2p1(String.valueOf(Math.round(route2ifC)));
                            double taka3 = ((Math.round(route2ifC) * pricepa) - ((Math.round(route2ifC) * pricepa) / 100 * opa)) / 1000;
                            setNtpar2(taka3);
                            break;
                        case "D":
                            double route2ifD = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR2p1(String.valueOf(Math.round(route2ifD)));
                            double taka4 = ((Math.round(route2ifD) * pricepa) - ((Math.round(route2ifD) * pricepa) / 100 * opa)) / 1000;
                            setNtpar2(taka4);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("3")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route3ifA = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR3p1(String.valueOf(Math.round(route3ifA)));
                            double taka3 = ((Math.round(route3ifA) * pricepa) - ((Math.round(route3ifA) * pricepa) / 100 * opa)) / 1000;
                            setNtpar3(taka3);
                            break;
                        case "B":
                            double route3ifB = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR3p1(String.valueOf(Math.round(route3ifB)));
                            double taka4 = ((Math.round(route3ifB) * pricepa) - ((Math.round(route3ifB) * pricepa) / 100 * opa)) / 1000;
                            setNtpar3(taka4);
                            break;
                        case "C":
                            double route3ifC = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR3p1(String.valueOf(Math.round(route3ifC)));
                            double taka5 = ((Math.round(route3ifC) * pricepa) - ((Math.round(route3ifC) * pricepa) / 100 * opa)) / 1000;
                            setNtpar3(taka5);
                            break;
                        case "D":
                            double route3ifD = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR3p1(String.valueOf(Math.round(route3ifD)));
                            double taka6 = ((Math.round(route3ifD) * pricepa) - ((Math.round(route3ifD) * pricepa) / 100 * opa)) / 1000;
                            setNtpar3(taka6);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("4")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route4ifA = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR4p1(String.valueOf(Math.round(route4ifA)));
                            double taka6 = ((Math.round(route4ifA) * pricepa) - ((Math.round(route4ifA) * pricepa) / 100 * opa)) / 1000;
                            setNtpar4(taka6);
                            break;
                        case "B":
                            double route4ifB = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR4p1(String.valueOf(Math.round(route4ifB)));
                            double taka7 = ((Math.round(route4ifB) * pricepa) - ((Math.round(route4ifB) * pricepa) / 100 * opa)) / 1000;
                            setNtpar4(taka7);
                            break;
                        case "C":
                            double route4ifC = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR4p1(String.valueOf(Math.round(route4ifC)));
                            double taka8 = ((Math.round(route4ifC) * pricepa) - ((Math.round(route4ifC) * pricepa) / 100 * opa)) / 1000;
                            setNtpar4(taka8);
                            break;
                        case "D":
                            double route4ifD = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR4p1(String.valueOf(Math.round(route4ifD)));
                            double taka9 = ((Math.round(route4ifD) * pricepa) - ((Math.round(route4ifD) * pricepa) / 100 * opa)) / 1000;
                            setNtpar4(taka9);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("5")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route5ifA = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR5p1(String.valueOf(Math.round(route5ifA)));
                            double taka10 = ((Math.round(route5ifA) * pricepa) - ((Math.round(route5ifA) * pricepa) / 100 * opa)) / 1000;
                            setNtpar5(taka10);
                            break;
                        case "B":
                            double route5ifB = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR5p1(String.valueOf(Math.round(route5ifB)));
                            double taka11 = ((Math.round(route5ifB) * pricepa) - ((Math.round(route5ifB) * pricepa) / 100 * opa)) / 1000;
                            setNtpar5(taka11);
                            break;
                        case "C":
                            double route5ifC = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR5p1(String.valueOf(Math.round(route5ifC)));
                            double taka12 = ((Math.round(route5ifC) * pricepa) - ((Math.round(route5ifC) * pricepa) / 100 * opa)) / 1000;
                            setNtpar5(taka12);
                            break;
                        case "D":
                            double route5ifD = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR5p1(String.valueOf(Math.round(route5ifD)));
                            double taka13 = ((Math.round(route5ifD) * pricepa) - ((Math.round(route5ifD) * pricepa) / 100 * opa)) / 1000;
                            setNtpar5(taka13);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("6")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route6ifA = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR6p1(String.valueOf(Math.round(route6ifA)));
                            double takaA = ((Math.round(route6ifA) * pricepa) - ((Math.round(route6ifA) * pricepa) / 100 * opa)) / 1000;
                            setNtpar6(takaA);
                            break;
                        case "B":
                            double route6ifB = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR6p1(String.valueOf(Math.round(route6ifB)));
                            double takaB = ((Math.round(route6ifB) * pricepa) - ((Math.round(route6ifB) * pricepa) / 100 * opa)) / 1000;
                            setNtpar6(takaB);
                            break;
                        case "C":
                            double route6ifC = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR6p1(String.valueOf(Math.round(route6ifC)));
                            double takaC = ((Math.round(route6ifC) * pricepa) - ((Math.round(route6ifC) * pricepa) / 100 * opa)) / 1000;
                            setNtpar6(takaC);
                            break;
                        case "D":
                            double route6ifD = Double.parseDouble(proA1) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR6p1(String.valueOf(Math.round(route6ifD)));
                            double takaD = ((Math.round(route6ifD) * pricepa) - ((Math.round(route6ifD) * pricepa) / 100 * opa)) / 1000;
                            setNtpar6(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SalesBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("connection and others properly closed.");

        }

    }

    public void PDist2() {
        Connection con = null;
        ResultSet rs = null;
        ResultSet rs2 = null;

        try {

            con = Database.getConnection();
            String sql = "select * from representatives";
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            int route1counterA = 0;
            int route1counterB = 0;
            int route1counterC = 0;
            int route1counterD = 0;

            while (rs.next()) {
                if (rs.getString("gradeName").toUpperCase().equals("A")) {
                    route1counterA += 1;

                } else if (rs.getString("gradeName").toUpperCase().equals("B")) {
                    route1counterB += 1;
                } else if (rs.getString("gradeName").toUpperCase().equals("C")) {
                    route1counterC += 1;
                } else if (rs.getString("gradeName").toUpperCase().equals("D")) {
                    route1counterD += 1;
                }
            }
            String sql2 = "select * from representatives";
            PreparedStatement stm2 = con.prepareStatement(sql2);
            rs2 = stm2.executeQuery();

            while (rs2.next()) {
                if (rs2.getString("route_no").equals("1")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR1p2(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepb) - ((Math.round(route1ifA) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr1(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR1p2(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepb) - ((Math.round(route1ifB) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr1(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR1p2(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepb) - ((Math.round(route1ifC) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr1(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR1p2(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepb) - ((Math.round(route1ifD) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr1(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("2")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route2ifA = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR2p2(String.valueOf(Math.round(route2ifA)));
                            double takaA = ((Math.round(route2ifA) * pricepb) - ((Math.round(route2ifA) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr2(takaA);
                            break;
                        case "B":
                            double route2ifB = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR2p2(String.valueOf(Math.round(route2ifB)));
                            double takaB = ((Math.round(route2ifB) * pricepb) - ((Math.round(route2ifB) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr2(takaB);
                            break;
                        case "C":
                            double route2ifC = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR2p2(String.valueOf(Math.round(route2ifC)));
                            double takaC = ((Math.round(route2ifC) * pricepb) - ((Math.round(route2ifC) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr2(takaC);
                            break;
                        case "D":
                            double route2ifD = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR2p2(String.valueOf(Math.round(route2ifD)));
                            double takaD = ((Math.round(route2ifD) * pricepb) - ((Math.round(route2ifD) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr2(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("3")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route3ifA = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR3p3(String.valueOf(Math.round(route3ifA)));
                            double takaD = ((Math.round(route3ifA) * pricepb) - ((Math.round(route3ifA) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr3(takaD);
                            break;
                        case "B":
                            double route3ifB = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR3p2(String.valueOf(Math.round(route3ifB)));
                            double takaA = ((Math.round(route3ifB) * pricepb) - ((Math.round(route3ifB) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr3(takaA);
                            break;
                        case "C":
                            double route3ifC = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR3p2(String.valueOf(Math.round(route3ifC)));
                            double takaC = ((Math.round(route3ifC) * pricepb) - ((Math.round(route3ifC) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr3(takaC);
                            break;
                        case "D":
                            double route3ifD = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR3p2(String.valueOf(Math.round(route3ifD)));
                            double takaE = ((Math.round(route3ifD) * pricepb) - ((Math.round(route3ifD) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr3(takaE);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("4")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route4ifA = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR4p2(String.valueOf(Math.round(route4ifA)));
                            double takaA = ((Math.round(route4ifA) * pricepb) - ((Math.round(route4ifA) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr4(takaA);
                            break;
                        case "B":
                            double route4ifB = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR4p2(String.valueOf(Math.round(route4ifB)));
                            double takab = ((Math.round(route4ifB) * pricepb) - ((Math.round(route4ifB) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr4(takab);
                            break;
                        case "C":
                            double route4ifC = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR4p2(String.valueOf(Math.round(route4ifC)));
                            double takac = ((Math.round(route4ifC) * pricepb) - ((Math.round(route4ifC) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr4(takac);
                            break;
                        case "D":
                            double route4ifD = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR4p2(String.valueOf(Math.round(route4ifD)));
                            double takad = ((Math.round(route4ifD) * pricepb) - ((Math.round(route4ifD) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr4(takad);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("5")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route5ifA = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR5p2(String.valueOf(Math.round(route5ifA)));
                            double takaa = ((Math.round(route5ifA) * pricepb) - ((Math.round(route5ifA) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr4(takaa);
                            break;
                        case "B":
                            double route5ifB = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR5p2(String.valueOf(Math.round(route5ifB)));
                            double takab = ((Math.round(route5ifB) * pricepb) - ((Math.round(route5ifB) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr4(takab);
                            break;
                        case "C":
                            double route5ifC = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR5p2(String.valueOf(Math.round(route5ifC)));
                            double takac = ((Math.round(route5ifC) * pricepb) - ((Math.round(route5ifC) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr4(takac);
                            break;
                        case "D":
                            double route5ifD = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR5p2(String.valueOf(Math.round(route5ifD)));
                            double takad = ((Math.round(route5ifD) * pricepb) - ((Math.round(route5ifD) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr4(takad);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("6")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route6ifA = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR6p2(String.valueOf(Math.round(route6ifA)));
                            double takad = ((Math.round(route6ifA) * pricepb) - ((Math.round(route6ifA) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr4(takad);
                            break;
                        case "B":
                            double route6ifB = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR6p2(String.valueOf(Math.round(route6ifB)));
                            double takaa = ((Math.round(route6ifB) * pricepb) - ((Math.round(route6ifB) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr4(takaa);
                            break;
                        case "C":
                            double route6ifC = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR6p2(String.valueOf(Math.round(route6ifC)));
                            double takab = ((Math.round(route6ifC) * pricepb) - ((Math.round(route6ifC) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr4(takab);
                            break;
                        case "D":
                            double route6ifD = Double.parseDouble(proA2) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR6p2(String.valueOf(Math.round(route6ifD)));
                            double takac = ((Math.round(route6ifD) * pricepb) - ((Math.round(route6ifD) * pricepb) / 100 * opa)) / 1000;
                            setNtpbr4(takac);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SalesBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("connection and others properly closed.");

        }

    }

    public void PDist3() {
        Connection con = null;
        ResultSet rs = null;
        ResultSet rs2 = null;

        try {

            con = Database.getConnection();
            String sql = "select * from representatives";
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            int route1counterA = 0;
            int route1counterB = 0;
            int route1counterC = 0;
            int route1counterD = 0;

            while (rs.next()) {
                if (rs.getString("gradeName").toUpperCase().equals("A")) {
                    route1counterA += 1;

                } else if (rs.getString("gradeName").toUpperCase().equals("B")) {
                    route1counterB += 1;
                } else if (rs.getString("gradeName").toUpperCase().equals("C")) {
                    route1counterC += 1;
                } else if (rs.getString("gradeName").toUpperCase().equals("D")) {
                    route1counterD += 1;
                }
            }
            String sql2 = "select * from representatives";
            PreparedStatement stm2 = con.prepareStatement(sql2);
            rs2 = stm2.executeQuery();

            while (rs2.next()) {
                if (rs2.getString("route_no").equals("1")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR1p3(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepc) - ((Math.round(route1ifA) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr1(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR1p3(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepc) - ((Math.round(route1ifB) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr1(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR1p3(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepc) - ((Math.round(route1ifC) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr1(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR1p3(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepc) - ((Math.round(route1ifD) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr1(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("2")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR2p3(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepc) - ((Math.round(route1ifA) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr2(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR2p3(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepc) - ((Math.round(route1ifB) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr2(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR2p3(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepc) - ((Math.round(route1ifC) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr2(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR2p3(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepc) - ((Math.round(route1ifD) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr2(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("3")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR3p3(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepc) - ((Math.round(route1ifA) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr3(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR3p3(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepc) - ((Math.round(route1ifB) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr3(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR3p3(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepc) - ((Math.round(route1ifC) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr3(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR3p3(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepc) - ((Math.round(route1ifD) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr3(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("4")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR4p3(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepc) - ((Math.round(route1ifA) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr4(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR4p3(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepc) - ((Math.round(route1ifB) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr4(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR4p3(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepc) - ((Math.round(route1ifC) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr4(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR4p3(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepc) - ((Math.round(route1ifD) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr4(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("5")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR5p3(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepc) - ((Math.round(route1ifA) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr5(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR5p3(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepc) - ((Math.round(route1ifB) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr5(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR5p3(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepc) - ((Math.round(route1ifC) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr5(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR5p3(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepc) - ((Math.round(route1ifD) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr5(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("6")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR6p3(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepc) - ((Math.round(route1ifA) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr6(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR6p3(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepc) - ((Math.round(route1ifB) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr6(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR6p3(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepc) - ((Math.round(route1ifC) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr6(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA3) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR6p3(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepc) - ((Math.round(route1ifD) * pricepc) / 100 * opa)) / 1000;
                            setNtpcr6(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SalesBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("connection and others properly closed.");

        }

    }

    public void PDist4() {
        Connection con = null;
        ResultSet rs = null;
        ResultSet rs2 = null;

        try {

            con = Database.getConnection();
            String sql = "select * from representatives";
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            int route1counterA = 0;
            int route1counterB = 0;
            int route1counterC = 0;
            int route1counterD = 0;

            while (rs.next()) {
                if (rs.getString("gradeName").toUpperCase().equals("A")) {
                    route1counterA += 1;

                } else if (rs.getString("gradeName").toUpperCase().equals("B")) {
                    route1counterB += 1;
                } else if (rs.getString("gradeName").toUpperCase().equals("C")) {
                    route1counterC += 1;
                } else if (rs.getString("gradeName").toUpperCase().equals("D")) {
                    route1counterD += 1;
                }
            }
            String sql2 = "select * from representatives";
            PreparedStatement stm2 = con.prepareStatement(sql2);
            rs2 = stm2.executeQuery();

            while (rs2.next()) {
                if (rs2.getString("route_no").equals("1")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR1p4(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepd) - ((Math.round(route1ifA) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr1(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR1p4(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepd) - ((Math.round(route1ifB) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr1(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR1p4(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepd) - ((Math.round(route1ifC) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr1(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR1p4(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepd) - ((Math.round(route1ifD) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr1(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("2")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR2p4(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepd) - ((Math.round(route1ifA) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr2(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR2p4(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepd) - ((Math.round(route1ifB) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr2(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR2p4(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepd) - ((Math.round(route1ifC) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr2(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR2p4(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepd) - ((Math.round(route1ifD) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr2(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("3")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR3p4(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepd) - ((Math.round(route1ifA) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr3(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR3p4(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepd) - ((Math.round(route1ifB) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr3(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR3p4(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepd) - ((Math.round(route1ifC) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr3(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR3p4(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepd) - ((Math.round(route1ifD) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr3(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("4")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR4p4(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepd) - ((Math.round(route1ifA) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr4(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR4p4(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepd) - ((Math.round(route1ifB) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr4(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR4p4(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepd) - ((Math.round(route1ifC) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr4(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR4p4(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepd) - ((Math.round(route1ifD) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr4(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("5")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR5p4(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepd) - ((Math.round(route1ifA) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr5(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR5p4(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepd) - ((Math.round(route1ifB) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr5(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR5p4(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepd) - ((Math.round(route1ifC) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr5(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR5p4(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepd) - ((Math.round(route1ifD) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr5(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("6")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR6p4(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepd) - ((Math.round(route1ifA) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr6(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR6p4(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepd) - ((Math.round(route1ifB) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr6(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR6p4(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepd) - ((Math.round(route1ifC) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr6(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA4) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR6p4(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepd) - ((Math.round(route1ifD) * pricepd) / 100 * opa)) / 1000;
                            setNtpdr6(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SalesBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("connection and others properly closed.");

        }

    }

    public void PDist5() {
        Connection con = null;
        ResultSet rs = null;
        ResultSet rs2 = null;

        try {

            con = Database.getConnection();
            String sql = "select * from representatives";
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            int route1counterA = 0;
            int route1counterB = 0;
            int route1counterC = 0;
            int route1counterD = 0;

            while (rs.next()) {
                if (rs.getString("gradeName").toUpperCase().equals("A")) {
                    route1counterA += 1;

                } else if (rs.getString("gradeName").toUpperCase().equals("B")) {
                    route1counterB += 1;
                } else if (rs.getString("gradeName").toUpperCase().equals("C")) {
                    route1counterC += 1;
                } else if (rs.getString("gradeName").toUpperCase().equals("D")) {
                    route1counterD += 1;
                }
            }
            String sql2 = "select * from representatives";
            PreparedStatement stm2 = con.prepareStatement(sql2);
            rs2 = stm2.executeQuery();

            while (rs2.next()) {
                if (rs2.getString("route_no").equals("1")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR1p5(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepe) - ((Math.round(route1ifA) * pricepe) / 100 * opa)) / 1000;
                            setNtper1(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR1p5(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepe) - ((Math.round(route1ifB) * pricepe) / 100 * opa)) / 1000;
                            setNtper1(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR1p5(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepe) - ((Math.round(route1ifC) * pricepe) / 100 * opa)) / 1000;
                            setNtper1(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR1p5(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepe) - ((Math.round(route1ifD) * pricepe) / 100 * opa)) / 1000;
                            setNtper1(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("2")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR2p5(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepe) - ((Math.round(route1ifA) * pricepe) / 100 * opa)) / 1000;
                            setNtper2(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR2p5(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepe) - ((Math.round(route1ifB) * pricepe) / 100 * opa)) / 1000;
                            setNtper2(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR2p5(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepe) - ((Math.round(route1ifC) * pricepe) / 100 * opa)) / 1000;
                            setNtper2(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR2p5(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepe) - ((Math.round(route1ifD) * pricepe) / 100 * opa)) / 1000;
                            setNtper2(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("3")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR3p5(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepe) - ((Math.round(route1ifA) * pricepe) / 100 * opa)) / 1000;
                            setNtper3(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR3p5(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepe) - ((Math.round(route1ifB) * pricepe) / 100 * opa)) / 1000;
                            setNtper3(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR3p5(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepe) - ((Math.round(route1ifC) * pricepe) / 100 * opa)) / 1000;
                            setNtper3(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR3p5(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepe) - ((Math.round(route1ifD) * pricepe) / 100 * opa)) / 1000;
                            setNtper3(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("4")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR4p5(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepe) - ((Math.round(route1ifA) * pricepe) / 100 * opa)) / 1000;
                            setNtper4(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR4p5(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepe) - ((Math.round(route1ifB) * pricepe) / 100 * opa)) / 1000;
                            setNtper4(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR4p5(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepe) - ((Math.round(route1ifC) * pricepe) / 100 * opa)) / 1000;
                            setNtper4(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR4p5(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepe) - ((Math.round(route1ifD) * pricepe) / 100 * opa)) / 1000;
                            setNtper4(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("5")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR5p5(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepe) - ((Math.round(route1ifA) * pricepe) / 100 * opa)) / 1000;
                            setNtper5(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR5p5(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepe) - ((Math.round(route1ifB) * pricepe) / 100 * opa)) / 1000;
                            setNtper5(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR5p5(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepe) - ((Math.round(route1ifC) * pricepe) / 100 * opa)) / 1000;
                            setNtper5(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR5p5(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepe) - ((Math.round(route1ifD) * pricepe) / 100 * opa)) / 1000;
                            setNtper5(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
                if (rs2.getString("route_no").equals("6")) {

                    switch (rs2.getString("gradeName").toUpperCase()) {
                        case "A":
                            double route1ifA = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeA) / route1counterA;
                            setR6p5(String.valueOf(Math.round(route1ifA)));
                            double takaA = ((Math.round(route1ifA) * pricepe) - ((Math.round(route1ifA) * pricepe) / 100 * opa)) / 1000;
                            setNtper6(takaA);
                            break;
                        case "B":
                            double route1ifB = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeB) / route1counterB;
                            setR6p5(String.valueOf(Math.round(route1ifB)));
                            double takaB = ((Math.round(route1ifB) * pricepe) - ((Math.round(route1ifB) * pricepe) / 100 * opa)) / 1000;
                            setNtper6(takaB);
                            break;
                        case "C":
                            double route1ifC = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeC) / route1counterC;
                            setR6p5(String.valueOf(Math.round(route1ifC)));
                            double takaC = ((Math.round(route1ifC) * pricepe) - ((Math.round(route1ifC) * pricepe) / 100 * opa)) / 1000;
                            setNtper6(takaC);
                            break;
                        case "D":
                            double route1ifD = Double.parseDouble(proA5) / 100 * Double.parseDouble(gradeD) / route1counterD;
                            setR6p5(String.valueOf(Math.round(route1ifD)));
                            double takaD = ((Math.round(route1ifD) * pricepe) - ((Math.round(route1ifD) * pricepe) / 100 * opa)) / 1000;
                            setNtper6(takaD);
                            break;
                        default:
                            System.out.println(route1counterA);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {

            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SalesBean.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("connection and others properly closed.");

        }

    }

    public void doSave() {
        Integer counter = new Integer(5250);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = sdf.format(date);
        Connection con = null;
        String checkDate = null;
        String checkrepId = null;

        try {
            con = Database.getConnection();
            PreparedStatement stm = con.prepareStatement("select * from sales where rep_id=? and date=?");
            stm.setInt(1, repIdR1);
            stm.setDate(2, java.sql.Date.valueOf(date1));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                checkDate = rs.getString("date");
                checkrepId = rs.getString("rep_id");
            }
        } catch (Exception e) {

        }

        try {
            if (checkrepId == null && checkDate == null) {
                con = Database.getConnection();
                String sql1 = "insert into sales (rep_id, rep_name, xiongshiA, YitongB, YITONGC, YITONGD, XiongshiE, unit_price, offer, date) values(?,?,?,?,?,?,?,?,?,?)";
                String sql2 = "insert into sales (rep_id, rep_name, xiongshiA, YitongB, YITONGC, YITONGD, XiongshiE, unit_price, offer, date) values(?,?,?,?,?,?,?,?,?,?)";
                String sql3 = "insert into sales (rep_id, rep_name, xiongshiA, YitongB, YITONGC, YITONGD, XiongshiE, unit_price, offer, date) values(?,?,?,?,?,?,?,?,?,?)";
                String sql4 = "insert into sales (rep_id, rep_name, xiongshiA, YitongB, YITONGC, YITONGD, XiongshiE, unit_price, offer, date) values(?,?,?,?,?,?,?,?,?,?)";
                String sql5 = "insert into sales (rep_id, rep_name, xiongshiA, YitongB, YITONGC, YITONGD, XiongshiE, unit_price, offer, date) values(?,?,?,?,?,?,?,?,?,?)";
               String sql6 = "insert into sales (rep_id, rep_name, xiongshiA, YitongB, YITONGC, YITONGD, XiongshiE, unit_price, offer, date) values(?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stm1 = con.prepareStatement(sql1);
                stm1.setInt(1, repIdR1);
                stm1.setString(2, repName1);
                stm1.setInt(3, Integer.parseInt(r1p1));
                stm1.setInt(4, Integer.parseInt(r1p2));
                stm1.setInt(5, Integer.parseInt(r1p3));
                stm1.setInt(6, Integer.parseInt(r1p4));
                stm1.setInt(7, Integer.parseInt(r1p5));
                stm1.setDouble(8, ntpar1 + ntpbr1 + ntpcr1 + ntpdr1 + ntper1);
                stm1.setInt(9, opa + opb + opc + opd + ope);
                stm1.setDate(10, java.sql.Date.valueOf(date1));

                PreparedStatement stm2 = con.prepareStatement(sql2);

                stm2.setInt(1, repIdR2);
                stm2.setString(2, repName2);
                stm2.setInt(3, Integer.parseInt(r2p1));
                stm2.setInt(4, Integer.parseInt(r2p2));
                stm2.setInt(5, Integer.parseInt(r2p3));
                stm2.setInt(6, Integer.parseInt(r2p4));
                stm2.setInt(7, Integer.parseInt(r2p5));
                stm2.setDouble(8, ntpar2 + ntpbr2 + ntpcr2 + ntpdr1 + ntper2);
                stm2.setInt(9, opa + opb + opc + opd + ope);
                stm2.setDate(10, java.sql.Date.valueOf(date1));

                PreparedStatement stm3 = con.prepareStatement(sql3);
                stm3.setInt(1, repIdR3);
                stm3.setString(2, repName3);
                stm3.setInt(3, Integer.parseInt(r3p1));
                stm3.setInt(4, Integer.parseInt(r3p2));
                stm3.setInt(5, Integer.parseInt(r3p3));
                stm3.setInt(6, Integer.parseInt(r3p4));
                stm3.setInt(7, Integer.parseInt(r3p5));
                stm3.setDouble(8, ntpar3 + ntpbr3 + ntpcr3 + ntpdr3 + ntper3);
                stm3.setInt(9, opa + opb + opc + opd + ope);
                stm3.setDate(10, java.sql.Date.valueOf(date1));

                PreparedStatement stm4 = con.prepareStatement(sql4);

                stm4.setInt(1, repIdR4);
                stm4.setString(2, repName4);
                stm4.setInt(3, Integer.parseInt(r4p1));
                stm4.setInt(4, Integer.parseInt(r4p2));
                stm4.setInt(5, Integer.parseInt(r4p3));
                stm4.setInt(6, Integer.parseInt(r4p4));
                stm4.setInt(7, Integer.parseInt(r4p5));
                stm4.setDouble(8, ntpar4 + ntpbr4 + ntpcr4 + ntpdr4 + ntper4);
                stm4.setInt(9, opa + opb + opc + opd + ope);
                stm4.setDate(10, java.sql.Date.valueOf(date1));

                PreparedStatement stm5 = con.prepareStatement(sql5);

                stm5.setInt(1, repIdR5);
                stm5.setString(2, repName5);
                stm5.setInt(3, Integer.parseInt(r5p1));
                stm5.setInt(4, Integer.parseInt(r5p2));
                stm5.setInt(5, Integer.parseInt(r5p3));
                stm5.setInt(6, Integer.parseInt(r5p4));
                stm5.setInt(7, Integer.parseInt(r5p5));
                stm5.setDouble(8, ntpar5 + ntpbr5 + ntpcr5 + ntpdr5 + ntper5);
                stm5.setInt(9, opa + opb + opc + opd + ope);
                stm5.setDate(10, java.sql.Date.valueOf(date1));

                PreparedStatement stm6 = con.prepareStatement(sql6);

                stm6.setInt(1, repIdR6);
                stm6.setString(2, repName6);
                stm6.setInt(3, Integer.parseInt(r6p1));
                stm6.setInt(4, Integer.parseInt(r6p2));
                stm6.setInt(5, Integer.parseInt(r6p3));
                stm6.setInt(6, Integer.parseInt(r6p4));
                stm6.setInt(7, Integer.parseInt(r6p5));
                stm6.setDouble(8, ntpar6 + ntpbr6 + ntpcr6 + ntpdr6 + ntper6);
                stm6.setInt(9, opa + opb + opc + opd + ope);
                stm6.setDate(10, java.sql.Date.valueOf(date1));

                int r1 = stm1.executeUpdate();
                int r2 = stm2.executeUpdate();
                int r3 = stm3.executeUpdate();
                int r4 = stm4.executeUpdate();
                int r5 = stm5.executeUpdate();
                int r6 = stm6.executeUpdate();

                if (r3 > 0) {
                    addMessage("saved");
                } else {
                    addMessage("Not Saved");
                }
            } else {
                this.addMessage("Update Features not available in this moment.");
            }
        } catch (Exception e) {
            addMessage("Exception");
            addMessage(e.getMessage());
        }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void offerUpdate() {
        Calendar rightNow = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(rightNow.getTime());
        Connection con = null;
        ResultSet rs = null;
        try {

            con = Database.getConnection();
            String sql = "select * from offer where Offer_date=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setDate(1, java.sql.Date.valueOf(date));
            rs = stm.executeQuery();
            if (rs.next()) {
                setOpa(rs.getInt(2));
                setOpb(rs.getInt(3));
                setOpc(rs.getInt(4));
                setOpd(rs.getInt(5));
                setOpe(rs.getInt(6));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void calPAll() {
        Connection con = null;
        ResultSet rs = null;
        try {
            con = Database.getConnection();
            String sql = "select * from prices";
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                setPricepa(rs.getDouble(2));
                setPricepb(rs.getDouble(3));
                setPricepc(rs.getDouble(4));
                setPricepd(rs.getDouble(5));
                setPricepe(rs.getDouble(6));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException {
        SalesBean s = new SalesBean();
        s.gradeCheck();
    }

    public String getR1p1() {
        return r1p1;
    }

    public void setR1p1(String r1p1) {
        this.r1p1 = r1p1;
    }

    public String getR1p2() {
        return r1p2;
    }

    public void setR1p2(String r1p2) {
        this.r1p2 = r1p2;
    }

    public String getR1p3() {
        return r1p3;
    }

    public void setR1p3(String r1p3) {
        this.r1p3 = r1p3;
    }

    public String getR1p4() {
        return r1p4;
    }

    public void setR1p4(String r1p4) {
        this.r1p4 = r1p4;
    }

    public String getR1p5() {
        return r1p5;
    }

    public void setR1p5(String r1p5) {
        this.r1p5 = r1p5;
    }

    public String getR2p1() {
        return r2p1;
    }

    public void setR2p1(String r2p1) {
        this.r2p1 = r2p1;
    }

    public String getR2p2() {
        return r2p2;
    }

    public void setR2p2(String r2p2) {
        this.r2p2 = r2p2;
    }

    public String getR2p3() {
        return r2p3;
    }

    public void setR2p3(String r2p3) {
        this.r2p3 = r2p3;
    }

    public String getR2p4() {
        return r2p4;
    }

    public void setR2p4(String r2p4) {
        this.r2p4 = r2p4;
    }

    public String getR2p5() {
        return r2p5;
    }

    public void setR2p5(String r2p5) {
        this.r2p5 = r2p5;
    }

    public String getR3p1() {
        return r3p1;
    }

    public void setR3p1(String r3p1) {
        this.r3p1 = r3p1;
    }

    public String getR3p2() {
        return r3p2;
    }

    public void setR3p2(String r3p2) {
        this.r3p2 = r3p2;
    }

    public String getR3p3() {
        return r3p3;
    }

    public void setR3p3(String r3p3) {
        this.r3p3 = r3p3;
    }

    public String getR3p4() {
        return r3p4;
    }

    public void setR3p4(String r3p4) {
        this.r3p4 = r3p4;
    }

    public String getR3p5() {
        return r3p5;
    }

    public void setR3p5(String r3p5) {
        this.r3p5 = r3p5;
    }

    public String getR4p1() {
        return r4p1;
    }

    public void setR4p1(String r4p1) {
        this.r4p1 = r4p1;
    }

    public String getR4p2() {
        return r4p2;
    }

    public void setR4p2(String r4p2) {
        this.r4p2 = r4p2;
    }

    public String getR4p3() {
        return r4p3;
    }

    public void setR4p3(String r4p3) {
        this.r4p3 = r4p3;
    }

    public String getR4p4() {
        return r4p4;
    }

    public void setR4p4(String r4p4) {
        this.r4p4 = r4p4;
    }

    public String getR4p5() {
        return r4p5;
    }

    public void setR4p5(String r4p5) {
        this.r4p5 = r4p5;
    }

    public String getR5p1() {
        return r5p1;
    }

    public void setR5p1(String r5p1) {
        this.r5p1 = r5p1;
    }

    public String getR5p2() {
        return r5p2;
    }

    public void setR5p2(String r5p2) {
        this.r5p2 = r5p2;
    }

    public String getR5p3() {
        return r5p3;
    }

    public void setR5p3(String r5p3) {
        this.r5p3 = r5p3;
    }

    public String getR5p4() {
        return r5p4;
    }

    public void setR5p4(String r5p4) {
        this.r5p4 = r5p4;
    }

    public String getR5p5() {
        return r5p5;
    }

    public void setR5p5(String r5p5) {
        this.r5p5 = r5p5;
    }

    public String getR6p1() {
        return r6p1;
    }

    public void setR6p1(String r6p1) {
        this.r6p1 = r6p1;
    }

    public String getR6p2() {
        return r6p2;
    }

    public void setR6p2(String r6p2) {
        this.r6p2 = r6p2;
    }

    public String getR6p3() {
        return r6p3;
    }

    public void setR6p3(String r6p3) {
        this.r6p3 = r6p3;
    }

    public String getR6p4() {
        return r6p4;
    }

    public void setR6p4(String r6p4) {
        this.r6p4 = r6p4;
    }

    public String getR6p5() {
        return r6p5;
    }

    public void setR6p5(String r6p5) {
        this.r6p5 = r6p5;
    }

    public String getGradeA() {
        return gradeA;
    }

    public void setGradeA(String gradeA) {
        this.gradeA = gradeA;
    }

    public String getGradeB() {
        return gradeB;
    }

    public void setGradeB(String gradeB) {
        this.gradeB = gradeB;
    }

    public String getGradeC() {
        return gradeC;
    }

    public void setGradeC(String gradeC) {
        this.gradeC = gradeC;
    }

    public String getGradeD() {
        return gradeD;
    }

    public void setGradeD(String gradeD) {
        this.gradeD = gradeD;
    }

    public String getRoute1() {
        return route1;
    }

    public void setRoute1(String route1) {
        this.route1 = route1;
    }

    public String getRoute1Grade() {
        return route1Grade;
    }

    public void setRoute1Grade(String route1Grade) {
        this.route1Grade = route1Grade;
    }

    public String getRoute2() {
        return route2;
    }

    public void setRoute2(String route2) {
        this.route2 = route2;
    }

    public String getRoute2Grade() {
        return route2Grade;
    }

    public void setRoute2Grade(String route2Grade) {
        this.route2Grade = route2Grade;
    }

    public String getRoute3() {
        return route3;
    }

    public void setRoute3(String route3) {
        this.route3 = route3;
    }

    public String getRoute3Grade() {
        return route3Grade;
    }

    public void setRoute3Grade(String route3Grade) {
        this.route3Grade = route3Grade;
    }

    public String getRoute4() {
        return route4;
    }

    public void setRoute4(String route4) {
        this.route4 = route4;
    }

    public String getRoute4Grade() {
        return route4Grade;
    }

    public void setRoute4Grade(String route4Grade) {
        this.route4Grade = route4Grade;
    }

    public String getRoute5() {
        return route5;
    }

    public void setRoute5(String route5) {
        this.route5 = route5;
    }

    public String getRoute5Grade() {
        return route5Grade;
    }

    public void setRoute5Grade(String route5Grade) {
        this.route5Grade = route5Grade;
    }

    public String getRoute6() {
        return route6;
    }

    public void setRoute6(String route6) {
        this.route6 = route6;
    }

    public String getRoute6Grade() {
        return route6Grade;
    }

    public void setRoute6Grade(String route6Grade) {
        this.route6Grade = route6Grade;
    }

    public String getpA1() {
        return pA1;
    }

    public void setpA1(String pA1) {
        this.pA1 = pA1;
    }

    public String getpB2() {
        return pB2;
    }

    public void setpB2(String pB2) {
        this.pB2 = pB2;
    }

    public String getpC3() {
        return pC3;
    }

    public void setpC3(String pC3) {
        this.pC3 = pC3;
    }

    public String getpD4() {
        return pD4;
    }

    public void setpD4(String pD4) {
        this.pD4 = pD4;
    }

    public String getpE5() {
        return pE5;
    }

    public void setpE5(String pE5) {
        this.pE5 = pE5;
    }

    public String getProA1() {
        return proA1;
    }

    public void setProA1(String proA1) {
        this.proA1 = proA1;
    }

    public String getProA2() {
        return proA2;
    }

    public void setProA2(String proA2) {
        this.proA2 = proA2;
    }

    public String getProA3() {
        return proA3;
    }

    public void setProA3(String proA3) {
        this.proA3 = proA3;
    }

    public String getProA4() {
        return proA4;
    }

    public void setProA4(String proA4) {
        this.proA4 = proA4;
    }

    public String getProA5() {
        return proA5;
    }

    public void setProA5(String proA5) {
        this.proA5 = proA5;
    }

    public String getAb1() {
        return ab1;
    }

    public void setAb1(String ab1) {
        this.ab1 = ab1;
    }

    public int getOpa() {
        return opa;
    }

    public void setOpa(int opa) {
        this.opa = opa;
    }

    public int getOpb() {
        return opb;
    }

    public void setOpb(int opb) {
        this.opb = opb;
    }

    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }

    public int getOpd() {
        return opd;
    }

    public void setOpd(int opd) {
        this.opd = opd;
    }

    public int getOpe() {
        return ope;
    }

    public void setOpe(int ope) {
        this.ope = ope;
    }

    public double getPricepa() {
        return pricepa;
    }

    public void setPricepa(double pricepa) {
        this.pricepa = pricepa;
    }

    public double getNtpar1() {
        return ntpar1;
    }

    public void setNtpar1(double ntpar1) {
        this.ntpar1 = ntpar1;
    }

    public double getPricepb() {
        return pricepb;
    }

    public void setPricepb(double pricepb) {
        this.pricepb = pricepb;
    }

    public double getPricepc() {
        return pricepc;
    }

    public void setPricepc(double pricepc) {
        this.pricepc = pricepc;
    }

    public double getPricepd() {
        return pricepd;
    }

    public void setPricepd(double pricepd) {
        this.pricepd = pricepd;
    }

    public double getPricepe() {
        return pricepe;
    }

    public void setPricepe(double pricepe) {
        this.pricepe = pricepe;
    }

    public double getNtpar2() {
        return ntpar2;
    }

    public void setNtpar2(double ntpar2) {
        this.ntpar2 = ntpar2;
    }

    public double getNtpar3() {
        return ntpar3;
    }

    public void setNtpar3(double ntpar3) {
        this.ntpar3 = ntpar3;
    }

    public double getNtpar4() {
        return ntpar4;
    }

    public void setNtpar4(double ntpar4) {
        this.ntpar4 = ntpar4;
    }

    public double getNtpar5() {
        return ntpar5;
    }

    public void setNtpar5(double ntpar5) {
        this.ntpar5 = ntpar5;
    }

    public double getNtpar6() {
        return ntpar6;
    }

    public void setNtpar6(double ntpar6) {
        this.ntpar6 = ntpar6;
    }

    public double getNtpbr1() {
        return ntpbr1;
    }

    public void setNtpbr1(double ntpbr1) {
        this.ntpbr1 = ntpbr1;
    }

    public double getNtpbr2() {
        return ntpbr2;
    }

    public void setNtpbr2(double ntpbr2) {
        this.ntpbr2 = ntpbr2;
    }

    public double getNtpbr3() {
        return ntpbr3;
    }

    public void setNtpbr3(double ntpbr3) {
        this.ntpbr3 = ntpbr3;
    }

    public double getNtpbr4() {
        return ntpbr4;
    }

    public void setNtpbr4(double ntpbr4) {
        this.ntpbr4 = ntpbr4;
    }

    public double getNtpbr5() {
        return ntpbr5;
    }

    public void setNtpbr5(double ntpbr5) {
        this.ntpbr5 = ntpbr5;
    }

    public double getNtpbr6() {
        return ntpbr6;
    }

    public void setNtpbr6(double ntpbr6) {
        this.ntpbr6 = ntpbr6;
    }

    public double getNtpcr1() {
        return ntpcr1;
    }

    public void setNtpcr1(double ntpcr1) {
        this.ntpcr1 = ntpcr1;
    }

    public double getNtpcr2() {
        return ntpcr2;
    }

    public void setNtpcr2(double ntpcr2) {
        this.ntpcr2 = ntpcr2;
    }

    public double getNtpcr3() {
        return ntpcr3;
    }

    public void setNtpcr3(double ntpcr3) {
        this.ntpcr3 = ntpcr3;
    }

    public double getNtpcr4() {
        return ntpcr4;
    }

    public void setNtpcr4(double ntpcr4) {
        this.ntpcr4 = ntpcr4;
    }

    public double getNtpcr5() {
        return ntpcr5;
    }

    public void setNtpcr5(double ntpcr5) {
        this.ntpcr5 = ntpcr5;
    }

    public double getNtpcr6() {
        return ntpcr6;
    }

    public void setNtpcr6(double ntpcr6) {
        this.ntpcr6 = ntpcr6;
    }

    public double getNtpdr1() {
        return ntpdr1;
    }

    public void setNtpdr1(double ntpdr1) {
        this.ntpdr1 = ntpdr1;
    }

    public double getNtpdr2() {
        return ntpdr2;
    }

    public void setNtpdr2(double ntpdr2) {
        this.ntpdr2 = ntpdr2;
    }

    public double getNtpdr3() {
        return ntpdr3;
    }

    public void setNtpdr3(double ntpdr3) {
        this.ntpdr3 = ntpdr3;
    }

    public double getNtpdr4() {
        return ntpdr4;
    }

    public void setNtpdr4(double ntpdr4) {
        this.ntpdr4 = ntpdr4;
    }

    public double getNtpdr5() {
        return ntpdr5;
    }

    public void setNtpdr5(double ntpdr5) {
        this.ntpdr5 = ntpdr5;
    }

    public double getNtpdr6() {
        return ntpdr6;
    }

    public void setNtpdr6(double ntpdr6) {
        this.ntpdr6 = ntpdr6;
    }

    public double getNtper1() {
        return ntper1;
    }

    public void setNtper1(double ntper1) {
        this.ntper1 = ntper1;
    }

    public double getNtper2() {
        return ntper2;
    }

    public void setNtper2(double ntper2) {
        this.ntper2 = ntper2;
    }

    public double getNtper3() {
        return ntper3;
    }

    public void setNtper3(double ntper3) {
        this.ntper3 = ntper3;
    }

    public double getNtper4() {
        return ntper4;
    }

    public void setNtper4(double ntper4) {
        this.ntper4 = ntper4;
    }

    public double getNtper5() {
        return ntper5;
    }

    public void setNtper5(double ntper5) {
        this.ntper5 = ntper5;
    }

    public double getNtper6() {
        return ntper6;
    }

    public void setNtper6(double ntper6) {
        this.ntper6 = ntper6;
    }

    public int getRepIdR1() {
        return repIdR1;
    }

    public void setRepIdR1(int repIdR1) {
        this.repIdR1 = repIdR1;
    }

    public int getRepIdR2() {
        return repIdR2;
    }

    public void setRepIdR2(int repIdR2) {
        this.repIdR2 = repIdR2;
    }

    public int getRepIdR3() {
        return repIdR3;
    }

    public void setRepIdR3(int repIdR3) {
        this.repIdR3 = repIdR3;
    }

    public int getRepIdR4() {
        return repIdR4;
    }

    public void setRepIdR4(int repIdR4) {
        this.repIdR4 = repIdR4;
    }

    public int getRepIdR5() {
        return repIdR5;
    }

    public void setRepIdR5(int repIdR5) {
        this.repIdR5 = repIdR5;
    }

    public int getRepIdR6() {
        return repIdR6;
    }

    public void setRepIdR6(int repIdR6) {
        this.repIdR6 = repIdR6;
    }

    public String getRepName1() {
        return repName1;
    }

    public void setRepName1(String repName1) {
        this.repName1 = repName1;
    }

    public String getRepName2() {
        return repName2;
    }

    public void setRepName2(String repName2) {
        this.repName2 = repName2;
    }

    public String getRepName3() {
        return repName3;
    }

    public void setRepName3(String repName3) {
        this.repName3 = repName3;
    }

    public String getRepName4() {
        return repName4;
    }

    public void setRepName4(String repName4) {
        this.repName4 = repName4;
    }

    public String getRepName5() {
        return repName5;
    }

    public void setRepName5(String repName5) {
        this.repName5 = repName5;
    }

    public String getRepName6() {
        return repName6;
    }

    public void setRepName6(String repName6) {
        this.repName6 = repName6;
    }

    public Date getDate() {
        return new Date();
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
