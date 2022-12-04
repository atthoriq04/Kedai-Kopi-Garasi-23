/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;

import Connection.koneksi;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Atthoriq
 */

public class UserFunc  {
    Connection CC = new koneksi().connectLogin() ;
    PreparedStatement pst;
    public Statement stt;
    GUIFunc gui = new GUIFunc();
    public void login(String Username, String Password, JFrame frame1, JFrame frame2, JLabel validUs, JLabel validPass){
       try {
            validUs.setVisible(false);
            validPass.setVisible(false);
            Statement stat = CC.createStatement();
            String sql = "SELECT * FROM user WHERE Username = '"+Username+"'";
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()){
                String user = rs.getString("username");
                String checkpw = "SELECT * FROM user WHERE Username = '"+user+"' AND password = SHA2('"+Password+"',224)";
                ResultSet rz = stat.executeQuery(checkpw);
                if(rz.next()){
                    int role = rz.getInt("role");
                    frame1.setVisible(true);
                    frame2.dispose();
                }else{
                    validPass.setVisible(true);
                    validPass.setText("Password Salah");
                }
            }else{
                validUs.setVisible(true);
                validUs.setText("Username Tidak Ditemukan ");
                
            }
       }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
       }   
   }
    
   public void securityQuestion(String Username, JPanel panel, JLabel q1,JLabel q2,JLabel q3){
        try {
            panel.setVisible(false);
            Statement stat = CC.createStatement();
            String sql = "SELECT * FROM user WHERE Username = '"+Username+"'";
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()){
                ArrayList<String> q = new ArrayList<>();
                int id = rs.getInt("id");
                panel.setVisible(true);
                String showSq = "SELECT * FROM usersq INNER JOIN securityquestion ON usersq.sqId = securityquestion.sqId WHERE usersq.UserId = "+ id +" LIMIT 3";
                ResultSet rz = stat.executeQuery(showSq);
                while(rz.next()){
                      q.add(rz.getString("sQuestion"));
                }
                q1.setText(q.get(0));
                q2.setText(q.get(1));
                q3.setText(q.get(2));
            }else{
                JOptionPane.showMessageDialog(null, "Username Anda Tidak Ditemukan!!");
            }
       }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
       }   
   }
   
   public void resetPassword(String a1, String a2, String a3, String username){
       try {
            ArrayList<Integer> sqId = new ArrayList<>();
            ArrayList<Integer> userId = new ArrayList<>();
            Statement stat = CC.createStatement();
            System.out.println(username);
            String sql = "SELECT * FROM usersq INNER JOIN user ON usersq.UserId = user.id INNER JOIN securityquestion ON usersq.sqId = securityquestion.sqId WHERE user.username = '"+username+"' ";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                userId.add(rs.getInt("userId"));
                sqId.add(rs.getInt("sqid"));
            }
            int score = 0;
            String check1 = "SELECT * FROM usersq INNER JOIN securityquestion ON usersq.sqId = securityquestion.sqId WHERE usersq.UserId  = "+ userId.get(0) +" AND usersq.sqId = "+ sqId.get(0) +" AND Answer = SHA2('"+ a1 +"',224)";
            ResultSet rt = stat.executeQuery(check1);
            if(rt.next()){
                score = score + 3;
            }
            String check2 = "SELECT * FROM usersq INNER JOIN securityquestion ON usersq.sqId = securityquestion.sqId WHERE usersq.UserId  = "+ userId.get(0) +" AND usersq.sqId = "+ sqId.get(1) +" AND Answer = '"+ a2 +"'";
            ResultSet ru = stat.executeQuery(check2);
            if(ru.next()){
                score = score + 1;
            }
            String check3 = "SELECT * FROM usersq INNER JOIN securityquestion ON usersq.sqId = securityquestion.sqId WHERE usersq.UserId  = "+ userId.get(0) +" AND usersq.sqId = "+ sqId.get(2) +" AND Answer = '"+ a3 +"'";
            ResultSet rv = stat.executeQuery(check3);
            if(rv.next()){
                score = score + 1;
            }
            if(score < 3){
                JOptionPane.showMessageDialog(null, "Anda Tidak Memenuhi Syarat Untuk mereset Password");
            }else{
                JOptionPane.showMessageDialog(null, "Anda Memenuhi Syarat Untuk mereset Password");
            }
       }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
       }
   }
   
   public void checkSQ(){
   
   }
   

}
    
    


