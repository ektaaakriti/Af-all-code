//Purpose:This class is used to create entity for the database table vf_agent_mgs_dtl,
//which stores all data of the ticket.
//Developed by:Author Arthvedika dev team
//Date:26/01/2022
package com.Aforesight.Api.entity;
import lombok.Data;

import javax.persistence.*;

import org.springframework.context.annotation.Role;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "vf_agent_mgs_dtls")
        
public class Agent_msg_dtls {

    @Id
    @GeneratedValue
    (strategy = GenerationType.AUTO)
	private Long msg_ticket_Id;
    private String Csat_rating;
    public String getCsat_rating() {
		return Csat_rating;
	}
	public void setCsat_rating(String csat_rating) {
		Csat_rating = csat_rating;
	}
	private String Msg_id;
    private String Msg_description;
    private String msg_status_YN;
    private String asset_Id;
    private String ticket_Id;
    private Date msg_enqueue_datetime;
    /*private Date startdate;
    private Date enddate;
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
	}*/
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
	private Date msg_deueue_datetime;
    private Date Msg_datetime;
    private String software_install_choice;
    @Column(name = "asset_id", insertable = false, updatable = false)
    private String asset_id;
    private String itsm_reqid;
    private String username;
    private String password;
    private String outlook_email;
    private Date feedback_datetime;
	public Date getFeedback_datetime() {
		return feedback_datetime;
	}
	public void setFeedback_datetime(Date feedback_datetime) {
		this.feedback_datetime = feedback_datetime;
	}
	public String getItsm_reqid() {
		return itsm_reqid;
	}
	public void setItsm_reqid(String string) {
		this.itsm_reqid = string;
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
	public Date getMsg_enqueue_datetime() {
		return msg_enqueue_datetime;
	}
	public void setMsg_enqueue_datetime(Date msg_enqueue_datetime) {
		this.msg_enqueue_datetime = msg_enqueue_datetime;
	}
	public Date getMsg_deueue_datetime() {
		return msg_deueue_datetime;
	}
	public void setMsg_deueue_datetime(Date msg_deueue_datetime) {
		this.msg_deueue_datetime = msg_deueue_datetime;
	}
	public Date getMsg_datetime() {
		return Msg_datetime;
	}
	public void setMsg_datetime(Date msg_datetime) {
		Msg_datetime = msg_datetime;
	}
	public Long getMsg_ticket_Id() {
		return msg_ticket_Id;
	}
	public void setMsg_ticket_Id(Long msg_ticket_Id) {
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
	private String user_id;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
   


}
