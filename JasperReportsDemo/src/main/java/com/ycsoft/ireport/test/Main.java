package com.ycsoft.ireport.test;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yong on 2016/12/21 0021.
 */
public class Main {

    public static File printToPDF(String billid, Map parms, JRDataSource jsds) throws Exception {
        JasperReport jr = getJasperReport(billid);
        JasperPrint jp = JasperFillManager.fillReport(jr, parms, jsds);

        JRPdfExporter exporter = new JRPdfExporter();

        File file = new File("G:\\Yc_mui\\SpringMVCLearn\\JasperReportsDemo\\src\\main\\webapp\\ireport\\test.pdf");
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        FileOutputStream out = new FileOutputStream(file);

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);

        exporter.exportReport();
        out.close();
        return file;
    }

    protected static JasperReport getJasperReport(String billid) throws Exception {
        JasperReport report = null;
        if (report == null) {
            // 编译原文件
            ByteArrayOutputStream out = new ByteArrayOutputStream();
//			File file = new File(LOCAL_PRINT_MODEL_PATH);
//			if (!file.exists()) {
//				file.mkdirs();
//			}
            //Main.class.getClassLoader().getResource("")
            File file = new File("G:\\Yc_mui\\SpringMVCLearn\\JasperReportsDemo\\src\\main\\webapp\\ireport\\test.jrxml");
            if (file.exists()) {
                FileInputStream st = new FileInputStream(file);
                JasperCompileManager.compileReportToStream(st, out);
                st.close();
            } else {
                throw new Exception("票据打印模板未定义，请先定义 !!! ");
            }
            // 创建打印资源对象
            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            report = (JasperReport) JRLoader.loadObject(in);
            out.close();
            in.close();
        }
        return report;
    }

    public static void main(String[] args) {
        try {
            printToPDF("001", new HashMap(), new JasperDataSource());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
