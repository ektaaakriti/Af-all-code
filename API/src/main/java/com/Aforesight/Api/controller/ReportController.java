//This is controller class for report module
package com.Aforesight.Api.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.Aforesight.Api.ReportService;
import com.Aforesight.Api.SampleBean;
import com.Aforesight.Api.entity.Agent_msg_dtls;
import com.Aforesight.Api.entity.LicenseEntity;
import com.Aforesight.Api.entity.Report_of_Ticket;
import com.Aforesight.Api.payload.License_payload;
import com.Aforesight.Api.payload.Report_of_Ticket_payload;
import com.Aforesight.Api.repository.Discovered_asset_repository;
import com.Aforesight.Api.repository.LicenseDetailsRepository;
import com.Aforesight.Api.repository.License_repository;
import com.Aforesight.Api.repository.Report_of_Ticket_repository;
import com.Aforesight.Api.repository.qfixRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import net.sf.jasperreports.view.JasperViewer;

@CrossOrigin ()
@RestController
@Service
@RequestMapping("/api/report")
public class ReportController {
    public static Logger LOGGER = LogManager.getLogger(AuthController.class.getName());

	@Autowired 
    private Report_of_Ticket_repository repo;
 @Autowired
 private Discovered_asset_repository  repo1;
 @Autowired
 private qfixRepository repo2;
 @Autowired
 private Discovered_asset_repository repo3;
 @PostMapping(value="/Report_Generation",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
         produces = {MediaType.APPLICATION_JSON_VALUE})
 public ResponseEntity<?> Report(@RequestBody Report_of_Ticket_payload payload) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException{
	     Report_of_Ticket le=new Report_of_Ticket();
	  Long total=payload.getTotal_Tickets();
	  System.out.println(total);
	   Long Autoresolvable_tks=repo2.Total_Tickets();
	   System.out.println(Autoresolvable_tks);
	   Long Manually_resolvable_tks=total-Autoresolvable_tks;
	   System.out.println(Manually_resolvable_tks);
	   Long resolved_tks=repo2.Tickets_resolved();
	   System.out.println(resolved_tks);
	   Long failed_tks=repo2.Tickets_failed();
	   System.out.println(failed_tks);
	   Long per_autoresolved=(resolved_tks*100)/total;
	   System.out.println(per_autoresolved);
	   System.out.println(per_autoresolved);
	   Long success_rate=(resolved_tks*100)/Autoresolvable_tks;
	   System.out.println(success_rate);
	   Long machine_with_agent=repo3.maachineCountAgent();
	   Long machine_with_ticket_raised=repo2.maachineCountTickets();
	   Long per_ticket_raised_af=(Autoresolvable_tks*100)/total;
	   System.out.println(per_ticket_raised_af);
	    repo.deleteAll();
	    le.setTotal_Tickets(total);
	    le.setManually_resolvable_tickets(Manually_resolvable_tks);
	    le.setAuto_resolvable_tickets(Autoresolvable_tks);
	    le.setTickets_resolved(resolved_tks);
	    le.setTickets_failed(failed_tks);
	    le.setPer_tickets_auto_resolved(per_autoresolved);
	    le.setAutomation_success_rate(success_rate);
	    le.setNo_of_machines_deployed(machine_with_agent);
	    le.setNo_of_machine_tickets_via_af(machine_with_ticket_raised);
	    le.setTickets_via_af(Autoresolvable_tks);
	    le.setTickets_on_itsm_tool_directly(Manually_resolvable_tks);
	    le.setPer_tickets_raised_via_af(per_ticket_raised_af);
	    
	    repo.save(le);
	    List<Report_of_Ticket> lst=repo.Report();
					return new ResponseEntity<>(lst,HttpStatus.OK);
	}
 /*@GetMapping(path = "/downloadreportcsv")
 public void getAllEmployeesInCsv(HttpServletResponse servletResponse)  {
     try{servletResponse.setContentType("text/csv");
     //Agent_msg_dtls msg=new Agent_msg_dtls();
     servletResponse.addHeader("Content-Disposition","attachment; filename=\"report.csv\"");
    List<Agent_msg_dtls> lst= repo2.All_Ticket_report();
    ICsvBeanWriter csvwriter=new CsvBeanWriter(servletResponse.getWriter(),CsvPreference.STANDARD_PREFERENCE);
    String[] csvHeader= {"Ticket_id","Msg_id","Msg Description","Enque date and time","Deque date and time","ITSM Request id","User_mail","User_id","Msg date and time","Feedback Date and time","Status"};
    String[] nameMapping= {"msg_ticket_Id","Msg_id","Msg_description","msg_enqueue_datetime","msg_deueue_datetime","itsm_reqid","outlook_email","user_id","Msg_datetime","feedback_datetime","msg_status_YN"};
 csvwriter.writeHeader(csvHeader);
 for (Agent_msg_dtls msg:lst) {
	 System.out.println(msg.getMsg_status_YN());
	 String status=msg.getMsg_status_YN();
	 if(status.contains("Of")||status.contains("O")) {
		 msg.setMsg_status_YN("open");
	 }
	 else if(status.contains("Cf")||status.contains("C")) {
		 msg.setMsg_status_YN("close");
	 }
	 else if(status.contains("Y")) {
		 msg.setMsg_status_YN("Not executed");
	 }
	 else if(status.contains("N")) {
		 msg.setMsg_status_YN("resolved");
	 }
	 else
	 {
		 msg.setMsg_status_YN(" ");
	 }
	 System.out.println(msg.getMsg_status_YN());
	 
	 csvwriter.write(msg, nameMapping);
 }
 csvwriter.close();
 
 }
 catch (Exception e) {
	 System.out.println(e);
 }}*/
 
