/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Atthoriq
 */
public class reportFunc {
    public reportFunc(){
        Locale locale = new Locale ("id","ID");
        Locale.setDefault(locale);
    }
    public void restockReport(Connection CC){
        try{
            InputStream file = new FileInputStream(new File("src/report/laporanBahanMasuk.jrxml"));
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,null,CC);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void StockUsageReport(Connection CC){
        try{
            InputStream file = new FileInputStream(new File("src/report/laporanBahanKeluar.jrxml"));
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,null,CC);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
        catch(Exception e){
        }
    }
    public void salesReport(Connection CC){
        try{
            InputStream file = new FileInputStream(new File("src/report/laporanPenjualan.jrxml"));
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,null,CC);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
        catch(Exception e){
        }
    }
    public void supplierReport(Connection CC){
        try{
            InputStream file = new FileInputStream(new File("src/report/laporanSupplier.jrxml"));
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,null,CC);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
        catch(Exception e){
        }
    }
    public void userReport(Connection CC){
        try{
            InputStream file = new FileInputStream(new File("src/report/laporanKaryawan.jrxml"));
            JasperDesign jd = JRXmlLoader.load(file);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,null,CC);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
        catch(Exception e){
        }
    }
}
