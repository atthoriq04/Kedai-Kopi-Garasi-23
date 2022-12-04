package Connection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import static java.lang.Class.forName;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Atthoriq
 */
public class koneksi {
    private Connection CC;
    config con = new config();
    connect kon = new connect();
    
    public Connection connectLogin(){
    
      String ip = con.GetProp(kon.lbl_ip.getText());
      String db = con.GetProp(kon.lbl_db.getText());
      String user = con.GetProp(kon.lbl_user.getText());
      String pass = con.GetProp(kon.lbl_pass.getText());
    try{
    CC = DriverManager.getConnection("jdbc:mysql://"+ip+"/"+db+"", ""+user+"", ""+pass+"");
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        kon.setVisible(true);
        
    }
        return CC;
    }
   
    
}