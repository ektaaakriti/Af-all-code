package com.Aforesight.Api.repository;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
//import com.securedloan.arthavedika.model.Applicant;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

@Transactional
@Repository
public class Jasper_report_repo {
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	public JasperPrint exportPDF(String start_date,String end_date,String report_type) throws SQLException, JRException, FileNotFoundException {
		try {
			String Filepath=null;
			Connection connection = jdbcTemplate.getDataSource().getConnection();
			//File file = ResourceUtils.getFile("classpath:Arthavedika2.jrxml");
			if(report_type.contains("totalTickets")) {
				Filepath="classpath:totalTickets.jrxml";}
				if(report_type.contains("QfixWiseSummary")) {
					Filepath="classpath:QfixWiseSummary.jrxml";	}
				if(report_type.contains("DailyReport")) {
					Filepath="classpath:DailyReport.jrxml";}
				if(report_type.contains("StatuswiseAssetReport")) {
					Filepath="classpath:StatuswiseAssetReport.jrxml";}
				if(report_type.contains("LocationWiseAssetReportTickets")) {
					Filepath="classpath:LocationWiseAssetReport.jrxml";
				}
				if(report_type.contains("csatRating")) {
					Filepath="classpath:csatRating.jrxml";}
				File file = ResourceUtils.getFile(Filepath);
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("start_date",start_date);
			parameters.put("end_date",end_date);
			System.out.println("in repo");
			System.out.println(start_date);
			System.out.println(end_date);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
			return jasperPrint;
		} catch (Exception e) {
			System.out.println("Error"+e);
			return null;
		}
}
	
}
