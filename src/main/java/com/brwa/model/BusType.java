package main.java.com.brwa.model;

public class BusType {
	
	private Integer busTypeID;
	private String busTypeName;
	public BusType(){
		
	}
	
	public Integer getBusTypeID() {
		return busTypeID;
	}


	public void setBusTypeID(Integer busTypeID) {
		this.busTypeID = busTypeID;
	}


	public String getBusTypeName() {
		return busTypeName;
	}


	public void setBusTypeName(String busTypeName) {
		this.busTypeName = busTypeName;
	}


	public BusType(Integer busTypeID, String busTypeName) {
		super();
		this.busTypeID = busTypeID;
		this.busTypeName = busTypeName;
	}
	
	
	

}
