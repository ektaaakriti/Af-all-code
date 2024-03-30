//Developed by:Author Arthvedika dev team
//Date:26/01/2022
//Purpose:This is repository for entity class agent_msg_dtls.
package com.Aforesight.Api.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.Aforesight.Api.entity.*;
public interface qfixRepository<S> extends JpaRepository<Agent_msg_dtls, Long> {

	 @Query("select u From Agent_msg_dtls u WHERE u.outlook_email=?1")
	 public List<Agent_msg_dtls> getAllusers(String outlook_email);
	 @Query("select u From Agent_msg_dtls u WHERE u.outlook_email=?1 and (u.msg_status_YN='Y' or u.msg_status_YN='N')")
	 public List<Agent_msg_dtls> getAusersAllTicket(String outlook_email);
	// @Query("select u From Agent_msg_dtls u WHERE a.msg_status_YN='N' and mail_send is null ")
	 //public List<Agent_msg_dtls> statusN();
	 @Transactional
	 @Modifying(clearAutomatically = true) 
	@Query("update  Agent_msg_dtls a SET a.msg_status_YN=?1, a.feedback_datetime=?2, a.Csat_rating=?3 WHERE a.msg_ticket_Id=?4")
	void feedbackstatus(String msg_status_YN,Date date,String Csat_rating,long msg_ticket_Id);
	 
	 @Transactional
	 @Modifying(clearAutomatically = true) 
	 @Query("update  Agent_msg_dtls a SET a.software_install_choice=?1 WHERE a.msg_ticket_Id=?2")
	 void softwarechoice(String software_install_choice,long msg_ticket_Id);

	//void feedbackstatus(String msg_status_YN, long msg_ticket_Id);
	 @Query("select u From Agent_msg_dtls u WHERE u.msg_ticket_Id=?1")
	 public List<Agent_msg_dtls> getticketdetails(long msg_ticket_Id);
	 
	 @Query("select u.msg_ticket_Id From Agent_msg_dtls u WHERE u.msg_status_YN=?1 and u.Msg_id=?2  and u.software_install_choice=?3 and u.outlook_email=?4")
	 public Long getTicket_id(String msg_status_YN,String Msg_id,String software_install_choice, String email );
	 
	 @Query("select u From Agent_msg_dtls u WHERE (u.Msg_datetime BETWEEN :startdate AND :enddate)and u.outlook_email=:email")
	 public List<Agent_msg_dtls> getTicketDatewise(@Param("startdate")Date startdate,@Param("enddate")Date enddate,@Param("email") String email); 
	@Query ("SELECT COUNT(*) FROM Agent_msg_dtls a")
	public Long Total_Tickets();
	@Query ("SELECT COUNT(*) FROM Agent_msg_dtls a where a.msg_status_YN='Cf'")
	public Long Tickets_resolved();
	@Query ("SELECT COUNT(*) FROM Agent_msg_dtls a where a.msg_status_YN='Of'")
	public Long Tickets_failed();
	@Query ("SELECT a FROM Agent_msg_dtls a")
	//@Query("select a,DATE_FORMAT(a.Msg_datetime,'%d- %M- %Y  %H:%i:%s')AS Msg_datetime FROM Agent_msg_dtls a")
   // AS format_registration_datetime from vf_agent_mgs_dtls;
	//@Query("Select a.msg_ticket_id,a.msg_description,DATE_FORMAT(a.msg_datetime,’%d, %M %Y %e %H:%i:%s’) AS format_registration_datetime,a.msg_status_YN from Agent_msg_dtls a ")
	public List<?> All_Ticket_report();
	 @Query("select count(distinct a.user_id) from Agent_msg_dtls a")
	    Long maachineCountTickets();

	
	
}
