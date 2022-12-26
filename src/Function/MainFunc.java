/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Atthoriq
 */
public class MainFunc {
    public DefaultTableModel tmdl;
    SQLFunc database = new SQLFunc();
    GUIFunc gui = new GUIFunc();
    public void generateDashboard(Connection CC, JTable table){
        generateRestockHistory(CC,table);
    }
    public void generateRestockHistory(Connection CC,JTable table){
        Object[] titles = {
            "no","Tanggal Restok", "Nama Barang","Jumlah","Satuan"
        };
         String[] needed = {
        "idRestok","Tanggal","namaBarang","Jumlah","Satuan"
        };
        String Query = "SELECT * FROM Restok INNER JOIN inventory ON restok.idInventory = inventory.idInventory INNER JOIN inventorycategory ON inventorycategory.idKategori = inventory.idInventory ORDER BY Tanggal DESC LIMIT 10";
        gui.showTabel(CC, titles, needed, database.selectAll(CC, needed, Query), table);
    }
}
