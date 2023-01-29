package Function;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
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
    
    public void Restok(Connection CC,ArrayList<HashMap<String,String>> datas,int userId){
        for(HashMap data : datas){
            database.StartQuery(CC, "INSERT INTO `restok`(`idSuplier`, `idInventory`, `jumlah`, `userId`)VALUES('"+data.get("idSupplier")+"','"+data.get("id")+"','"+data.get("jumlah")+"','"+userId+"')");
        }
        JOptionPane.showMessageDialog(null, "Data Restok Ditambahkan");
    }
    
    public void showRestokData(Connection CC, JTable table){
        Object[] title = {
            "kodeRestok","Tanggal Restok","Nama Bahan Baku","jumlah","Satuan","Nama Petugas"
        } ;
        String[] dataNeeded ={
            "idRestok","Tanggal","namaBarang","restok.jumlah","satuan","Nama"
        };
        gui.showTabel(CC, title, dataNeeded, database.selectAll(CC, dataNeeded, "SELECT * FROM Restok INNER JOIN inventory ON restok.idInventory = inventory.idInventory INNER JOIN user ON user.id = Restok.userId"), table);
    }
    
    public void Pengeluaran(Connection CC,ArrayList<HashMap<String,String>> datas,int userId){
        for(HashMap data : datas){
            String Query = "INSERT INTO transaksi(idInventory,jumlah,idUser,Keterangan) VALUES ('"+data.get("id")+"','"+data.get("jumlah")+"','"+userId+"','"+data.get("alasan")+"')";
            database.StartQuery(CC, Query);
        }
        JOptionPane.showMessageDialog(null, "Pengeluaran berhasil Di Data");
        
    }
    
    public void Penjualan(Connection CC,String menuID,int pendapatan,String jumlah,int loginId){
        database.StartQuery(CC, "INSERT INTO `penjualan`(`idMenu`, `jumlah`, `pendapatan`, `idUser`) VALUES ('"+menuID+"','"+jumlah+"','"+pendapatan+"','"+loginId+"')");
         JOptionPane.showMessageDialog(null, "Penjualan berhasil Di Data");
    }
    
    public void showPengeluaranData(Connection CC, JTable tName){
        Object[] titles={
            "id Transaksi","Tanggal Transaksi","Nama Bahan Baku","Jumlah","Satuan","Keterangan","Nama Petugas"
        };
        String[] needed = {
            "idTransaksi","tanggalTransaksi","inventory.namaBarang","transaksi.jumlah","satuan","Keterangan","Nama"
        };
        gui.showTabel(CC, titles, needed, database.selectAll(CC, needed, "SELECT * FROM transaksi INNER JOIN inventory ON inventory.idInventory = transaksi.idInventory INNER JOIN user ON user.id = transaksi.idUser"), tName);
    }
    
    public void showPenjualanData(Connection CC, JTable tName){
        Object[] titles={
            "id Penjualan","Tanggal Transaksi","Nama Produk","Jumlah Terjual","Harga","Pendapatan","Nama Petugas"
        };
        String[] needed = {
            "idPenjualan","tanggal","menu.Menu","jumlah","menu.Harga","pendapatan","Nama"
        };
        gui.showTabel(CC, titles, needed, database.selectAll(CC, needed, "SELECT * FROM `penjualan` INNER JOIN menu ON penjualan.idMenu = menu.idMenu INNER JOIN user ON penjualan.idUser = user.id"), tName);
    }    
    
    public String frequentMenu(Connection CC){
        HashMap<String,String> data = database.selectColumn(CC, "SELECT menu ,COUNT(menu) AS value_occurrence FROM penjualan INNER JOIN menu ON menu.idMenu = penjualan.idMenu  WHERE tanggal >= CURDATE() GROUP BY menu  LIMIT 1", new String[] {"menu","value_occurrence"});
        if(data.get("menu")== null){
            return "Belum ada transaksi hari ini";
        }
        return data.get("menu")+" - "+data.get("value_occurrence")+" Transaksi";
    }
    
    public int calculateProfit(Connection CC){
        ArrayList<String> datas = database.selectRowofColumn(CC, "SELECT * FROM `penjualan` WHERE tanggal >= CURDATE()", "pendapatan");
        int sum = 0;
        for(String data : datas){
            sum += Integer.parseInt(data);
        }
        return sum;
    }
    
    public int MonthlyProfit(Connection CC, String Query){
       ArrayList<String> datas = database.selectRowofColumn(CC, Query, "pendapatan");
        int sum = 0;
        for(String data : datas){
            sum += Integer.parseInt(data);
        }
        return sum;
    }

}
