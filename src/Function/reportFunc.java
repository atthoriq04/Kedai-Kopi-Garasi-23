/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
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
