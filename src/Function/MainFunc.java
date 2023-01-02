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
public class MainFunc {
    public DefaultTableModel tmdl;
    SQLFunc database = new SQLFunc();
    GUIFunc gui = new GUIFunc();
    StockFunc stock = new StockFunc();
    MenuFunc menu = new MenuFunc();
    UserFunc user = new UserFunc();
    TransactionFunc  transaction = new TransactionFunc();
    SupplierFunc supplier = new SupplierFunc();
    public int selected(JPanel[] panels, JPanel panel , JLabel[] labels, JLabel label,int active){
       gui.reset(panels, labels);
       gui.hoverIn(panel, label);
       return active;
    }
    public Boolean init(Connection CC, int loginId, String loginName,JTable table,JComboBox sq1,JComboBox sq2,JLabel nama,JLabel error){
        if(database.validate(CC, "SELECT * FROM usersq WHERE usersq.UserId = "+loginId)){
             generateDashboard(CC,table);
             return true;
        }
        generateWelcome(CC,loginId,loginName,sq1,sq2,nama,error);
        return false;
    }
    public void generateWelcome(Connection CC, int loginId, String loginName,JComboBox sq1,JComboBox sq2,JLabel nama,JLabel error){
        nama.setText(loginName);
        error.setVisible(false);
        gui.showComboBox(database.selectRowofColumn(CC, "SELECT * FROM securityquestion WHERE sqId > 1", "sQuestion"), sq1);
        gui.showComboBox(database.selectRowofColumn(CC, "SELECT * FROM securityquestion WHERE sqId > 1", "sQuestion"), sq2);
    }
    public void generateDashboard(Connection CC, JTable table){
        generateRestockHistory(CC,table);
    }
    public void generateRestock(Connection CC,customButton button,customButton input ,JComboBox combo){
        gui.buttonchange(button, new Color(48,48,48), new Color(87,124,255), new Color(87,124,255), 10);
        gui.buttonchange(input, new Color(48,48,48), new Color(87,124,255), new Color(87,124,255), 10);
        combo.removeAllItems();
        combo.addItem("Pilih Barang yang akan di restok");
        stock.showStockCombo(CC, combo);
    }
    public void generateMenu(Connection CC, JTable menuTable,JComboBox menuCategoryCombo, customButton save){
        menu.showMenu(CC, menuTable);
        menuCategoryCombo.removeAllItems();
        menuCategoryCombo.addItem("Pilih Kategori");
        menu.ShowCategoryCombo(CC, menuCategoryCombo);
        gui.buttonchange(save, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
    }
    public void generateStock(Connection CC,JTable stockTable,JComboBox stockCategory,customButton save){
        stock.ShowStock(CC, stockTable);
        stock.showInventoryCategoryCombo(CC, stockCategory);
        stockCategory.removeAllItems();
        stockCategory.addItem("Pilih Satuan");
        gui.buttonchange(save, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
    }
    public void generateSuppilerData(Connection CC, JTable supplierTable,customButton actionButton){
        supplier.showSupplier(CC, supplierTable);
        gui.buttonchange(actionButton, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
    }
    public void generateRestockData(Connection CC, JTable table){
        transaction.showRestokData(CC, table);
    }
    public void generateUser(Connection CC, JTable userTable,customButton action, customButton delete){
        user.showUser(CC, userTable);
        gui.buttonchange(action, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
        gui.buttonchange(delete, new Color(42,52,62), new Color(255,0,0), new Color(255,0,0), 10);
        delete.setVisible(false);
    }
    public void generateSQ(Connection CC, JTable SQTable,customButton action){
        user.showSQ(CC, SQTable);
        gui.buttonchange(action, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
    }
    public void generateCatSettings(Connection CC,JComboBox settings,JPanel panelPengaturan,JPanel kategoriCommand,JPanel formStock, JPanel formMenu,JLabel judul,JTable catSettingsTable,customButton cMenuAction,customButton cStockAction){
        panelPengaturan.setVisible(false);
        gui.buttonchange(cMenuAction, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
        gui.buttonchange(cStockAction, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
        if(settings.getSelectedIndex() > 1){
            panelPengaturan.setVisible(true);
            gui.showPanel(kategoriCommand, formStock);
            judul.setText("Bahan Baku");
            stock.showCategoryStock(CC, catSettingsTable);
        }else if(settings.getSelectedIndex() == 1){
            panelPengaturan.setVisible(true);
            gui.showPanel(kategoriCommand, formMenu);
            judul.setText("Menu");
            menu.showKategoriMenu(CC, catSettingsTable);
        }
    }
    public void generateRecipe(Connection CC,JTable resepTabel,JLabel namamenu,JComboBox showStock,customButton Action,String menuID){
        menu.showRecipe(CC, resepTabel, namamenu, menuID);
        showStock.removeAllItems();
        showStock.addItem("Pilih Bahan baku");
        stock.showStockCombo(CC, showStock);
        gui.buttonchange(Action, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
    }
    public void generateBukanPenjualan(Connection CC,JComboBox Stock,customButton Tampil, customButton simpan){
        gui.buttonchange(Tampil, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
        gui.buttonchange(simpan, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
        Stock.removeAllItems();
        Stock.addItem("Pilih Stok");
        stock.showStockCombo(CC, Stock);
    }
    public void generatePenjualan(Connection CC,JPanel bahanPanel,JComboBox kategori,JComboBox menuCombo,customButton simpan){
        kategori.removeAllItems();
        menu.ShowCategoryCombo(CC, kategori);
        menuCombo.removeAllItems();
        menuCombo.addItem("Pilih Menu");
        gui.buttonchange(simpan, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
        bahanPanel.setVisible(false);
    }
    public void generateProfile(Connection CC,int loginId,JTextField username,JTextField nama,JLabel role,JComboBox sq1,JComboBox sq2,JTextField ans1,JTextField ans2,customButton simpan){
        gui.buttonchange(simpan, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
        user.showProfile(CC, loginId, username, nama, role);
        sq1.removeAllItems();
        sq2.removeAllItems();
        gui.showComboBox(database.selectRowofColumn(CC, "SELECT * FROM securityquestion WHERE sqId > 1", "sQuestion"), sq1);
        gui.showComboBox(database.selectRowofColumn(CC, "SELECT * FROM securityquestion WHERE sqId > 1", "sQuestion"), sq2);
        user.showLoginSQData(CC, loginId, sq1, sq2, ans1, ans2);
    }
    
    public void checking(Connection CC, JTable table,JTextField jumlahTerjual,String id,int UserId){
        TableModel model = table.getModel();
        int row = model.getRowCount();
        ArrayList<Integer> idInventory = new ArrayList<>();
        ArrayList<Integer> jumlah = new ArrayList<>();
        ArrayList<String> ket = new ArrayList();
        String idMenu = id;
        String harga = database.selectData(CC, "SELECT * FROM menu WHERE idMenu = '"+ id +"'", "harga");
        int pendapatan = Integer.parseInt(jumlahTerjual.getText()) * Integer.parseInt(harga);
        
        for(int x = 0 ; x<row;x++){
            idInventory.add(Integer.parseInt(model.getValueAt(x, 1).toString()));
            jumlah.add(Integer.parseInt(model.getValueAt(x, 3).toString()) * Integer.parseInt(jumlahTerjual.getText()));
            ket.add("Produksi");
            if(Integer.parseInt(model.getValueAt(x, 4).toString())- (Integer.parseInt(model.getValueAt(x, 3).toString()) * Integer.parseInt(jumlahTerjual.getText()))< 1){
                JOptionPane.showMessageDialog(null, "Bahan baku tidak mencukupi");
                break;
            }
        }
        transaction.PengeluaranBukanPenjualan(CC, idInventory, jumlah, ket);
        
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
