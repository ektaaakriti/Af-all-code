package com.Aforesight.Api.payload;

public class Report_of_Ticket_payload {
	public Long Total_Tickets;
	public Long Tickets_resolved;
	public Long Tickets_Failed;
	 public Long manually_resolvable_tickets;
	 public Long Auto_resolvable_tickets;
	 public Long per_tickets_auto_resolved;
	 public Long Automation_success_rate;
	 public Long no_of_machines_deployed;
	 public Long no_of_machine_tickets_via_af;
	 public Long machines_tickets_not_raised_via_af;
	 public Long machines_ticket_not_raised;
	 public Long tickets_via_af;
	 public Long tickets_on_itsm_tool_directly;
	 public Long per_tickets_raised_via_af;
	 
	public Long getManually_resolvable_tickets() {
		return manually_resolvable_tickets;
	}
	public void setManually_resolvable_tickets(Long manually_resolvable_tickets) {
		this.manually_resolvable_tickets = manually_resolvable_tickets;
	}
	public Long getAuto_resolvable_tickets() {
		return Auto_resolvable_tickets;
	}
	public void setAuto_resolvable_tickets(Long auto_resolvable_tickets) {
		Auto_resolvable_tickets = auto_resolvable_tickets;
	}
	public Long getPer_tickets_auto_resolved() {
		return per_tickets_auto_resolved;
	}
	public void setPer_tickets_auto_resolved(Long per_tickets_auto_resolved) {
		this.per_tickets_auto_resolved = per_tickets_auto_resolved;
	}
	public Long getAutomation_success_rate() {
		return Automation_success_rate;
	}
	public void setAutomation_success_rate(Long automation_success_rate) {
		Automation_success_rate = automation_success_rate;
	}
	public Long getNo_of_machines_deployed() {
		return no_of_machines_deployed;
	}
	public void setNo_of_machines_deployed(Long no_of_machines_deployed) {
		this.no_of_machines_deployed = no_of_machines_deployed;
	}
	public Long getNo_of_machine_tickets_via_af() {
		return no_of_machine_tickets_via_af;
	}
	public void setNo_of_machine_tickets_via_af(Long no_of_machine_tickets_via_af) {
		this.no_of_machine_tickets_via_af = no_of_machine_tickets_via_af;
	}
	public Long getMachines_tickets_not_raised_via_af() {
		return machines_tickets_not_raised_via_af;
	}
	public void setMachines_tickets_not_raised_via_af(Long machines_tickets_not_raised_via_af) {
		this.machines_tickets_not_raised_via_af = machines_tickets_not_raised_via_af;
	}
	public Long getMachines_ticket_not_raised() {
		return machines_ticket_not_raised;
	}
	public void setMachines_ticket_not_raised(Long machines_ticket_not_raised) {
		this.machines_ticket_not_raised = machines_ticket_not_raised;
	}
	public Long getTickets_via_af() {
		return tickets_via_af;
	}
	public void setTickets_via_af(Long tickets_via_af) {
		this.tickets_via_af = tickets_via_af;
	}
	public Long getTickets_on_itsm_tool_directly() {
		return tickets_on_itsm_tool_directly;
	}
	public void setTickets_on_itsm_tool_directly(Long tickets_on_itsm_tool_directly) {
		this.tickets_on_itsm_tool_directly = tickets_on_itsm_tool_directly;
	}
	public Long getPer_tickets_raised_via_af() {
		return per_tickets_raised_via_af;
	}
	public void setPer_tickets_raised_via_af(Long per_tickets_raised_via_af) {
		this.per_tickets_raised_via_af = per_tickets_raised_via_af;
	}
	public Long getTotal_Tickets() {
		return Total_Tickets;
	}
	public void setTotal_Tickets(Long total_Tickets) {
		Total_Tickets = total_Tickets;
	}
	public Long getTickets_resolved() {
		return Tickets_resolved;
	}
	public void setTickets_resolved(Long tickets_resolved) {
		Tickets_resolved = tickets_resolved;
	}
	public Long getTickets_Failed() {
		return Tickets_Failed;
	}
	public void setTickets_Failed(Long tickets_Failed) {
		Tickets_Failed = tickets_Failed;
	}

}
