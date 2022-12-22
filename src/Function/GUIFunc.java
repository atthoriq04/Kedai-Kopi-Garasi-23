/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.JTable;
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
        ArrayList<String> column = new ArrayList<>();
        for( int i=0;i<Datas.size();i++){
            Object[] Data = new Object[Datas.size()];
            for(int j = 0; j < fieldsNeeded.length; j++){
                Data[j] = Datas.get(i).get(fieldsNeeded[j]);
            }
            tmdl.addRow(Data);
        }
    }
}
