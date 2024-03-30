
//Developed by:Author Arthvedika dev team
//Date:26/01/2022
//Purpose:This is payload for agent_mgs_dtls.java.
package com.Aforesight.Api.payload;
import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

public class ticketcreation {
	public  String User_ID;
	public long msg_ticket_Id;
    public String Msg_id;
    public String Msg_description;
    public String msg_status_YN;
    public String asset_Id;
    public String ticket_Id;
    public Date Msg_datetime;
    public String software_install_choice;
    public String asset_id;
    public String username;
    public String password;
    public String outlook_email;
    public Date startdate;
    public Date enddate;
    public Date feedback_datetime;
    public Date getFeedback_datetime() {
		return feedback_datetime;
	}
	public void setFeedback_datetime(Date feedback_datetime) {
		this.feedback_datetime = feedback_datetime;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOutlook_email() {
		return outlook_email;
	}
	public void setOutlook_email(String outlook_email) {
		this.outlook_email = outlook_email;
	}
	public String getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(String asset_id) {
		this.asset_id = asset_id;
	}
	public String getSoftware_install_choice() {
		return software_install_choice;
	}
	public void setSoftware_install_choice(String software_install_choice) {
		this.software_install_choice = software_install_choice;
	}
	public Date getMsg_datetime() {
		return Msg_datetime;
	}
	public void setMsg_datetime(Date msg_datetime) {
		Msg_datetime = msg_datetime;
	}
	public Date msg_enqueue_datetime;
    public Date getMsg_enqueue_datetime() {
		return msg_enqueue_datetime;
	}
	public void setMsg_enqueue_datetime(Date msg_enqueue_datetime) {
		this.msg_enqueue_datetime = msg_enqueue_datetime;
	}
	public Date msg_deueue_datetime;
	public Date getMsg_deueue_datetime() {
		return msg_deueue_datetime;
	}
	public void setMsg_deueue_datetime(Date msg_deueue_datetime) {
		this.msg_deueue_datetime = msg_deueue_datetime;
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
	public String getMsg_id() {
		return Msg_id;
	}
	public void setMsg_id(String msg_id) {
		Msg_id = msg_id;
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
	public String getAsset_Id() {
		return asset_Id;
	}
	public void setAsset_Id(String asset_Id) {
		this.asset_Id = asset_Id;
	}
	public String getTicket_Id() {
		return ticket_Id;
	}
	public void setTicket_Id(String ticket_Id) {
		this.ticket_Id = ticket_Id;
	}
	
	
	

}
