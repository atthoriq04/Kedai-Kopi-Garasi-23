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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
/**
 *
 * @author thori
 */
public class TableFunc {
    PreparedStatement pst;
    public Statement stt;
    public DefaultTableModel tmdl;
    GUIFunc gui = new GUIFunc();
    public void tableTitle(Object[] titles, JTable tName) {
        tmdl = new DefaultTableModel(null, titles);
        tName.setModel(tmdl);
    }
}
