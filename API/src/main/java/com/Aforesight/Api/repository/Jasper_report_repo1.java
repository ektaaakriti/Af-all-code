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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Transactional
@Repository
public class Jasper_report_repo1 {
	
	@Autowired 
	JdbcTemplate jdbcTemplate;
	public JasperPrint exportPDF(Date StartDate,Date EndDate) throws SQLException, JRException, FileNotFoundException {
		try {
			Connection connection = jdbcTemplate.getDataSource().getConnection();
			//File file = ResourceUtils.getFile("classpath:Arthavedika2.jrxml");
			File file = ResourceUtils.getFile("classpath:ReportNew.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("startDate",StartDate);
			parameters.put("endDate",EndDate);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
			return jasperPrint;
		} catch (Exception e) {
			System.out.println("Error");
			return null;
		}
}
}

