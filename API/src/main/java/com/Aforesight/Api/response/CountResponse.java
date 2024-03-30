package com.Aforesight.Api.response;

	import java.util.List;

	public class CountResponse {
		String Message;
		List loc;
		String Status;
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
		
		public List getLoc() {
			return loc;
		}
		public CountResponse(String message, String status) {
			super();
			Message = message;
			Status = status;
		}
		public CountResponse(String message, List loc, String status) {
			super();
			Message = message;
			this.loc = loc;
			Status = status;
		}
		public void setLoc(List loc) {
			this.loc = loc;
		}
		public String getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			Status = status;
		}
		
		

	}


