package com.Aforesight.Api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sun.mail.util.MailSSLSocketFactory;
@Component
public class SendMail {
	
  
   static EncryptionDecryptionClass enc=new EncryptionDecryptionClass();
		static Properties props = new Properties();
		
	    public static void emailToUser( String Email,Long ticket_id,String Status,String msg_description,String from,String password,String host, String port1,String feedbackurl,String username)  {
	    	 System.out.println("In email to user");
	    	
	       String Subject="";
	        String to = Email;
	       // System.out.println("from email is"+from);
	        System.out.println("to email is user"+to);
	        System.out.println("to email is host"+host);
	        System.out.println("to email is port"+port1);
	       System.out.println("to email is"+from);
	        System.out.println("to email is password"+password);
	       
	     
	        props.put("mail.transport.protocol", "smtp");
	        props.put("mail.smtp.host",host); // 
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.debug", "true"); 
	        props.put("mail.smtp.starttls.enable", "false");
	        props.put("mail.smtp.port", "port");
	        props.put("mail.smtp.socketFactory.port", "port");
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.socketFactory.fallback", "true");

	        MailSSLSocketFactory sf = null;
	       
	        try {
	        	// SSLSocketFactory sf = new SSLSocketFactory();
	            sf = new MailSSLSocketFactory();
	        } catch (GeneralSecurityException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	            
	        }
	        sf.setTrustAllHosts(true);
	        props.put("mail.smtp.ssl.socketFactory", sf);

	        
	       /* mailSender.setHost(env.getProperty("spring.mail.host"));
	        mailSender.setPort(Integer.valueOf(env.getProperty("spring.mail.port")));
	        mailSender.setUsername(env.getProperty("spring.mail.username"));
	        mailSender.setPassword(env.getProperty("spring.mail.password"));*/
	        switch(Status) {
	        case "C":
	         {
	        	 Status="Ticket is closed";
	        	 Subject="Confirmation: Your Ticket Is Closed";
	        	break;
	         }
	        case "Y":
	         {
	        	 Status="In progress";
	        	 Subject="Confirmation: Your Ticket Is in Process";

	        	break;
	         }
	        case "O":
	        {
	        	 Status="ticket is not resolved";
	        	 Subject="Confirmation: Your Ticket Is not resolved";

	        	 break;
	        }
	        case "N":
	        {
	        	Subject="Confirmation: Your Ticket Is Resolved";
	        	Status="ticket is resolved.\n\r Kindly provide the feedback on link below: \n "+ feedbackurl+(to);
	        	 break;
	        }
	        default:{
	        	 Status="ticketis reopened again";
	        	 break;
	        }
	        }
	        // Get the Session object.// and pass username and password
	        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

	            protected PasswordAuthentication getPasswordAuthentication() {

	                return new PasswordAuthentication(from,password);

	            }

	        });

	        // Used to debug SMTP issues
	        session.setDebug(true);

	        try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));

	            // Set To: header field of the header.
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	            // Set Subject: header field
	            message.setSubject(Subject);

	            // Now set the actual message
	            message.setText("Dear " +username+", \r \nThank you for generating a new ticket via Aforesight. Your ticket details are as follows"
	            		+ "\r \nTicket Id: "+ticket_id
	            		+ "\r \nIssue: "+msg_description
	            		+"\r \nStatus: "+Status
	            		+"\r \nRegards"
	            		+"\r Aforesight");

	           
	            // Send message
	            Transport.send(message);
	            System.out.println("Sent message successfully....");
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	        }

	    }

	}


