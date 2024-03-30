package itsm_connection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.kenai.jffi.Array;

public class itsmToDatabase {
	
	String username ="";
	String password ="";
	String dbconfStr="";
	String itsmUrl="";
	String Apikey="";
	String requesterID="";
	String requesterName="";
	String technicianname_ticetRaise="";
	String technicianname_ticetOpen="";
	String impact="";
	String resolution1="";
	String site="";
	String priority="";
	String Group="";
	String AssignTo="";
	Cal2Itsm itsmcall = new Cal2Itsm();
	problem problem = new problem();
	
	status status=new status();
	 resolution resolution=new resolution();
	 requester requester=new requester();
	Input_data input_data1 = new Input_data();

	Properties properties = new Properties();
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	String user_id=System.getenv("username");
	itsmToDatabase(){
		loadPropertiesFile();
		this.username=properties.getProperty("dbuser");
		this.password=properties.getProperty("dbpassword");
		this.dbconfStr=properties.getProperty("DB_CONF_STRING");
		this.itsmUrl=properties.getProperty("itsmUrl");
		this.Apikey=properties.getProperty("itsmApiKey");
		this.requesterID=properties.getProperty("requesterID");
		this.requesterName=properties.getProperty("requesterName");
		this.technicianname_ticetRaise=technicianname_ticetRaise;
		this.technicianname_ticetOpen=properties.getProperty("technicianname_ticetOpen");
		this. technicianname_ticetRaise=properties.getProperty("technicianname_ticetRaise");
		this.impact=properties.getProperty("impact");
		this.resolution1=properties.getProperty("resolution");
		this.site=properties.getProperty("site");
		this.priority=properties.getProperty("priority");
		this.Group=properties.getProperty("Group");
		this.AssignTo=properties.getProperty("AssignTo");
		if (dbcon==null)
		{
				dbcon = connect_db();}
	}
	
	

	public  Connection dbcon = null;//connect_db();
	public static Logger log = LogManager.getLogger(itsmToDatabase.class.getName());

	private  void loadPropertiesFile(){
	    InputStream iStream= getClass().getClassLoader().getResourceAsStream("config.properties");
	    		try {
	       if(iStream!=null) {           
	    	   
	     
			properties.load(iStream);
	       } else {throw new FileNotFoundException("Property file Not found");}
	      } catch (IOException e) {
	       // TODO Auto-generated catch block
	       e.printStackTrace();
	      }finally {
	        try {
	          if(iStream != null){
	            iStream.close();
	          }
	        } catch (IOException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	        }
	      }
	    }
	
