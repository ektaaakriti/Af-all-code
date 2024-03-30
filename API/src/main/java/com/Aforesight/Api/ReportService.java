package com.Aforesight.Api;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Aforesight.Api.repository.Jasper_report_repo;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

@Service
public class ReportService {
	
	@Autowired
	private Jasper_report_repo repo;

	public void exportReport(String start_date,String end_date,String report_type, OutputStream out)
			throws FileNotFoundException, SQLException, JRException {
		System.out.println("in report service");
		System.out.println(start_date);
		System.out.println(end_date);
		JasperPrint jasperPrint = repo.exportPDF(start_date,end_date,report_type);
		JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	}
public void exportReportCsv(String start_date,String end_date,String report_type,OutputStream out) throws FileNotFoundException, SQLException, JRException  
	
{System.out.println("in report service for csv");
System.out.println(start_date);
System.out.println(end_date);
JasperPrint jasperPrint = repo.exportPDF(start_date,end_date,report_type);
JRCsvExporter exporter = new JRCsvExporter();
exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
exporter.setExporterOutput(
		  new SimpleWriterExporterOutput(out));
exporter.exportReport();
	
}
public void exportReportXls(String start_date,String end_date,String report_type,OutputStream out) throws FileNotFoundException, SQLException, JRException  

{System.out.println("in report service for XLS");
System.out.println(start_date);
System.out.println(end_date);
JasperPrint jasperPrint = repo.exportPDF(start_date,end_date,report_type);
JRXlsxExporter exporter = new JRXlsxExporter();

//Set input and output ...
exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
exporter.setExporterOutput(
  new SimpleOutputStreamExporterOutput(out));
SimpleXlsxReportConfiguration reportConfig
= new SimpleXlsxReportConfiguration();
reportConfig.setSheetNames(new String[] { "Employee Data" });

exporter.setConfiguration(reportConfig);
exporter.exportReport();
}
}
