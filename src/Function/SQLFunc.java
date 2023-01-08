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
import java.util.HashMap;
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
    
    public ArrayList selectAll(Connection CC,String[] fieldsNeeded,String query){
        ArrayList<HashMap<String,String>> result = new ArrayList<>();
        try{
            Statement stat = CC.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while(rs.next()){
                HashMap<String,String> tables = new HashMap<>();
                for (String need : fieldsNeeded) {
                    tables.put(need, rs.getString(need));
                }
                result.add(tables);
            }
            return result;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public HashMap selectColumn(Connection CC, String Query, String[] dataWanted){
        HashMap<String,String> result = new HashMap();
        try{
            Statement stat = CC.createStatement();
            ResultSet rs = stat.executeQuery(Query);
            if(rs.next()){
                for(String data : dataWanted){
                    result.put(data, rs.getString(data));
                }
            return result;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public String selectData(Connection CC, String query, String dataWanted){
        String result = null;
        try{
            Statement stat = CC.createStatement();
            ResultSet rs = stat.executeQuery(query);
            if(rs.next()){
                result = rs.getString(dataWanted);
                return result;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    public ArrayList selectRowofColumn(Connection CC, String query,String dataWanted){
        ArrayList<String> result = new ArrayList();
        try{
            Statement stat = CC.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while(rs.next()){
               result.add(rs.getString(dataWanted));
            }
            return result;
        }catch(Exception E){
            E.printStackTrace();
        }
        return null;
    }
    
    public Boolean validate(Connection CC,String query){
        try{
            Statement stat = CC.createStatement();
            ResultSet rs = stat.executeQuery(query);
            if(rs.next()){
               return true;
            }
        }catch(Exception E){
            E.printStackTrace();
        }
        return false;
    }
}