	public  Connection connect_db() {

		Connection con = null;
		
		try {
			
		    System.out.println("username is "+username);
			//System.out.println("password is "+password);
			System.out.println("str is"+dbconfStr);
			con = DriverManager.getConnection(dbconfStr, username, password);
		   log.info("Database connection estblished");
		  
		} catch (Exception e) {
			log.fatal("exception is" + e);

		}
		return con;

	}
	public void update(String ticket_id,Integer problemid) {
		try {
			log.info("ticket_id" +ticket_id); 
			log.info("request_id" +problemid); 
		java.sql.Statement stmt1 = dbcon.createStatement();
		log.info(" In update function");
		String update ="update vf_agent_mgs_dtls set itsm_reqid=? where msg_ticket_id=?";
		PreparedStatement p=dbcon.prepareStatement(update);
		p.setLong(1,problemid);
		p.setString(2,ticket_id);
		p.execute();
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void updatemsgstatus(String ticket_id,String status) {
			try {
				log.info(" updating status of ticket_id" +ticket_id); 
			String status12=status+"f";	
			java.sql.Statement stmt1 = dbcon.createStatement();
			log.info(" In update function");
			String update ="update vf_agent_mgs_dtls set msg_status_YN =? where msg_ticket_id=?";
			PreparedStatement p=dbcon.prepareStatement(update);
			p.setString(1,status12);
			p.setString(2,ticket_id);
	
			p.execute();
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch
				e.printStackTrace();
			}
		
		
	}
	public String raise_itsmreq_id(String ticket_id) {
		String raise_itsmreq="";
		return raise_itsmreq;
		
	}
	public ArrayList<String> get_itsmreq( ) {
		
		ArrayList<String> itsm_id=new ArrayList<String>();	
		request request=new request();
		String response ="";
		String jsonstr="";
		int ticketid = 0;
			
			try {
				java.sql.Statement stmt1 = dbcon.createStatement();
				log.info("connection done");
				ResultSet rs1 = stmt1.executeQuery("select * from vf_agent_mgs_dtls where itsm_reqid is null" );
				
				while (rs1.next()) {
					
					itsm_id.add(rs1.getString("itsm_reqid"));
					itsm_id.add(rs1.getString("msg_ticket_id"));
					itsm_id.add(rs1.getString("msg_status_YN"));
					itsm_id.add(rs1.getString("Msg_description"));
					itsm_id.add(rs1.getString("asset_id"));
					String Email=rs1.getString("outlook_email");
					
					ArrayList itsmlist=getUserAPI(Email);
				
					//String requesterID1=(String) itsmlist.get(1);
					//String requesterName1=(String) itsmlist.get(0);
					
					log.info("Email  is"+Email);
					log.info(requesterID);
					log.info("dummy1");
				String subject=rs1.getString("Msg_description")+" Ticket no:"+rs1.getString("msg_ticket_id");	
			request.setSubject(subject);
			log.info("Dummy2");
			request.setDescription(rs1.getString("Msg_description"));
			String requesterID="4";
			String requester87="{\"id\":\""+requesterID+"\",\"name\":\""+requesterName+"\"}";
			request.setRequester(requester87);
			request.setResolution(resolution.setContent(""));
			String status1="";
			status1="{\"name\":\"resolved\"}";
			log.info( status1);
			request.setStatus(status1);
			
					String Msg_ticket_id=rs1.getString("msg_ticket_id");
					
					input_data1.setRequest(request);
					jsonstr = new Gson().toJson(input_data1);
					
					response = itsmcall.postitemreq(itsmUrl,jsonstr,Apikey);
				     Integer problemid =itsmcall.onResponse1(response);
				     
					update(Msg_ticket_id,problemid);
					setAssignTo(problemid);
					
				rs1.close();	
			}}

			catch (Exception e) {
				log.error("did not get itsm_reqid");	
			}
			return itsm_id;
		}
	
public ArrayList<String> update_itsmreq( ) {
		log.info("in update method");
		ArrayList<String> itsm_id=new ArrayList<String>();	
		request request=new request();
		String response ="";
		String jsonstr="";
		int ticketid = 0;
			
			try {
				java.sql.Statement stmt1 = dbcon.createStatement();
				log.info("connection done");
				ResultSet rs1 = stmt1.executeQuery("select * from vf_agent_mgs_dtls where itsm_reqid is not null and (msg_status_YN ='C' or msg_status_YN='R' or msg_status_YN ='O' )" );
				log.info("in update method 1");
				while (rs1.next()) {
					
					itsm_id.add(rs1.getString("itsm_reqid"));
					itsm_id.add(rs1.getString("msg_ticket_id"));
					itsm_id.add(rs1.getString("msg_status_YN"));
					itsm_id.add(rs1.getString("Msg_description"));
					itsm_id.add(rs1.getString("asset_id"));
					String Email=rs1.getString("outlook_email");
					
					//ArrayList itsmlist=getUserAPI(Email);
				
					//String requesterID1=(String) itsmlist.get(1);
					//String requesterName1=(String) itsmlist.get(0);
				
					log.info("Email  is"+Email);
					log.info("in update method 2");	
					String subject1=rs1.getString("Msg_description")
							+" Ticket no:"+rs1.getString("msg_ticket_id");	
					log.info(subject1);
			//arequest.setRequest_id(rs1.getString("itsm_reqid"));		
			request.setSubject(subject1);
			
			request.setDescription(rs1.getString("Msg_description"));
			
			String requester871="{\"id\":\""+requesterID+"\",\"name\":\""+requesterName+"\"}";
			request.setRequester(requester871);
			
			request.setResolution(resolution.setContent(""));
			
			String status1="";
			String Staus2=rs1.getString("msg_status_YN");
			
			switch(Staus2) {
	       
	        case "C":
	        {
	        	 status1="{\"name\":\"Closed\"}";
	        	 break;
	        }
	        case "R":
	        {
	        	 status1="{\"name\":\"Resolved\"}";
	        	 break;
	        }
	        case "O":
	        {
	        	 status1="{\"name\":\"Open\"}";
	        	 break;
	        }
	        default:{
	        	status1="{\"name\":\"Closed\"}";	
	        	 break;
	        }
	        }
			
			log.info( status1);
			request.setStatus(status1);
			
					
					String Msg_ticket_id=rs1.getString("msg_ticket_id");
					
					input_data1.setRequest(request);
					jsonstr = new Gson().toJson(input_data1);
					String request_id=(rs1.getString("itsm_reqid"));
					String url=itsmUrl+"/"+request_id;
					log.info(url);
					response = itsmcall.Uppostitemreq(url,jsonstr,Apikey);
				    // int problemid =itsmcall.onResponse1(response);
				 	log.info("in update method 3");
					
					log.info( itsm_id);
					updatemsgstatus(Msg_ticket_id,Staus2);
					this.wait(10000);
			
					}
				rs1.close();	
			}

			catch (Exception e) {
				log.error(e);	
			}
			
			return itsm_id;
		}

public ArrayList<String> getUserAPI(String Email) {
	ArrayList<String> itsmlist=new ArrayList<String>();

	try {
		java.sql.Statement stmt1 = dbcon.createStatement();
		log.info("connection done");
		ResultSet rs1 = stmt1.executeQuery("select * from Users where Email_ID="+"'"+Email+"'" );
		
		while (rs1.next()) {
			
	
			itsmlist.add(rs1.getString("username"));
			itsmlist.add(rs1.getString("ItsmUserId"));
		}}
		catch (Exception e) {
			log.error("did not get itsm_API");	
		}
	
	return itsmlist;
	
}
public void setAssignTo(Integer problemid) throws SQLException {
	
	request request=new request();
	log.info("in assign to function");
	try {
	/*	java.sql.Statement stmt1 = dbcon.createStatement();
		log.info("connection done");
		ResultSet rs1 = stmt1.executeQuery("select * from vf_agent_mgs_dtls where ItsmassignTo is null" );
while (rs1.next()) {
			
			String itsm_no=rs1.getString("itsm_reqid");
			String usermail=rs1.getString("outlook_email");*/
	log.info("in assign to funtion");
	String Groupname="{\"name\":\""+Group+"\"}";
	String technicianname="{\"name\":\""+AssignTo+"\"}";
	String response1 ="";
	String jsonstr1="";
	request.setGroup(Groupname);
	request.setTechnician(technicianname);
	String url1=itsmUrl+"/"+problemid+"/assign";
	log.info(url1);
	input_data1.setRequest(request);
	jsonstr1 = new Gson().toJson(input_data1);
	//ArrayList itsmlist=getUserAPI(usermail);
	//String Api=(String) itsmlist.get(0);
	
		itsmcall.AssignToreq(url1,jsonstr1,Apikey);
		//updateassignTo(itsm_no,AssignTo);
	//}
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
public void updateassignTo(String itsm_no,String assign) {
	try {
		log.info(" updating assign of ticket_id" +itsm_no); 

	java.sql.Statement stmt1 = dbcon.createStatement();
	log.info(" In update function");
	String update ="update vf_agent_mgs_dtls set ItsmassignTo =? where itsm_reqid=?";
	PreparedStatement p=dbcon.prepareStatement(update);
	p.setString(1,assign);
	p.setString(2,itsm_no);

	p.execute();
	
	
	} catch (SQLException e) {
		// TODO Auto-generated catch
		e.printStackTrace();
	}
	

}

}


