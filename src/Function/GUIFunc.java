/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Atthoriq
 */
public class GUIFunc {
    
    public DefaultTableModel tmdl;
    public void showPanel(JPanel from, JPanel to){
        from.removeAll();
        from.add(to);
    }
    public void switchPanel(JPanel from, JPanel to){
        from.removeAll();
        from.repaint();
        from.revalidate();
        from.add(to);
        from.repaint();
        from.revalidate();
    }
    public void showTabel(Connection CC,Object[] titles, String[] fieldsNeeded,ArrayList<HashMap<String,String>> Datas ,JTable tName) {
        tmdl = new DefaultTableModel(null, titles);
        tName.setModel(tmdl);
        for( int i=0;i < Datas.size();i++){
            Object[] Data = new Object[fieldsNeeded.length];
            for(int j = 0; j < fieldsNeeded.length; j++){
                Data[j] = Datas.get(i).get(fieldsNeeded[j]);
            }
            tmdl.addRow(Data);
            
        }
    }
    //Use When you need to sparate the title from the content.
    public void setTableTitle(Object[] titles, JTable tName){
        tmdl = new DefaultTableModel(null, titles);
        tName.setModel(tmdl);
    }
    public void showTablerow(Object[] rowData){
        tmdl.addRow(rowData);
    }
    public void showComboBox(ArrayList<String> datas,JComboBox combo){
        for(int i = 0; i<datas.size(); i++){
            combo.addItem(datas.get(i));
        }
    }
    public void resetFields(JTextField[] fields){
        for(JTextField field : fields){
            field.setText("");
        }
    
    }
}
