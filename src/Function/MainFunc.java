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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
    public Boolean init(Connection CC, int loginId, String loginName,JComboBox sq1,JComboBox sq2,JLabel nama,JLabel error,customButton button){
        if(database.validate(CC, "SELECT * FROM usersq WHERE usersq.UserId = "+loginId)){
             return true;
        }
        generateWelcome(CC,loginId,loginName,sq1,sq2,nama,error,button);
        return false;
    }
    public void generateWelcome(Connection CC, int loginId, String loginName,JComboBox sq1,JComboBox sq2,JLabel nama,JLabel error,customButton button){
        nama.setText(loginName);
        error.setVisible(false);
        gui.showComboBox(database.selectRowofColumn(CC, "SELECT * FROM securityquestion WHERE sqId > 1", "sQuestion"), sq1);
        gui.showComboBox(database.selectRowofColumn(CC, "SELECT * FROM securityquestion WHERE sqId > 1", "sQuestion"), sq2);
        gui.buttonchange(button, new Color(48,48,48), new Color(87,124,255), new Color(87,124,255), 10);
    }
    public void generateDashboard(Connection CC, JTable table,JTable reco,JLabel nominalPesanan,JLabel favMenu,JLabel nominalUang,JLabel tanggal){
        generateRestockHistory(CC,table);
        stock.showRestockRecommend(CC, reco);
        nominalPesanan.setText(database.selectData(CC, "SELECT COUNT(idPenjualan) FROM penjualan WHERE tanggal >= CURDATE()", "COUNT(idPenjualan)"));
        favMenu.setText(transaction.frequentMenu(CC));
        nominalUang.setText(Integer.toString(transaction.calculateProfit(CC)));
        tanggal.setText(java.time.LocalDate.now().toString());
    }
    public void generateRestock(Connection CC,customButton button,customButton input ,JComboBox combo,JComboBox supCombo){
        gui.buttonchange(button, new Color(48,48,48), new Color(87,124,255), new Color(87,124,255), 10);
        gui.buttonchange(input, new Color(48,48,48), new Color(87,124,255), new Color(87,124,255), 10);
        combo.removeAllItems();
        combo.addItem("Pilih Barang yang akan di restok");
        supCombo.removeAllItems();
        supCombo.addItem("Pilih Supplier");
        stock.showStockCombo(CC, combo);
        gui.showComboBox(database.selectRowofColumn(CC, "Select * FROM supplier", "namaSuplier"), supCombo);
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
    public void generateCatSettings(Connection CC,JPanel panelPengaturan,JPanel kategoriCommand, JPanel formMenu,JLabel judul,JTable catSettingsTable,customButton cMenuAction){
        gui.buttonchange(cMenuAction, new Color(42,52,62), new Color(87,124,255), new Color(87,124,255), 10);
        panelPengaturan.setVisible(true);
        gui.showPanel(kategoriCommand, formMenu);
        judul.setText("Menu");
        menu.showKategoriMenu(CC, catSettingsTable);
     
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
    public void generateTransHistory(Connection CC,JCheckBox sellToogle,JLabel transacLabel,JTable transHistoryTable){
        if(sellToogle.isSelected() == true){
            transacLabel.setText("Data Penjualan");
            transaction.showPenjualanData(CC, transHistoryTable);
            return;
        }
        transacLabel.setText("Data Pengeluaran Bahan Baku");
        transaction.showPengeluaranData(CC, transHistoryTable);
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
    
    public void upProfilePage(Connection CC, int loginId,JComboBox sq1,JComboBox sq2,JTextField ans1, JTextField ans2,JTextField username,JTextField name,JLabel role){
        if(checkSQ(sq1,sq2)){
            user.updateUserProfile(CC, loginId, username.getText(), name.getText());
            user.setUserSQ(CC, sq1, sq2, ans1, ans2, null, loginId, false);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            user.showProfile(CC, loginId, username, name, role);
            user.showLoginSQData(CC, loginId, sq1, sq2, ans1, ans2);
        }else{
            JOptionPane.showMessageDialog(null, "Harap Memilih pertanyaan yang berbeda");
        }
    }
    
    
    
    public void checkPassowrd(Connection CC,int loginId){
        JPasswordField pass = new JPasswordField(10);
        String[] options = new String[]{"Batal", "OK"};
        int option = JOptionPane.showOptionDialog(null, pass, "Masukan Password Anda", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
        if(option == 1) // pressing OK button
        {
            if(database.validate(CC, "SELECT * FROM user WHERE id = '"+loginId+"' AND password = SHA2('"+pass.getText()+"',224)")){
                JPasswordField pass1 = new JPasswordField(10);
                int pw1 = JOptionPane.showOptionDialog(null, pass1, "Masukan Password Baru Anda", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                if(pw1 == 1){
                    JPasswordField pass2 = new JPasswordField(10);
                    int pw2 = JOptionPane.showOptionDialog(null, pass2, "Masukan Kembali Password Baru Anda", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                    if(pw2 == 1){
                        if(pass1.getText().equals(pass2.getText())){
                            user.updateUserPassword(CC, loginId, pass2.getText());
                            System.out.print(pass2.getText());
                        }else{
                            JOptionPane.showMessageDialog(null, "Password Tidak Sama!");
                        }
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Password Anda Salah");
            }
        }
    }
    
    public void checkSCode(Connection CC,int loginId){
        JPasswordField pass = new JPasswordField(10);
        String[] options = new String[]{"Batal", "OK"};
        int option = JOptionPane.showOptionDialog(null, pass, "Masukan 5 Kode Keamanan Anda", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
        if(option == 1) // pressing OK buttonSELECT * FROM user WHERE id = '"+loginId+"' AND password = SHA2('"+pass.getText()+"',224)
        {
            if(database.validate(CC, "SELECT * FROM usersq WHERE userId = '"+loginId+"' AND sqid = 1 AND Answer = SHA2('"+pass.getText()+"',224)")){
                JPasswordField pass1 = new JPasswordField(10);
                int pw1 = JOptionPane.showOptionDialog(null, pass1, "Masukan Kode Keamanan Baru", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                if(pw1 == 1){
                    JPasswordField pass2 = new JPasswordField(10);
                    int pw2 = JOptionPane.showOptionDialog(null, pass2, "Masukan Kembali Kode Keamanan baru", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                    if(pw2 == 1){
                        if(pass1.getText().equals(pass2.getText())){
                            user.updateSCode(CC, loginId, pass2.getText());
                            JOptionPane.showMessageDialog(null, "Kode Keamanan dirubah");
                        }else{
                            JOptionPane.showMessageDialog(null, "Kode Keamanan Tidak Sama");
                        }
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Kode Keamanan Anda Salah");
            }
        }
    }
    
    public Boolean checkInit(Connection CC, int loginId,JComboBox sq1,JComboBox sq2,JPasswordField pw1 , JPasswordField pw2,JPasswordField kode , JTextField ans1, JTextField ans2,JLabel error){
        if(pw1.getText().equals(pw2.getText())){
            if(checkSQ(sq1,sq2)){
                user.updateUserPassword(CC, loginId, pw1.getText());
                user.setUserSQ(CC, sq1, sq2, ans1, ans2, kode.getText(), loginId, true);
                return true;
            }
            JOptionPane.showMessageDialog(null, "Harap Memilih pertanyaan yang berbeda");
            return false;
        }
        error.setText("Kedua Password tidak Sama!");
        return false;
    }
    
    public Boolean checkSQ(JComboBox sq1,JComboBox sq2){
        return sq1.getSelectedIndex() != sq2.getSelectedIndex();
    }
    
    public void checking(Connection CC, JTable table,JTextField jumlahTerjual,String id,int UserId){
        TableModel model = table.getModel();
        int row = model.getRowCount();
        ArrayList<HashMap<String,String>> datas = new ArrayList();
        String idMenu = id;
        String harga = database.selectData(CC, "SELECT * FROM menu WHERE idMenu = '"+ id +"'", "harga");
        int pendapatan = Integer.parseInt(jumlahTerjual.getText()) * Integer.parseInt(harga);
        for(int x = 0 ; x<row;x++){
            HashMap<String,String> rowData = new HashMap();
            rowData.put("id", model.getValueAt(x, 1).toString());
            rowData.put("jumlah",Integer.toString(Integer.parseInt(model.getValueAt(x, 3).toString()) * Integer.parseInt(jumlahTerjual.getText())));
            rowData.put("alasan","Produksi");
            if(Integer.parseInt(model.getValueAt(x, 4).toString())- (Integer.parseInt(model.getValueAt(x, 3).toString()) * Integer.parseInt(jumlahTerjual.getText()))< 1){
                JOptionPane.showMessageDialog(null, "Bahan baku tidak mencukupi");
                return;
            }
            datas.add(rowData);
        }
        stock.decreaseStock(CC, datas);
        transaction.Pengeluaran(CC, datas, UserId);
        transaction.Penjualan(CC, idMenu, pendapatan, jumlahTerjual.getText(), UserId);
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
