/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;
import customGUI.TableDark;
import customGUI.customButton;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    
    public void changeLabel(JLabel target, String text){
        target.setText(text);
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
    
    public void hoverIn(JPanel panel , JLabel label){
        panel.setBackground(new Color(56,78,109));
    }
    
    public void hoverOut(JPanel panel,JLabel label,int state, int active){
        if(state!=active){
            panel.setBackground(new Color(42,52,62));
        }
    }
    
    public void reset(JPanel[] panels, JLabel[] labels){
        for(JPanel panel : panels){
            panel.setBackground(new Color(42,52,62));
        }
    }
    
    public void fixTable(TableDark[] tables, JScrollPane[] scrolls ){
        for(int i = 0; i < tables.length; i++){
            tables[i].fixTable(scrolls[i]);
        }
    }
    
    public void buttonchange(customButton Button,Color color, Color over, Color click, int Radius){
        Button.setColor(color);
        Button.setColorOver(over);
        Button.setColorClick(click);
        Button.setBorderColor(over);
        Button.setRadius(Radius);
    }
}
