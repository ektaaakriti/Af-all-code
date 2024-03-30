package com.Aforesight.Api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Aforesight.Api.entity.Agent_msg_dtls;
import com.Aforesight.Api.entity.Report_of_Ticket;

public interface Report_of_Ticket_repository extends JpaRepository<Report_of_Ticket,Long> {
	 @Query("select u From Report_of_Ticket u ")
	 public List<Report_of_Ticket> Report();
}
