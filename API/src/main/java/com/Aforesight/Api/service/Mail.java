package com.Aforesight.Api.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Transactional
@Service
public class Mail {

	@Autowired
	private JavaMailSender javaMailSender;


	public void  emailToUser(String Email,Long ticket_id,String Status,String msg_description,String from,String password,String host, String port1,String feedbackurl,String username) throws Exception {
		System.out.println("Sending Email");
        String to = Email;
		 String Subject="";
		String senderName = "Arthavedika";
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
		String mailContent = "Dear " +username+", \r \nThank you for generating a new ticket via Aforesight. Your ticket details are as follows"
        		+ "\r \nTicket Id: "+ticket_id
        		+ "\r \nIssue: "+msg_description
        		+"\r \nStatus: "+Status
        		+"\r \nRegards"
        		+"\r Aforesight";
		// String verifyURL = siteURL + "/verify?code=" + newUser.getVerificationCode();
		// mailContent += "<h3><a href=\"" + verifyURL + "\">CLICK TO VERIFY </a></h3>";
		
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom("test1@arthavedika.com", senderName);
		helper.setTo(Email);
		helper.setSubject(Subject);
		helper.setText(mailContent, true);
		javaMailSender.send(message);
		System.out.println("Email Sent...");

	}



}

