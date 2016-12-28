package com.ycsoft.ireport.util;

import net.sf.jasperreports.engine.JRException;

import java.io.OutputStream;

public interface IReportFileExporter {
    public void export(ReportPrint reportPrint, OutputStream os) throws JRException;
}