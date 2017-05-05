package main.java.com.brwa.model;

import java.util.Date;

public class Reservation {
	
	private Integer ticketID;
	private BusDetails tBusID;
	private String tSeat;
	private PassengerDet tPassID;
	private Date tDate;
	
	
	public Reservation(){
		
	}


	public Integer getTicketID() {
		return ticketID;
	}


	public void setTicketID(Integer ticketID) {
		this.ticketID = ticketID;
	}


	public BusDetails gettBusID() {
		return tBusID;
	}


	public void settBusID(BusDetails tBusID) {
		this.tBusID = tBusID;
	}


	public String gettSeat() {
		return tSeat;
	}


	public void settSeat(String tSeat) {
		this.tSeat = tSeat;
	}


	public PassengerDet gettPassID() {
		return tPassID;
	}


	public void settPassID(PassengerDet tPassID) {
		this.tPassID = tPassID;
	}


	public Date gettDate() {
		return tDate;
	}


	public void settDate(Date tDate) {
		this.tDate = tDate;
	}


	public Reservation(Integer ticketID, BusDetails tBusID, String tSeat, PassengerDet tPassID, Date tDate) {
		super();
		this.ticketID = ticketID;
		this.tBusID = tBusID;
		this.tSeat = tSeat;
		this.tPassID = tPassID;
		this.tDate = tDate;
	}

	

}
