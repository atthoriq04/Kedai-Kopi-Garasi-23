/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;
import javax.swing.JPanel;
/**
 *
 * @author Atthoriq
 */
public class GUIFunc {
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
}
