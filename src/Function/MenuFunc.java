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
    
    public void AddMenu(Connection CC,JTextField NamaMenu, JTextField harga, JComboBox combo,JTable menuTable){
        String Query = "INSERT INTO menu(`idKategori`, `Menu`, `Harga`) VALUES ('"+ combo.getSelectedIndex() +"','"+ NamaMenu.getText() +"','"+ harga.getText() +"')";
        database.StartQuery(CC, Query);
        NamaMenu.setText("");
        harga.setText("");
        combo.setSelectedIndex(0);
        showMenu(CC,menuTable);
        JOptionPane.showMessageDialog(null, "Data Menu Berhasil Di Input");
    }
    
    public String DataClicked(JTable tabel,JTextField FormNama, JTextField Patokan,JComboBox combo,JButton processButton){
       int i = tabel.getSelectedRow();
       TableModel model = tabel.getModel();
       String nama = model.getValueAt(i, 2).toString();
       String Harga = model.getValueAt(i, 3).toString().replaceAll("[^0-9]", "");
       String Selected = model.getValueAt(i, 1).toString();
       FormNama.setText(nama);
       Patokan.setText(Harga);
       combo.setSelectedItem(Selected);
       processButton.setText("Edit");
       
       return model.getValueAt(i, 0).toString();
    }
    
    public void editMenu(Connection CC,JTextField NamaMenu, JTextField harga, JComboBox combo,JTable menuTable,JButton processButton,String id){
        String Query = "UPDATE menu SET idKategori = '"+ combo.getSelectedIndex() +"', Menu = '"+ NamaMenu.getText() +"',Harga = '"+ harga.getText()+"' WHERE idMenu ="+id+" ";
        database.StartQuery(CC, Query);
        NamaMenu.setText("");
        harga.setText("");
        combo.setSelectedIndex(0);
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
}
