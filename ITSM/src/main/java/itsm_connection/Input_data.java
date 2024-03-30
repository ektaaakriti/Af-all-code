package itsm_connection;

public 	class Input_data{
	problem problem ;
	itsm_connection.request request;
	

	public itsm_connection.request getRequest() {
		return request;
	}

	public void setRequest(itsm_connection.request request2) {
		this.request = request2;
	}

	public problem getProblem() {
		return problem;
	}

	public void setProblem(problem problem) {
		this.problem = problem;
	}
	}
