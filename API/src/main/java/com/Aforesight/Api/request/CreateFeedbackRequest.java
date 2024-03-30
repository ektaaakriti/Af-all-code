package com.Aforesight.Api.request;

import java.util.Date;

public class CreateFeedbackRequest {
	public  String User_ID;
	public long msg_ticket_Id;
   // public String Msg_id;
    public String Msg_description;
    public String msg_status_YN;
   // public String asset_Id;
   // public String ticket_Id;
   // public Date Msg_datetime;
  //  public String software_install_choice;
   // public String asset_id;
   // public String username;
   // public String password;
    public String outlook_email;
   // public Date startdate;
   // public Date enddate;
    public Date feedback_datetime;
    public String Csat_rating;
	public String getCsat_rating() {
		return Csat_rating;
	}
	public void setCsat_rating(String csat_rating) {
		Csat_rating = csat_rating;
	}
	public String getUser_ID() {
		return User_ID;
	}
	public void setUser_ID(String user_ID) {
		User_ID = user_ID;
	}
	public long getMsg_ticket_Id() {
		return msg_ticket_Id;
	}
	public void setMsg_ticket_Id(long msg_ticket_Id) {
		this.msg_ticket_Id = msg_ticket_Id;
	}
	public String getMsg_description() {
		return Msg_description;
	}
	public void setMsg_description(String msg_description) {
		Msg_description = msg_description;
	}
	public String getMsg_status_YN() {
		return msg_status_YN;
	}
	public void setMsg_status_YN(String msg_status_YN) {
		this.msg_status_YN = msg_status_YN;
	}
	public String getOutlook_email() {
		return outlook_email;
	}
	public void setOutlook_email(String outlook_email) {
		this.outlook_email = outlook_email;
	}
	public Date getFeedback_datetime() {
		return feedback_datetime;
	}
	public void setFeedback_datetime(Date feedback_datetime) {
		this.feedback_datetime = feedback_datetime;
	}
}
