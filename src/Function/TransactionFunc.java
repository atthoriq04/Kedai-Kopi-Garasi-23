package Function;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Atthoriq
 */
public class TransactionFunc {
    SQLFunc database = new SQLFunc();
    
    public void Restok(Connection CC,ArrayList ids,ArrayList jumlah){
        for(int i = 0; i<ids.size();i++){
            String Query = "INSERT INTO `restok`(`idInventory`, `jumlah`)VALUES('"+ids.get(i)+"','"+jumlah.get(i)+"')";
            database.StartQuery(CC, Query);
        }
        JOptionPane.showMessageDialog(null, "Data Restok Ditambahkan");
    }
}
