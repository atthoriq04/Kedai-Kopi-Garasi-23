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
    SQLFunc database = new SQLFunc();
    TransactionFunc transaction = new TransactionFunc();
    GUIFunc gui = new GUIFunc();
    public void ShowStock(Connection CC, JTable stockTable){
        Object[] titles={
            "Id","Nama Barang","Patokan Restok","Jumlah","Satuan"
        };
        String[] needed = {
        "idInventory","namaBarang","patokanRestok","Jumlah","Satuan"
        };
        String Query = "SELECT * FROM inventory INNER JOIN inventorycategory ON inventory.idKategori = inventorycategory.idKategori WHERE Status= 1";
        ArrayList<HashMap<String,String>> datas = database.selectAll(CC, needed, Query);
        gui.showTabel(CC, titles, needed, datas, stockTable);
    }
    
    public void showInventoryCategoryCombo(Connection CC,JComboBox combo){
        String Query = "SELECT * FROM inventorycategory ";
        ArrayList<String> Data = database.selectRowofColumn(CC, Query, "Satuan");
        gui.showComboBox(Data, combo);
    }
    
    public void showStockCombo(Connection CC, JComboBox combo ){
        String Query = "SELECT * FROM inventory WHERE Status= 1";
        ArrayList<String> Data = database.selectRowofColumn(CC, Query, "NamaBarang");
        gui.showComboBox(Data, combo);
    }
   
    
    public void InputStock(Connection CC,JTextField FormNama, JTextField Patokan,JComboBox combo,JTable tabel){
        String Query = "INSERT INTO inventory(`idKategori`, `NamaBarang`, `patokanRestok`) VALUES ('"+ combo.getSelectedIndex() +"','"+ FormNama.getText() +"','"+ Patokan.getText() +"')";
        database.StartQuery(CC, Query);
        JTextField[] fields = {FormNama,Patokan};
        gui.resetFields(fields);
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
        database.StartQuery(CC, Query);
        JTextField[] fields = {FormNama,Patokan};
        gui.resetFields(fields);
        combo.setSelectedIndex(0);
        ShowStock(CC,tabel);
        processButton.setText("Simpan");
        JOptionPane.showMessageDialog(null, "Bahan Baku Diupdate");
    }
    
    public void setResetTitle(JTable restockTable){
        Object[] titles={
            "Id","Nama Barang","Jumlah",
        };        
        gui.setTableTitle(titles, restockTable);
    }
    
    public void inputResetStore(Connection CC,JTable restockTable,JComboBox combo,JTextField jumlahRestok,JRadioButton patokan ){
        String Query = "SELECT * FROM inventory WHERE NamaBarang = '"+ combo.getSelectedItem() +"'";
        String[] dataWanted = {"idInventory","NamaBarang","patokanRestok"};
        HashMap<String,String> data = database.selectColumn(CC, Query, dataWanted);
        System.out.println();
        int jumlah = (patokan.isSelected()) ? (Integer.parseInt(jumlahRestok.getText())* Integer.parseInt(data.get("patokanRestok"))) : Integer.parseInt(jumlahRestok.getText()); 
        Object[] rowData = {
            data.get("idInventory"),
            data.get("NamaBarang"),
            jumlah,
        };
        gui.showTablerow(rowData);
        combo.setSelectedIndex(0);
        jumlahRestok.setText("1");
    }
    
    public void deleteFromStore(JTable restockTable){
        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?", "Penghapusan Data", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION){
           int i = restockTable.getSelectedRow();
           DefaultTableModel model = (DefaultTableModel) restockTable.getModel();
           model.removeRow(i);
           
        }
    }
    
    public void updateStockTotal(Connection CC ,JTable table){
        TableModel model = table.getModel();
        int row = model.getRowCount();
        DefaultTableModel Dmodel = (DefaultTableModel) table.getModel();
        if(row > 0){
            ArrayList<Integer> id = new ArrayList<>();
            ArrayList<Integer> jumlah = new ArrayList<>();
            for(int i = 0; i<row;i++){
                id.add(Integer.parseInt(model.getValueAt(i, 0).toString()));
                jumlah.add(Integer.parseInt(model.getValueAt(i, 2).toString()));
                String Query = "UPDATE inventory SET  jumlah = jumlah + "+ model.getValueAt(i, 2).toString() +" WHERE idInventory = "+model.getValueAt(i, 0).toString()+"";               
                database.StartQuery(CC, Query);
                Dmodel.removeRow(i);
            }
            JOptionPane.showMessageDialog(table, "Jumlah Stok berhasil ditambahkan");
            transaction.Restok(CC, id, jumlah);
        }else{
            JOptionPane.showMessageDialog(null, "Tidak Ada data untuk ditambahkan, Silahkan Masukkan Data");
        }
    }
    
    public void showCategoryStock(Connection CC, JTable kategoriStokTable){
        Object[] titles={
            "Id","Kategori","Satuan"
        };
        String[] Needed = {
            "idKategori","Kategori","Satuan"
        };
        String Query = "SELECT * FROM `inventorycategory`";
        ArrayList<HashMap<String,String>> Datas = database.selectAll(CC, Needed, Query);
        gui.showTabel(CC, titles, Needed, Datas, kategoriStokTable);
    }
    
    public void addCategory(Connection CC, JTextField kategori, JTextField satuan,JTable kategoriStokTable){
        database.StartQuery(CC, "INSERT INTO `inventorycategory`(`Kategori`, `Satuan`) VALUES ('"+kategori.getText()+"','"+satuan.getText()+"')");
        kategori.setText("");satuan.setText("");
        JOptionPane.showMessageDialog(null, "Kategori Baru berhasil ditambahkan");
        showCategoryStock(CC,kategoriStokTable);
    }
    
    public String categoryClicked(JTable kategoriStokTable,JTextField kategori, JTextField satuan,JButton Action){
        int i = kategoriStokTable.getSelectedRow();
       TableModel model = kategoriStokTable.getModel();
       String nama = model.getValueAt(i, 1).toString();
       String Satuan = model.getValueAt(i, 2).toString();
       kategori.setText(nama);
       satuan.setText(Satuan);
       Action.setText("Edit");
       
       return model.getValueAt(i, 0).toString();
        
    }
    
    public void EditCategory(Connection CC, JTextField kategori, JTextField satuan,JTable kategoriStokTable,JButton Action, String id){
        database.StartQuery(CC,"UPDATE inventorycategory SET kategori = '"+ kategori.getText() +"', Satuan = '"+ satuan.getText()+"' WHERE idKategori = '"+id+"'");
        kategori.setText("");satuan.setText("");
        Action.setText("Simpan");
        JOptionPane.showMessageDialog(null, "Kategori Berhasil Di Edit");
        showCategoryStock(CC,kategoriStokTable);
    }
    
    public void setOutTitle(JTable restockTable){
        Object[] titles={
            "Id","Nama Barang","Jumlah","Satuan","Keterangan"
        };        
        gui.setTableTitle(titles, restockTable);
    }
    
    public void inputOutStore(Connection CC,JTable restockTable,JComboBox combo,JTextField jumlahRestok,JTextField keterangan,JRadioButton patokan ){
        String Query = "SELECT * FROM inventory INNER JOIN inventorycategory ON inventorycategory.idKategori = inventory.idKategori WHERE NamaBarang = '"+ combo.getSelectedItem() +"'";
        String[] dataWanted = {"idInventory","NamaBarang","patokanRestok","Satuan"};
        HashMap<String,String> data = database.selectColumn(CC, Query, dataWanted);
        System.out.println(); 
        int jumlah = (patokan.isSelected()) ? (Integer.parseInt(jumlahRestok.getText())* Integer.parseInt(data.get("patokanRestok"))) : Integer.parseInt(jumlahRestok.getText()); 
        
        Object[] rowData = {
            data.get("idInventory"),
            data.get("NamaBarang"),
            jumlah,
            data.get("Satuan"),
            keterangan.getText()
            
        };
        gui.showTablerow(rowData);
        combo.setSelectedIndex(0);
        jumlahRestok.setText("1");
        keterangan.setText("");
    }
    
    public void decreaseStock(Connection CC ,JTable table){
        TableModel model = table.getModel();
        int row = model.getRowCount();
        DefaultTableModel Dmodel = (DefaultTableModel) table.getModel();
        if(row > 0){
            ArrayList<Integer> id = new ArrayList<>();
            ArrayList<Integer> jumlah = new ArrayList<>();
            ArrayList<String> Alasan = new ArrayList<>();
            for(int i = 0; i<row;i++){
                id.add(Integer.parseInt(model.getValueAt(i, 0).toString()));
                jumlah.add(Integer.parseInt(model.getValueAt(i, 2).toString()));
                Alasan.add((model.getValueAt(i, 4).toString()));
                String Query = "UPDATE inventory SET  jumlah = jumlah - "+ model.getValueAt(i, 2).toString() +" WHERE idInventory = "+model.getValueAt(i, 0).toString()+"";               
                database.StartQuery(CC, Query);
                Dmodel.removeRow(i);
            }
            JOptionPane.showMessageDialog(table, "Jumlah Stok berhasil ditambahkan");
            transaction.PengeluaranBukanPenjualan(CC, id, jumlah, Alasan);
        }else{
            JOptionPane.showMessageDialog(null, "Tidak Ada data untuk ditambahkan, Silahkan Masukkan Data");
        }
    }
    
    
}
