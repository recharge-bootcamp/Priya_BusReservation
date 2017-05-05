package main.java.com.brwa.model;

public class Person {
	
	private Integer pID;	
	private String pName;
	private String pAge;
	private Integer pTID;
	private String pTitle;
	
	public Person(){
		
	}

	public Integer getpID() {
		return pID;
	}

	public void setpID(Integer pID) {
		this.pID = pID;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpAge() {
		return pAge;
	}

	public void setpAge(String pAge) {
		this.pAge = pAge;
	}

	public Integer getpTID() {
		return pTID;
	}

	public void setpTID(Integer pTID) {
		this.pTID = pTID;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public Person(Integer pID, String pName, String pAge, Integer pTID,
			String pTitle) {
		super();
		this.pID = pID;
		this.pName = pName;
		this.pAge = pAge;
		this.pTID = pTID;
		this.pTitle = pTitle;
	}

	

	
	
	

}
