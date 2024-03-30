package com.Aforesight.Api.response;

import java.util.List;

import com.Aforesight.Api.entity.Agent_msg_dtls;

public class TicketResponse {
	private String Message;
	private String Status;
	private List ticketDetails;
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public List getTicketDetails() {
		return ticketDetails;
	}
	public void setTicketDetails(List ticketDetails) {
		this.ticketDetails = ticketDetails;
	}
	public TicketResponse(String message, String status, List ticketDetails) {
		super();
		Message = message;
		Status = status;
		this.ticketDetails = ticketDetails;
	}
	
}
