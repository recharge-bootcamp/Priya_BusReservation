package main.java.com.brwa.model;

import java.util.Date;

public class BusDetails {
	
	private Integer busID;
	private BusType bBusTypeID;
	private Integer fare;
	private Date destTime;
	private Date arrivalTime;
	private City originID;
	private City destID;
	private String busName;
	private Integer totSeats;
	private Integer availSeats;
	private Integer bookedSeats;
	
	public BusDetails(){
		
	}

	public Integer getBusID() {
		return busID;
	}

	public void setBusID(Integer busID) {
		this.busID = busID;
	}

	public BusType getbBusTypeID() {
		return bBusTypeID;
	}

	public void setbBusTypeID(BusType bBusTypeID) {
		this.bBusTypeID = bBusTypeID;
	}

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	public Date getDestTime() {
		return destTime;
	}

	public void setDestTime(Date destTime) {
		this.destTime = destTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public City getOriginID() {
		return originID;
	}

	public void setOriginID(City originID) {
		this.originID = originID;
	}

	public City getDestID() {
		return destID;
	}

	public void setDestID(City destID) {
		this.destID = destID;
	}
	
	

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}
	

	public Integer getTotSeats() {
		return totSeats;
	}

	public void setTotSeats(Integer totSeats) {
		this.totSeats = totSeats;
	}

	public Integer getAvailSeats() {
		return availSeats;
	}

	public void setAvailSeats(Integer availSeats) {
		this.availSeats = availSeats;
	}

	public Integer getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(Integer bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public BusDetails(Integer busID, BusType bBusTypeID, Integer fare, Date destTime, Date arrivalTime, City originID,
			City destID, String busName, Integer totSeats, Integer availSeats, Integer bookedSeats) {
		super();
		this.busID = busID;
		this.bBusTypeID = bBusTypeID;
		this.fare = fare;
		this.destTime = destTime;
		this.arrivalTime = arrivalTime;
		this.originID = originID;
		this.destID = destID;
		this.busName = busName;
		this.totSeats = totSeats;
		this.availSeats = availSeats;
		this.bookedSeats = bookedSeats;
	}

	
	
	

}
