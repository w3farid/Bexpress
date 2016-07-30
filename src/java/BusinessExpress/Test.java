/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessExpress;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author FG
 */
@ManagedBean
@SessionScoped
public class Test {
    private int a;
    private int b;
    private double c;
    public Test() {
    }
    public void m1(){
        switch("a"){
            case "a":System.out.println("abc");
        }
    }
    public static void main(String[] args) {
        Test t=new Test();
        t.m1();
    }

  
}
