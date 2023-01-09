/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;
import Main.Main;
import Connection.koneksi;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Atthoriq
 */

public class UserFunc  {
    public DefaultTableModel tmdl;
    PreparedStatement pst;
    public Statement stt;
    SQLFunc database = new SQLFunc();
    GUIFunc gui = new GUIFunc();
    
    
    public void login(Connection CC,String Username, String Password,  JFrame frame2, JLabel validUs, JLabel validPass){
       try {
            validUs.setVisible(false);
            validPass.setVisible(false);
            Statement stat = CC.createStatement();
            String sql = "SELECT * FROM user WHERE Username = '"+Username+"' AND userActive = 1";
            ResultSet rs = stat.executeQuery(sql);
            if(rs.next()){
                String user = rs.getString("username");
                String checkpw = "SELECT * FROM user WHERE Username = '"+user+"' AND password = SHA2('"+Password+"',224)";
                ResultSet rz = stat.executeQuery(checkpw);
                if(rz.next()){
                    UserSession.setUserLogin(rz.getString("username"));
                    UserSession.setUserId(rz.getInt("id"));
                    UserSession.setDefaultKelas(rz.getString("idRole"));
                    Main a = new Main();
                    a.setVisible(true);
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
    
   public int securityQuestion(Connection CC,String Username, JPanel panel, JLabel q1,JLabel q2,JLabel q3){
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
                return id;
            }else{
                JOptionPane.showMessageDialog(null, "Username Anda Tidak Ditemukan!!");
                return 0;
            }
       }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
       }   
       return 0;
   }
   
   public void CheckAnswer(Connection CC,String a1, String a2, String a3, int id, JLabel us1, JPanel from, JPanel to){
       try {
            ArrayList<Integer> sqId = new ArrayList<>();
            ArrayList<Integer> userId = new ArrayList<>();
            ArrayList<String> userName = new ArrayList<>();
            Statement stat = CC.createStatement();
            String sql = "SELECT * FROM usersq INNER JOIN user ON usersq.UserId = user.id INNER JOIN securityquestion ON usersq.sqId = securityquestion.sqId WHERE user.id = '"+id+"' ";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                userId.add(rs.getInt("userId"));
                sqId.add(rs.getInt("sqid"));
                userName.add(rs.getString("username"));
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
                us1.setText(userName.get(0));
                gui.switchPanel(from, to);
            }
       }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
       }
   }
   
   public void ResetPassword(Connection CC,String Password, String PasswordRepeat, int id, JPanel from, JPanel to){
       try{
            Statement stat = CC.createStatement();
            if(Password.equals(PasswordRepeat)){
                stat.execute("UPDATE user SET password = SHA2('"+ Password +"',224) WHERE id ='"+ id + "' ");
                JOptionPane.showMessageDialog(null,"Password Berhasil Diubah, Silahkan Login Kembali");
                gui.switchPanel(from, to);
            }else{
                JOptionPane.showMessageDialog(null,"Tidak Cocok");
            }
       }catch(Exception e){
           e.printStackTrace();
       }
   }
   public void showUser(Connection CC,JTable table){
       
       Object[] title={
            "Id","Nama User","Username","Role"
        };
       String[] needed = {
            "id","Nama","Username","Role"
        };
        String Query = "SELECT * FROM user INNER JOIN role ON user.idRole = role.idRole WHERE userActive = 1";
        ArrayList<HashMap<String,String>> Datas = database.selectAll(CC, needed, Query);
        gui.showTabel(CC, title, needed, Datas, table);
        
            
   }
   
   public void addUser(Connection CC, JTextField nama,JCheckBox AdminChecker, JTable userTable){
       String trimmed = nama.getText().replaceAll("\\s+","");
       if(database.selectData(CC, "SELECT * FROM user WHERE id = 1", "Nama") != null){
           JOptionPane.showMessageDialog(null, "User Sudah Ada");
       }
       int role = (AdminChecker.isSelected()) ? 1 : 2;
       database.StartQuery(CC, "INSERT INTO user(`Nama`, `username`, `password`, `idRole`, `userActive`) VALUES ('"+ nama.getText() +"','"+ trimmed +"',SHA2('"+ trimmed +"',224),'"+ role +"','1')");
       JOptionPane.showMessageDialog(null,"Data User Berhasil Ditambahkan");
       nama.setText("");
       AdminChecker.setSelected(false);
       showUser(CC,userTable);
   }
   
   public String dataClicked(JTable table,JTextField form,JCheckBox radio,JButton Action, JButton Delete){
        int i = table.getSelectedRow();
       TableModel model = table.getModel();
       String nama = model.getValueAt(i, 1).toString();
       String role = model.getValueAt(i, 3).toString();
       boolean isAdmin = (role.equalsIgnoreCase("admin"));
       form.setText(nama);
       Action.setText("Edit");
       radio.setSelected(isAdmin);
       Delete.setVisible(true);
       return model.getValueAt(i, 0).toString();
       
   }
   
   public void EditUsers(Connection CC,JTable table,JTextField form,JCheckBox AdminChecker,JButton Action, JButton Delete, String id){
      int role = (AdminChecker.isSelected()) ? 1 : 2;
      String query = "UPDATE user SET Nama = '"+form.getText()+"', idRole = '"+role+"' WHERE id = "+id;
      database.StartQuery(CC, query);
      JOptionPane.showMessageDialog(null,"Data User Berhasil Diedit");   
      showUser(CC,table);
      form.setText("");
      Delete.setVisible(false);
      Action.setText("Simpan");
      AdminChecker.setSelected(false);
   }
   
   public void DeleteUser(String id, Connection CC, JTable table,JTextField form,JButton Action, JButton Delete ){
       database.StartQuery(CC, "UPDATE user SET userActive = 2 WHERE id = "+id);
       JOptionPane.showMessageDialog(null,"Data User Berhasil Di Hapus"); 
       showUser(CC,table);
       Delete.setVisible(false);
       Action.setText("Simpan");
       form.setText("");
   }
   
   public void showSQ(Connection CC, JTable SQTable){
        Object[] title={
            "Id","Pertanyaan Keamanan"
        };
       String[] needed = {
            "sqId","sQuestion"
        };
        String Query = "SELECT * FROM `securityquestion` WHERE sqId > 1";
        gui.showTabel(CC, title, needed, database.selectAll(CC, needed, Query), SQTable);
   }
   
   public void addSQ(Connection CC,JTable SQTable, JTextField pertanyaan ){
       database.StartQuery(CC, "INSERT INTO `securityquestion`(`sQuestion`) VALUES ('"+ pertanyaan.getText() +"')");
       JOptionPane.showMessageDialog(null,"Pertanyaan Keamanan Ditambahkan"); 
       pertanyaan.setText("");
       showSQ(CC,SQTable);
   }
   
   public String sqClicked(Connection CC,JTable SQTable, JTextField pertanyaan,JButton Action){
       int i = SQTable.getSelectedRow();
       TableModel model = SQTable.getModel();
       String question = model.getValueAt(i, 1).toString();
       pertanyaan.setText(question);
       Action.setText("Edit");
       return model.getValueAt(i, 0).toString();
   }
   
   public void editSQ(Connection CC,JTable SQTable, JTextField pertanyaan,JButton Action,String sqId){
       String query = "UPDATE securityQuestion SET sQuestion = '"+ pertanyaan.getText() +"' WHERE sqId = '"+ sqId +"'";
        if(database.selectData(CC, "SELECT * FROM usersq WHERE sqId = '"+ sqId +"'", "UserId") != null){
            int opsi = JOptionPane.showConfirmDialog(null, "Pertanyaan Ini Sedang Digunakan User, Tetap ubah pertanyaan?", "Penghapusan Data", JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION){
                database.StartQuery(CC, query);
            }else{
                pertanyaan.setText("");
                Action.setText("Simpan");
                return;
            }
        }
        database.StartQuery(CC, query);
        JOptionPane.showMessageDialog(null, "Pertanyan keamanan berhasil Di Edit!");
        pertanyaan.setText("");
        Action.setText("Simpan");
        showSQ(CC,SQTable);
   }
   public void showProfile(Connection CC, int loginId,JTextField username,JTextField nama,JLabel role ){
       String[] dataWanted = {"Nama","username","role.role"};
       HashMap<String,String> data = database.selectColumn(CC, "SELECT * FROM `user` INNER JOIN role ON role.idrole = user.idRole WHERE id = "+ loginId +" ", dataWanted);
       username.setText(data.get("username"));
       nama.setText(data.get("Nama"));
       role.setText(data.get("role.role"));
   }
   public void showLoginSQData(Connection CC, int loginId,JComboBox sq1,JComboBox sq2,JTextField ans1,JTextField ans2){
       String[] dataWanted = {"sQuestion","Answer"};
       ArrayList<HashMap<String,String>> datas = database.selectAll(CC, dataWanted, "SELECT * FROM usersq INNER JOIN user ON usersq.UserId = user.id INNER JOIN securityquestion ON usersq.sqId = securityquestion.sqId WHERE user.id = '"+ loginId +"' ORDER BY usersq.Id ASC");
       sq1.setSelectedItem(datas.get(1).get("sQuestion"));
       sq2.setSelectedItem(datas.get(2).get("sQuestion"));
       ans1.setText(datas.get(1).get("Answer"));
       ans2.setText(datas.get(2).get("Answer"));
   }
   
   public void updateUserPassword(Connection CC, int id, String pw){
       database.StartQuery(CC, "UPDATE user SET password = SHA2('"+ pw +"',224) WHERE id ='"+ id + "' ");
       JOptionPane.showMessageDialog(null, "Password Berhasil Diubah");
   }
   
   public void updateSCode(Connection CC, int id, String sCode){
       database.StartQuery(CC, "UPDATE userSQ SET Answer = SHA2('"+ sCode +"',224) WHERE UserId ='"+ id + "' AND sqId = 1 ");
   }
   
   public void updateUserProfile(Connection CC,int id, String username,String name){
       database.StartQuery(CC, "UPDATE user SET username = '"+ username +"',Nama= '"+ name +"' WHERE id ='"+ id + "' ");
   }
   
   public void setUserSQ(Connection CC,JComboBox sq1,JComboBox sq2,JTextField ans1,JTextField ans2,String kode,int id,Boolean isNew){
       if(isNew){
          int[] questions = { 1 ,sq1.getSelectedIndex()+1,sq2.getSelectedIndex()+1};
          String[] answer = {kode,ans1.getText(),ans2.getText()};
          for(int i = 0 ; i<questions.length;i++){
              if(i == 0){
                database.StartQuery(CC, "INSERT INTO `usersq`( `UserId`, `sqId`, `Answer`) VALUES ('"+id+"','"+questions[i]+"',SHA2('"+answer[i]+"',224))");
              }else{
                database.StartQuery(CC, "INSERT INTO `usersq`( `UserId`, `sqId`, `Answer`) VALUES ('"+id+"','"+questions[i]+"','"+answer[i]+"')");
              }
          }
       }else{
          String[] needed ={ "id", "sqId" }; 
          int[] questions = {sq1.getSelectedIndex()+2,sq2.getSelectedIndex()+2};
          String[] answer = {ans1.getText(),ans2.getText()};
          ArrayList<HashMap<String,String>> data = database.selectAll(CC, needed, "SELECT * FROM usersq WHere`UserId` ='"+id+"'");
          for(int i = 0 ; i<questions.length;i++){
            database.StartQuery(CC, "UPDATE `usersq` SET `sqId`= '"+questions[i]+"',`Answer`= '"+answer[i]+"' WHERE `id` ='"+data.get(i+1).get("id")+"'");
          }
       }
   }
}
    
    


