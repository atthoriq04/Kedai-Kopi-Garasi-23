/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;

/**
 *
 * @author Atthoriq
 */
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
public class SupplierFunc {
    public DefaultTableModel tmdl;
    SQLFunc database = new SQLFunc();
    TransactionFunc transaction = new TransactionFunc();
    GUIFunc gui = new GUIFunc();
    
    public void showSupplier(Connection CC,JTable supplierTable){
        Object[] titles={
            "Kode Supplier","Nama Supplier","No Telepon","Alamat"
        };
        String[] needed = {
            "idSuplier","namaSuplier","noTelepon","alamatSuplier"
        };
        gui.showTabel(CC, titles, needed, database.selectAll(CC, needed, "SELECT * FROM supplier"), supplierTable);
    }
    
    public void addSupplier(Connection CC, JTextField namaSupplier , JTextField noTelepon, JTextField Alamat, JTable supplierTable){
        String query = "INSERT INTO `supplier`(`namaSuplier`, `noTelepon`, `alamatSuplier`) VALUES ('"+ namaSupplier.getText() +"','"+ noTelepon.getText() +"','"+ Alamat.getText() +"')";
        System.out.print(query);
        database.StartQuery(CC, query);
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
        JTextField[] fields = {namaSupplier,noTelepon,Alamat}; 
        gui.resetFields(fields);
        showSupplier(CC,supplierTable);
        
    }
    
    public String dataClicked(JTable suplierTable,JTextField namaSuplier, JTextField noTelepon,JTextField Alamat,JButton processButton){
        int i = suplierTable.getSelectedRow();
       TableModel model = suplierTable.getModel();
       String nama = model.getValueAt(i, 1).toString();
       String telepon = model.getValueAt(i, 2).toString();
       String alamat = model.getValueAt(i, 3).toString();
       editInput(namaSuplier,noTelepon,Alamat,processButton,nama,telepon,alamat);
       return model.getValueAt(i, 0).toString();
    }
    
    public void editInput(JTextField namaSuplier, JTextField noTelepon,JTextField Alamat,JButton processButton,String nama,String telepon, String alamat){
       namaSuplier.setText(nama);
       noTelepon.setText(telepon);
       Alamat.setText(alamat);
       processButton.setText("Edit");
    }
    
    public void editSupplier(Connection CC, JTextField namaSupplier , JTextField noTelepon, JTextField Alamat, JTable supplierTable,String id,JButton processButton){
        String query = "UPDATE `supplier` SET `namaSuplier`='"+ namaSupplier.getText() +"',`noTelepon`='"+ noTelepon.getText() +"',`alamatSuplier`='"+ Alamat.getText() +"' WHERE `idSuplier`= "+id+" ";
        database.StartQuery(CC, query);
        namaSupplier.setText("");
        noTelepon.setText("");
        Alamat.setText("");
        processButton.setText("Simpan");
        showSupplier(CC,supplierTable);
        JOptionPane.showMessageDialog(null, "Data Menu Berhasil Di Edit");
    }
    
}
