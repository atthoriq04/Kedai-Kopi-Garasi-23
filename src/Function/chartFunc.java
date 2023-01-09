/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Function;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Component.TOP_ALIGNMENT;
import java.sql.Connection;
import java.util.Locale;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;

import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
/**
 *
 * @author Atthoriq
 */
public class chartFunc {
        TransactionFunc  transaction = new TransactionFunc();
        SQLFunc database = new SQLFunc();
        public void generateChart(Connection CC,JPanel chartPin){
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.setValue(transaction.MonthlyProfit(CC, "SELECT *  FROM penjualan WHERE MONTH(Tanggal) = MONTH('2023-1-1') AND YEAR(Tanggal) = YEAR(CURRENT_DATE())"), "Amount", "1");
            dataset.setValue(transaction.MonthlyProfit(CC, "SELECT *  FROM penjualan WHERE MONTH(Tanggal) = MONTH('2023-2-1') AND YEAR(Tanggal) = YEAR(CURRENT_DATE())"), "Amount", "2");
            dataset.setValue(transaction.MonthlyProfit(CC, "SELECT *  FROM penjualan WHERE MONTH(Tanggal) = MONTH('2023-3-1') AND YEAR(Tanggal) = YEAR(CURRENT_DATE())"), "Amount", "3");
            dataset.setValue(transaction.MonthlyProfit(CC, "SELECT *  FROM penjualan WHERE MONTH(Tanggal) = MONTH('2023-4-1') AND YEAR(Tanggal) = YEAR(CURRENT_DATE())"), "Amount", "4");
            dataset.setValue(transaction.MonthlyProfit(CC, "SELECT *  FROM penjualan WHERE MONTH(Tanggal) = MONTH('2023-5-1') AND YEAR(Tanggal) = YEAR(CURRENT_DATE())"), "Amount", "5");
            dataset.setValue(transaction.MonthlyProfit(CC, "SELECT *  FROM penjualan WHERE MONTH(Tanggal) = MONTH('2023-6-1') AND YEAR(Tanggal) = YEAR(CURRENT_DATE())"), "Amount", "6");
            dataset.setValue(transaction.MonthlyProfit(CC, "SELECT *  FROM penjualan WHERE MONTH(Tanggal) = MONTH('2023-7-1') AND YEAR(Tanggal) = YEAR(CURRENT_DATE())"), "Amount", "7");
            dataset.setValue(transaction.MonthlyProfit(CC, "SELECT *  FROM penjualan WHERE MONTH(Tanggal) = MONTH('2023-8-1') AND YEAR(Tanggal) = YEAR(CURRENT_DATE())"), "Amount", "8");
            dataset.setValue(transaction.MonthlyProfit(CC, "SELECT *  FROM penjualan WHERE MONTH(Tanggal) = MONTH('2023-9-1') AND YEAR(Tanggal) = YEAR(CURRENT_DATE())"), "Amount", "9");
            dataset.setValue(transaction.MonthlyProfit(CC, "SELECT *  FROM penjualan WHERE MONTH(Tanggal) = MONTH('2023-10-1') AND YEAR(Tanggal) = YEAR(CURRENT_DATE())"), "Amount", "10");
            dataset.setValue(transaction.MonthlyProfit(CC, "SELECT *  FROM penjualan WHERE MONTH(Tanggal) = MONTH('2023-11-1') AND YEAR(Tanggal) = YEAR(CURRENT_DATE())"), "Amount", "11");
            dataset.setValue(transaction.MonthlyProfit(CC, "SELECT *  FROM penjualan WHERE MONTH(Tanggal) = MONTH('2023-12-1') AND YEAR(Tanggal) = YEAR(CURRENT_DATE())"), "Amount", "12");

            JFreeChart chart = ChartFactory.createBarChart("Pemasukan Tahunan","Bulan","Jumlah", dataset, PlotOrientation.VERTICAL, false,true,false);
            chart.setBackgroundPaint(new Color(42,52,62));
            chart.getTitle().setPaint(new Color(228,228,228));
            CategoryPlot categoryPlot = chart.getCategoryPlot();
            //categoryPlot.setRangeGridlinePaint(Color.BLUE);
            CategoryAxis domain = categoryPlot.getDomainAxis();
            domain.setTickLabelPaint(new Color(228,228,228));
            domain.setLabelPaint(new Color(228,228,228));
            ValueAxis range = categoryPlot.getRangeAxis();
            range.setTickLabelPaint(new Color(228,228,228));
            range.setLabelPaint(new Color(228,228,228));
            categoryPlot.setBackgroundPaint(new Color(42,52,62));
            BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
            Color clr3 = new Color(87,124,255);
            renderer.setSeriesPaint(0, clr3);
            ChartPanel barpChartPanel = new ChartPanel(chart);
            chartPin.removeAll();
            chartPin.add(barpChartPanel, BorderLayout.CENTER);
            chartPin.validate();
        }
        
        public void generatePie(Connection CC,JPanel chartPin){
            DefaultPieDataset pie = new DefaultPieDataset();
            int hilang = Integer.parseInt(database.selectData(CC, "SELECT COUNT(idTransaksi) FROM transaksi WHERE MONTH(tanggalTransaksi) = MONTH(CURRENT_DATE()) AND YEAR(tanggalTransaksi) = YEAR(CURRENT_DATE()) AND Keterangan = 'hilang'", "COUNT(idTransaksi)"));
            int rusak = Integer.parseInt(database.selectData(CC, "SELECT COUNT(idTransaksi) FROM transaksi WHERE MONTH(tanggalTransaksi) = MONTH(CURRENT_DATE()) AND YEAR(tanggalTransaksi) = YEAR(CURRENT_DATE()) AND Keterangan = 'rusak'", "COUNT(idTransaksi)"));
            int produksi = Integer.parseInt(database.selectData(CC, "SELECT COUNT(idTransaksi) FROM transaksi WHERE MONTH(tanggalTransaksi) = MONTH(CURRENT_DATE()) AND YEAR(tanggalTransaksi) = YEAR(CURRENT_DATE()) AND Keterangan = 'produksi'", "COUNT(idTransaksi)"));
            int lainnya = Integer.parseInt(database.selectData(CC, "SELECT COUNT(idTransaksi) FROM transaksi WHERE MONTH(tanggalTransaksi) = MONTH(CURRENT_DATE()) AND YEAR(tanggalTransaksi) = YEAR(CURRENT_DATE()) AND Keterangan != 'produksi' AND Keterangan != 'Hilang' AND Keterangan != 'rusak'", "COUNT(idTransaksi)"));
            pie.setValue("Produksi", produksi);
            pie.setValue("Rusak", rusak);
            pie.setValue("Hilang", hilang);
            pie.setValue("Lainnya", lainnya);
            JFreeChart chart = ChartFactory.createPieChart("Graf Pengeluaran Bahan Baku Bulan Ini", pie, true, true, true);
            chart.setBackgroundPaint(new Color(42,52,62));
            chart.getTitle().setPaint(new Color(228,228,228));
            PiePlot plot = (PiePlot)chart.getPlot();
            plot.setSectionPaint("Lainnya", new Color(255,0,0));
            plot.setSectionPaint("Produksi", new Color(87,124,255));
            plot.setSectionPaint("Rusak",  new Color(120, 0, 120));
            plot.setBackgroundPaint(new Color(42,52,62));
//            plot.setForegroundAlpha(TOP_ALIGNMENT);
            ChartPanel barpChartPanel = new ChartPanel(chart);
            chartPin.removeAll();
            chartPin.add(barpChartPanel, BorderLayout.CENTER);
            chartPin.validate();
            
        }
}
