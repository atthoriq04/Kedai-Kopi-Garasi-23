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
/**
 *
 * @author thori
 */
public class MenuFunc {
    PreparedStatement pst;
    public Statement stt;
    public DefaultTableModel tmdl;
    GUIFunc gui = new GUIFunc();
    SQLFunc database = new SQLFunc();
    public void showMenu(Connection CC, JTable menuTable){
        Object[] titles={
            "Id","Kategori","Menu","Harga"
        };
        String[] needed = {
            "idMenu","KategoriMenu","Menu","Harga"
        };
        String Query = "SELECT * FROM menu INNER JOIN menucategory ON menu.idKategori = menucategory.idKategori WHERE Active= 1 ORDER BY menu.idKategori ASC";
        ArrayList<HashMap<String,String>> Datas = database.selectAll(CC, needed, Query);
        gui.showTabel(CC, titles, needed, Datas, menuTable);
    }
    
    public void ShowCategoryCombo(Connection CC,JComboBox combo){
        String Query = "SELECT * FROM menucategory";
        ArrayList<String> Datas =  database.selectRowofColumn(CC, Query, "KategoriMenu");
        gui.showComboBox(Datas, combo);
    }
    
    public void addMenu(Connection CC,JTextField NamaMenu, JTextField harga, JComboBox combo,JTable menuTable){
        String Query = "INSERT INTO menu(`idKategori`, `Menu`, `Harga`) VALUES ('"+ combo.getSelectedIndex() +"','"+ NamaMenu.getText() +"','"+ harga.getText() +"')";
        database.StartQuery(CC, Query);
        NamaMenu.setText("");
        harga.setText("");
        combo.setSelectedIndex(0);
        showMenu(CC,menuTable);
        JOptionPane.showMessageDialog(null, "Data Menu Berhasil Di Input");
    }
    
    public String DataClicked(JTable tabel,JTextField FormNama, JTextField Patokan,JComboBox combo,JButton processButton, int option){
       int i = tabel.getSelectedRow();
       TableModel model = tabel.getModel();
       String nama = model.getValueAt(i, 2).toString();
       String Harga = model.getValueAt(i, 3).toString().replaceAll("[^0-9]", "");
       String Selected = model.getValueAt(i, 1).toString();
       
       if(option == 0){
           return model.getValueAt(i, 0).toString();
       }
           editInput(FormNama,Patokan,combo,processButton,nama,Harga,Selected);
           return model.getValueAt(i, 0).toString();
    }
    
    public void editInput(JTextField FormNama, JTextField Patokan,JComboBox combo,JButton processButton,String nama,String Harga, String Selected){
       FormNama.setText(nama);
       Patokan.setText(Harga);
       combo.setSelectedItem(Selected);
       processButton.setText("Edit");
    }
    
    public void editMenu(Connection CC,JTextField NamaMenu, JTextField harga, JComboBox combo,JTable menuTable,JButton processButton,String id){
        String Query = "UPDATE menu SET idKategori = '"+ combo.getSelectedIndex() +"', Menu = '"+ NamaMenu.getText() +"',Harga = '"+ harga.getText()+"' WHERE idMenu ="+id+" ";
        database.StartQuery(CC, Query);
        NamaMenu.setText("");
        harga.setText("");
        combo.setSelectedIndex(0);
        processButton.setText("Simpan");
        showMenu(CC,menuTable);
        JOptionPane.showMessageDialog(null, "Data Menu Berhasil Di Edit");
    }
    
    public void showKategoriMenu(Connection CC, JTable kategoriMenuTable){
        Object[] titles={
            "Id","Kategori Menu"
        };
        String[] Needed = {
            "idKategori","KategoriMenu"
        };
        String Query = "SELECT * FROM menucategory";
        ArrayList<HashMap<String,String>> Datas = database.selectAll(CC, Needed, Query);
        gui.showTabel(CC, titles, Needed, Datas, kategoriMenuTable);
    }
     public void addCategory(Connection CC, JTextField kategori,JTable kategoriStokTable){
        database.StartQuery(CC, "INSERT INTO `menucategory`(`KategoriMenu`) VALUES ('"+kategori.getText()+"')");
        kategori.setText("");
        JOptionPane.showMessageDialog(null, "Kategori Baru berhasil ditambahkan");
        showKategoriMenu(CC,kategoriStokTable);
    }
    
