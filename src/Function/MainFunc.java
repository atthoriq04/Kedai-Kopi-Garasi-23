/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;

import customGUI.customButton;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    StockFunc stock = new StockFunc();
    MenuFunc menu = new MenuFunc();
    SupplierFunc supplier = new SupplierFunc();
    public int selected(JPanel[] panels, JPanel panel , JLabel[] labels, JLabel label,int active){
       gui.reset(panels, labels);
       gui.hoverIn(panel, label);
       return active;
    }
    public void generateDashboard(Connection CC, JTable table){
        generateRestockHistory(CC,table);
    }
    public void generateRestock(Connection CC,customButton button,customButton input ,JComboBox combo){
        gui.buttonchange(button, new Color(48,48,48), new Color(87,124,255), new Color(87,124,255), 10);
        gui.buttonchange(input, new Color(48,48,48), new Color(87,124,255), new Color(87,124,255), 10);
        stock.showStockCombo(CC, combo);
    }
    public void generateMenu(Connection CC, JTable menuTable,JComboBox menuCategoryCombo, customButton save){
        menu.showMenu(CC, menuTable);
        menu.ShowCategoryCombo(CC, menuCategoryCombo);
        gui.buttonchange(save, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
    }
    public void generateStock(Connection CC,JTable stockTable,JComboBox stockCategory,customButton save){
        stock.ShowStock(CC, stockTable);
        stock.showInventoryCategoryCombo(CC, stockCategory);
        gui.buttonchange(save, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
    }
    public void generateSuppilerData(Connection CC, JTable supplierTable,customButton actionButton){
        supplier.showSupplier(CC, supplierTable);
        gui.buttonchange(actionButton, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
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
