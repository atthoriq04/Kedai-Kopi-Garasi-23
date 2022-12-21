/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Atthoriq
 */
public class SQLFunc {
    PreparedStatement pst;
    public Statement stt;
    
    public void StartQuery(Connection CC, String query){
        try{
            Statement stat = CC.createStatement();
            stat.execute(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList selectAll(){
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        
        
        return result;
    }
    
    public String selectOneColumn(){
        String result = null;
        
        return result;
    }
    
    public String[] selectRowofColumn(){
        String[] result = {
            "A","b","c"
        };
        return result;
    }
}