 @PostMapping(value="/getAll_Ticket_Details",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
 public ResponseEntity<?> getTicketDetails()
 {
	 List<Agent_msg_dtls> lst= repo2.All_Ticket_report();
	 
		return new ResponseEntity<>(lst,HttpStatus.OK);
	 
 }
	@Autowired
	private ReportService reportService;
 @GetMapping("/jasper/report/{start_date},{end_date},{report_type},{report_format}")
	public void generateReport(HttpServletResponse response,@PathVariable String start_date,@PathVariable String end_date,@PathVariable String report_type ,@PathVariable String report_format) throws IOException, SQLException, JRException {
	try {	LOGGER.info("Jasper Report api has been called !!! Start Of Method generateReport");
		System.out.println(start_date);
		System.out.println(end_date);
		response.setContentType("application/x-download");
		//response.setContentType("application/vnd.ms-excel");
		if(report_format.contains("pdf")) {
			LOGGER.info("in pdf download of report");
		if(report_type.contains("totalTickets")) {
			
			//response.setHeader("Content-Disposition", String.format("attachment;filename=\"Totalticketreport.xls\""));}
		response.setHeader("Content-Disposition", String.format("attachment;filename=\"Totalticketreport.pdf\""));}
		if(report_type.contains("QfixWiseSummary")) {
			response.setHeader("Content-Disposition", String.format("attachment;filename=\"QfixwiseSummaryreport.pdf\""));}
		if(report_type.contains("DailyReport")) {
			response.setHeader("Content-Disposition", String.format("attachment;filename=\"Dailyreport.pdf\""));}
		if(report_type.contains("StatuswiseAssetReport")) {
			response.setHeader("Content-Disposition", String.format("attachment;filename=\"StatuswiseAssetReportreport.pdf\""));}
		if(report_type.contains("LocationWiseAssetReportTickets")) {
			response.setHeader("Content-Disposition", String.format("attachment;filename=\"LoactionwiseAssetreport.pdf\""));}
		if(report_type.contains("csatRating")) {
			response.setHeader("Content-Disposition", String.format("attachment;filename=\"csatratingReport.pdf\""));}
		OutputStream out =response.getOutputStream();
		
		reportService.exportReport(start_date,end_date,report_type,out);
	}
		if(report_format.contains("xcel")) {
			LOGGER.info("in xcel download of report");
			if(report_type.contains("totalTickets")) {
				
				//response.setHeader("Content-Disposition", String.format("attachment;filename=\"Totalticketreport.xls\""));}
			response.setHeader("Content-Disposition", String.format("attachment;filename=\"Totalticketreport.xls\""));}
			if(report_type.contains("QfixWiseSummary")) {
				response.setHeader("Content-Disposition", String.format("attachment;filename=\"QfixwiseSummaryreport.xls\""));}
			if(report_type.contains("DailyReport")) {
				response.setHeader("Content-Disposition", String.format("attachment;filename=\"Dailyreport.xls\""));}
			if(report_type.contains("StatuswiseAssetReport")) {
				response.setHeader("Content-Disposition", String.format("attachment;filename=\"StatuswiseAssetReportreport.xls\""));}
			if(report_type.contains("LocationWiseAssetReportTickets")) {
				response.setHeader("Content-Disposition", String.format("attachment;filename=\"LoactionwiseAssetreport.xls\""));}
			if(report_type.contains("csatRating")) {
				response.setHeader("Content-Disposition", String.format("attachment;filename=\"csatratingReport.xls\""));}
			OutputStream out =response.getOutputStream();

			reportService.exportReportXls(start_date, end_date, report_type, out);
		}}
	catch (Exception e) {
		LOGGER.error("Error While Uploading the file" + e.getMessage());
	}
 }

/*
	@Autowired 
	JdbcTemplate jdbcTemplate;
 @GetMapping("/jasper/reportXLS/{start_date},{end_date},{report_type}")
	public void generateReportxls(HttpServletResponse response,@PathVariable String start_date,@PathVariable String end_date,@PathVariable String report_type) throws IOException, SQLException, JRException {
	try {	LOGGER.info("Jasper Report api has been called !!! Start Of Method generateReport");
		System.out.println(start_date);
		System.out.println(end_date);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("start_date",start_date);
		parameters.put("end_date",end_date);
		System.out.println("dummy1");
		Connection connection = jdbcTemplate.getDataSource().getConnection();
		File file = ResourceUtils.getFile("classpath:totalTickets.jrxml");
		System.out.println("dummy2");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
		JRCsvExporter exporter = new JRCsvExporter();
		System.out.println("dummy3");
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		System.out.println("dummy4");
		//exporter.setExporterOutput(
		//  new SimpleOutputStreamExporterOutput("employeeReport.pdf"));
		
		exporter.setExporterOutput(
		  new SimpleWriterExporterOutput("TotalTicketsReport.csv"));
		System.out.println("dummy5");
	
		exporter.exportReport();
		System.out.println("dummy6");
	}
	catch (Exception e) {
		LOGGER.error("Error While Uploading the file" + e.getMessage());
	}
 }*/
	
@GetMapping("/jasper/reportCSV/{start_date},{end_date},{report_type}")
	public void generateReportCSV(HttpServletResponse response,@PathVariable String start_date,@PathVariable String end_date,@PathVariable String report_type) throws IOException, SQLException, JRException {
	try {	LOGGER.info("Jasper Report api has been called !!! Start Of Method generateReport");
		System.out.println(start_date);
		System.out.println(end_date);
		response.setContentType("application/x-download");
		
		if(report_type.contains("totalTickets")) {
			
			//response.setHeader("Content-Disposition", String.format("attachment;filename=\"Totalticketreport.xls\""));}
		response.setHeader("Content-Disposition", String.format("attachment;filename=\"Totalticketreport.csv\""));}
		if(report_type.contains("QfixWiseSummary")) {
			response.setHeader("Content-Disposition", String.format("attachment;filename=\"QfixwiseSummaryreport.csv\""));}
		if(report_type.contains("DailyReport")) {
			response.setHeader("Content-Disposition", String.format("attachment;filename=\"Dailyreport.csv\""));}
		if(report_type.contains("StatuswiseAssetReport")) {
			response.setHeader("Content-Disposition", String.format("attachment;filename=\"StatuswiseAssetReportreport.csv\""));}
		if(report_type.contains("LocationWiseAssetReportTickets")) {
			response.setHeader("Content-Disposition", String.format("attachment;filename=\"LoactionwiseAssetreport.csv\""));}
		if(report_type.contains("csatRating")) {
			response.setHeader("Content-Disposition", String.format("attachment;filename=\"csatratingReport.csv\""));}
		OutputStream out =response.getOutputStream();
		reportService.exportReportCsv(start_date,end_date,report_type,out);
	}
	catch (Exception e) {
		LOGGER.error("Error While Uploading the file" + e.getMessage());
	}
}
@GetMapping("/jasper/reportXLS/{start_date},{end_date},{report_type}")
public void generateReportXLSss(HttpServletResponse response,@PathVariable String start_date,@PathVariable String end_date,@PathVariable String report_type) throws IOException, SQLException, JRException {
try {	LOGGER.info("Jasper Report api has been called !!! Start Of Method generateReport XLS");
	System.out.println(start_date);
	System.out.println(end_date);
	response.setContentType("application/x-download");
	
	if(report_type.contains("totalTickets")) {
		
		//response.setHeader("Content-Disposition", String.format("attachment;filename=\"Totalticketreport.xls\""));}
	response.setHeader("Content-Disposition", String.format("attachment;filename=\"Totalticketreport.xls\""));}
	if(report_type.contains("QfixWiseSummary")) {
		response.setHeader("Content-Disposition", String.format("attachment;filename=\"QfixwiseSummaryreport.csv\""));}
	if(report_type.contains("DailyReport")) {
		response.setHeader("Content-Disposition", String.format("attachment;filename=\"Dailyreport.csv\""));}
	if(report_type.contains("StatuswiseAssetReport")) {
		response.setHeader("Content-Disposition", String.format("attachment;filename=\"StatuswiseAssetReportreport.csv\""));}
	if(report_type.contains("LocationWiseAssetReportTickets")) {
		response.setHeader("Content-Disposition", String.format("attachment;filename=\"LoactionwiseAssetreport.csv\""));}
	if(report_type.contains("csatRating")) {
		response.setHeader("Content-Disposition", String.format("attachment;filename=\"csatratingReport.csv\""));}
	OutputStream out =response.getOutputStream();
	reportService.exportReportXls(start_date,end_date,report_type,out);
}
catch (Exception e) {
	LOGGER.error("Error While Uploading the file" + e.getMessage());
}
}
}

