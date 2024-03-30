package com.Aforesight.Api.request;

import java.util.Date;

public class TicketDatewiseRequest {
	 public String outlook_email;
	    public Date startdate;
	    public Date enddate;
		public String getOutlook_email() {
			return outlook_email;
		}
		public void setOutlook_email(String outlook_email) {
			this.outlook_email = outlook_email;
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
}
