package Function;

import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
    GUIFunc gui = new GUIFunc();
    
    public void Restok(Connection CC,ArrayList ids,ArrayList jumlah){
        for(int i = 0; i<ids.size();i++){
            String Query = "INSERT INTO `restok`(`idInventory`, `jumlah`)VALUES('"+ids.get(i)+"','"+jumlah.get(i)+"')";
            database.StartQuery(CC, Query);
        }
        JOptionPane.showMessageDialog(null, "Data Restok Ditambahkan");
    }
    
    public void showRestokData(Connection CC, JTable table){
        Object[] title = {
            "kodeRestok","Tanggal Restok","NamaBarang","jumlah","Satuan"
        } ;
        String[] dataNeeded ={
            "idRestok","Tanggal","namaBarang","restok.jumlah","satuan"
        };
        gui.showTabel(CC, title, dataNeeded, database.selectAll(CC, dataNeeded, "SELECT * FROM Restok INNER JOIN inventory ON restok.idInventory = inventory.idInventory INNER JOIN inventorycategory ON inventorycategory.idKategori = inventory.idKategori"), table);
    }
    
    public void PengeluaranBukanPenjualan(Connection CC,ArrayList ids,ArrayList jumlah,ArrayList keterangan){
        for(int i = 0; i<ids.size();i++){
            String Query = "INSERT INTO transaksi(idInventory,jumlah,idUser,Keterangan) VALUES ('"+ids.get(i)+"','"+jumlah.get(i)+"','1','"+keterangan.get(i)+"')";
            database.StartQuery(CC, Query);
        }
        JOptionPane.showMessageDialog(null, "Pengeluaran berhasil Di Data");
        
    }
    

}
