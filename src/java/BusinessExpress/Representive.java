/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessExpress;

/**
 *
 * @author FG
 */
public class Representive {
    String rep_id;
    String rep_name;
    String com_id;
    String sup_id;
    String manager_id;
    String area;
    String gradeName;
    String route_no;

    public Representive(String gradeName) {
        this.gradeName = gradeName;
    }

    public Representive(String rep_id, String rep_name, String com_id, String sup_id, String manager_id, String area, String gradeName, String route_no) {
        this.rep_id = rep_id;
        this.rep_name = rep_name;
        this.com_id = com_id;
        this.sup_id = sup_id;
        this.manager_id = manager_id;
        this.area = area;
        this.gradeName = gradeName;
        this.route_no = route_no;
    }

    public Representive() {
    }
    
    
}
