/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
    public void showTabel(Connection CC,Object[] titles,String Query, JTable tName) {
        tmdl = new DefaultTableModel(null, titles);
        tName.setModel(tmdl);;
        try{
            Statement stat = CC.createStatement();
            ResultSet rs = stat.executeQuery(Query);
            while(rs.next()){
               Object[] Datas = {
                       rs.getInt("id"),
                       rs.getString("Nama"),
                       rs.getString("Username"),
                       rs.getString("Role"),
               };
               tmdl.addRow(Datas);
            }
        }catch(Exception E){
            E.printStackTrace();
        }
    }
}
