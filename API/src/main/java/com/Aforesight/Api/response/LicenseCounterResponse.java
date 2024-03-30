package com.Aforesight.Api.response;

public class LicenseCounterResponse {
	String Authorised_by;
	String TotalLicense;
	String UsedLicense;
	String DateOfIssue;
	public String getAuthorised_by() {
		return Authorised_by;
	}
	public void setAuthorised_by(String authorised_by) {
		Authorised_by = authorised_by;
	}
	public String getTotalLicense() {
		return TotalLicense;
	}
	public void setTotalLicense(String totalLicense) {
		TotalLicense = totalLicense;
	}
	public String getUsedLicense() {
		return UsedLicense;
	}
	public void setUsedLicense(String usedLicense) {
		UsedLicense = usedLicense;
	}
	public String getDateOfIssue() {
		return DateOfIssue;
	}
	public void setDateOfIssue(String dateOfIssue) {
		DateOfIssue = dateOfIssue;
	}
	
	
	
	

}
