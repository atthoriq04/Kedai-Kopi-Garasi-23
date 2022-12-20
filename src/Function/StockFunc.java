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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Atthoriq
 */
public class StockFunc {
    public DefaultTableModel tmdl;
    SQLFunc SQL = new SQLFunc();
    public void ShowStock(Connection CC, JTable stockTable){
        Object[] titles={
            "Id","Nama Barang","Patokan Restok","Jumlah","Satuan"
        };
        
        String Query = "SELECT * FROM inventory INNER JOIN inventorycategory ON inventory.idKategori = inventorycategory.idKategori WHERE Status= 1";
        tmdl = new DefaultTableModel(null, titles);
        stockTable.setModel(tmdl);
        try{
            Statement stat = CC.createStatement();
            ResultSet rs = stat.executeQuery(Query);
            while(rs.next()){
               Object[] Datas = {
                       rs.getInt("idInventory"),
                       rs.getString("namaBarang"),
                       rs.getString("patokanRestok"),
                       rs.getString("Jumlah"),
                       rs.getString("Satuan")
               };
               tmdl.addRow(Datas);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }
    
    public void showInventoryCategoryCombo(Connection CC,JComboBox combo){
        String Query = "SELECT * FROM inventorycategory ";
        try{
            Statement stat = CC.createStatement();
            ResultSet rs = stat.executeQuery(Query);
            while(rs.next()){
               combo.addItem(rs.getString("Satuan"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }
    
    public void showStockCombo(Connection CC, JComboBox combo ){
        String Query = "SELECT * FROM inventory WHERE Status= 1";
        try{
            Statement stat = CC.createStatement();
            ResultSet rs = stat.executeQuery(Query);
            while(rs.next()){
               combo.addItem(rs.getString("NamaBarang"));
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }
   
    
    public void InputStock(Connection CC,JTextField FormNama, JTextField Patokan,JComboBox combo,JTable tabel){
        String Query = "INSERT INTO inventory(`idKategori`, `NamaBarang`, `patokanRestok`) VALUES ('"+ combo.getSelectedIndex() +"','"+ FormNama.getText() +"','"+ Patokan.getText() +"')";
        SQL.StartQuery(CC, Query);
        FormNama.setText("");
        Patokan.setText("");
        combo.setSelectedIndex(0);
        ShowStock(CC,tabel);    
        JOptionPane.showMessageDialog(null, "Bahan Baku Di Input");
    }
    
    public String DataClicked(JTable tabel,JTextField FormNama, JTextField Patokan,JComboBox combo,JButton processButton){
       int i = tabel.getSelectedRow();
       TableModel model = tabel.getModel();
       String nama = model.getValueAt(i, 1).toString();
       String patokan = model.getValueAt(i, 2).toString();
       String Selected = model.getValueAt(i, 4).toString();
       FormNama.setText(nama);
       Patokan.setText(patokan);
       combo.setSelectedItem(Selected);
       processButton.setText("Edit");
       
       return model.getValueAt(i, 0).toString();
    }
    
    public void updateStock(String id,Connection CC,JTextField FormNama, JTextField Patokan,JComboBox combo,JTable tabel,JButton processButton){
        String Query = "UPDATE inventory SET idKategori = '"+ combo.getSelectedIndex() +"', NamaBarang = '"+ FormNama.getText() +"',patokanRestok = '"+ Patokan.getText()+"' WHERE idInventory ="+id+" ";
        SQL.StartQuery(CC, Query);
        FormNama.setText("");
        Patokan.setText("");
        combo.setSelectedIndex(0);
        ShowStock(CC,tabel);
        processButton.setText("Simpan");
        JOptionPane.showMessageDialog(null, "Bahan Baku Diupdate");
    }
    
    public void setResetStore(JTable restockTable){
        Object[] titles={
            "Id","Nama Barang","Jumlah",
        };        
        tmdl = new DefaultTableModel(null, titles);
        restockTable.setModel(tmdl);
    }
    
    public void inputResetStore(Connection CC,JTable restockTable,JComboBox combo,JTextField jumlahRestok,JRadioButton patokan ){
        
        
        String Query = "SELECT * FROM inventory WHERE NamaBarang = '"+ combo.getSelectedItem() +"'";
        try{
            String Id,Nama;
            int jumlah,Patokan;
            Statement stat = CC.createStatement();
            ResultSet rs = stat.executeQuery(Query);
            if(rs.next()){
                Id = rs.getString("idInventory");
                Nama = rs.getString("NamaBarang");
                Patokan = rs.getInt("patokanRestok");
                jumlah = Integer.parseInt(jumlahRestok.getText());
                if(patokan.isSelected()){  
                    jumlah = Integer.parseInt(jumlahRestok.getText()) * Patokan;
                }
                Object[] Data = {
                    Id,Nama,jumlah
                };
                tmdl.addRow(Data);
            }
            combo.setSelectedIndex(0);
            jumlahRestok.setText("0");
            
        }catch(Exception E){
            E.printStackTrace();
        }
    }
    
    public void restock(Connection CC ,JTable table){
        TableModel model = table.getModel();
        int row = model.getRowCount();
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<Integer> jumlah = new ArrayList<>();
        for(int i = 0; i<row;i++){
            id.add(Integer.parseInt(model.getValueAt(i, 0).toString()));
            jumlah.add(Integer.parseInt(model.getValueAt(i, 2).toString()));
            String Query = "INSERT INTO `restok`(`idInventory`, `jumlah`)VALUES('"+model.getValueAt(i, 0).toString()+"','"+model.getValueAt(i, 2).toString()+"')";
            SQL.StartQuery(CC, Query);
        }
        JOptionPane.showMessageDialog(table, "Data Restok Ditambahkan");
        UpdateStockCount(CC,id,jumlah);
    }
    
    public void UpdateStockCount(Connection CC,ArrayList ids,ArrayList jumlah){
        for(int i = 0; i<ids.size();i++){
            String Query = "UPDATE inventory SET  jumlah = jumlah + "+ jumlah.get(i) +" WHERE idInventory = "+ids.get(i)+"";
            SQL.StartQuery(CC, Query);
        }
        JOptionPane.showMessageDialog(null, "Jumlah Bahan Baku berhasil ditambahkan");
    }
}
