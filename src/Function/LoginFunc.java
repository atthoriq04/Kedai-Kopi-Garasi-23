/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;

import javax.swing.JPanel;
import Login.Login;
import Login.connect;
/**
 *
 * @author Atthoriq
 */
public class LoginFunc  {
    JPanel a = new JPanel();
    Login lgn = new Login();
    connect conn = new connect();
    public void Adding(JPanel from){
        from.add(lgn);
        from.add(conn);
    }
    public void Showing(String a){
        
    }
}
