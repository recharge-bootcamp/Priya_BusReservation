package main.java.com.brwa.model;

public class PassengerDet {
	
	private Integer pID;
	
	private Integer pMobileNo;
	private String pEmailID;
	
	public PassengerDet(){
		
	}

	public Integer getpID() {
		return pID;
	}

	public void setpID(Integer pID) {
		this.pID = pID;
	}

	
	public Integer getpMobileNo() {
		return pMobileNo;
	}

	public void setpMobileNo(Integer pMobileNo) {
		this.pMobileNo = pMobileNo;
	}

	public String getpEmailID() {
		return pEmailID;
	}

	public void setpEmailID(String pEmailID) {
		this.pEmailID = pEmailID;
	}

	public PassengerDet(Integer pID,  Integer pMobileNo,
			String pEmailID) {
		super();
		this.pID = pID;
		this.pMobileNo = pMobileNo;
		this.pEmailID = pEmailID;
	}

	

}