    public String categoryClicked(JTable kategoriStokTable,JTextField kategori,JButton Action){
        int i = kategoriStokTable.getSelectedRow();
       TableModel model = kategoriStokTable.getModel();
       String nama = model.getValueAt(i, 1).toString();
       kategori.setText(nama);
       Action.setText("Edit");
       
       return model.getValueAt(i, 0).toString();
        
    }
    
    public void EditCategory(Connection CC, JTextField kategori,JTable kategoriStokTable,JButton Action, String id){
        database.StartQuery(CC,"UPDATE menucategory SET kategoriMenu = '"+ kategori.getText() +"' WHERE idKategori = '"+id+"'");
        kategori.setText("");
        Action.setText("Simpan");
        JOptionPane.showMessageDialog(null, "Kategori Berhasil Di Edit");
        showKategoriMenu(CC,kategoriStokTable);
    }
    public String searchId(Connection CC,String Menu){
        return database.selectData(CC, "SELECT * FROM menu Where Menu = '"+Menu+"'", "idMenu");
        
    }
    public void showRecipe(Connection CC, JTable table, JLabel menuLabel, String menuId){
         Object[] titles={
            "Id","kode Barang","Bahan Baku","Jumlah Dibutuhkan","jumlah Terseida","Satuan"
        };
        String[] needed = {
            "id","idInventory","namaBarang","dibutuhkan","jumlah","Satuan"
        };
        String Query = "SELECT * FROM resep INNER JOIN menu ON resep.idMenu = menu.idMenu INNER JOIN inventory ON resep.idInventory = inventory.idInventory WHERE resep.idMenu = '"+ menuId +"'";
        gui.showTabel(CC, titles, needed, database.selectAll(CC, needed, Query), table);
        String query2 = "Select * FROM menu WHERE idMenu = '"+ menuId+"' LIMIT 1";
        gui.changeLabel(menuLabel, database.selectData(CC, query2, "Menu"));
    }
    
    public void addRecipe(Connection CC, JTable table, JTextField jumlahDigunakan ,JComboBox stockCombo,JLabel menuLabel, String menuId){
        String idInven = database.selectData(CC, "SELECT * FROM inventory WHERE NamaBarang = '"+ stockCombo.getSelectedItem() +"'", "idInventory") ;
        if(idInven != null){
            String query = "INSERT INTO `resep`( `idMenu`, `idInventory`, `dibutuhkan`) VALUES ('"+ menuId +"','"+ idInven +"','"+ jumlahDigunakan.getText() +"')";
            database.StartQuery(CC, query);
            JOptionPane.showMessageDialog(null, "Resep Ditambahkan");
        }
        jumlahDigunakan.setText("");
        showRecipe(CC, table,menuLabel,menuId);
    }
    
    public void deleteRecipe(Connection CC,JTable recipeTable,JLabel menuLabel, String menuId){
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?", "Penghapusan Data", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION){
           int i = recipeTable.getSelectedRow();
           TableModel model = recipeTable.getModel();
           database.StartQuery(CC, "DELETE FROM resep WHERE id = '"+ model.getValueAt(i, 0).toString() +"'");
           showRecipe(CC, recipeTable,menuLabel,menuId);
        }
    }
    
    public void showMenuCombo(Connection CC,JComboBox menu,String kategori){
        String Query = "SELECT DISTINCT menu FROM Menu INNER JOIN menucategory ON menu.idKategori = menucategory.idKategori INNER JOIN resep ON resep.idMenu = menu.idMenu WHERE menucategory.KategoriMenu = '"+kategori+"'";
        ArrayList<String> Datas =  database.selectRowofColumn(CC, Query, "Menu");
        gui.showComboBox(Datas, menu);
    }
    
}
