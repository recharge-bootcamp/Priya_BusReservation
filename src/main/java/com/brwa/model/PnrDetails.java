package main.java.com.brwa.model;


public class PnrDetails {
	
	private int ticketID;
	private BusDetails tBusID;
	private String tSeat;
	private Integer tPhone;
	private String tEmail;
	private Integer tFare;
	private String tStatus;
	private String tNo;
	private Person pDet;
	
	
	
	public PnrDetails(){
		
	}


	public int getTicketID() {
		return ticketID;
	}


	public void setTicketID(int ticketID) {
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


	public Integer gettPhone() {
		return tPhone;
	}


	public void settPhone(Integer tPhone) {
		this.tPhone = tPhone;
	}


	public String gettEmail() {
		return tEmail;
	}


	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}


	public Integer gettFare() {
		return tFare;
	}


	public void settFare(Integer tFare) {
		this.tFare = tFare;
	}


	public String gettStatus() {
		return tStatus;
	}


	public void settStatus(String tStatus) {
		this.tStatus = tStatus;
	}
	
	public String gettNo() {
		return tNo;
	}


	public void settNo(String tNo) {
		this.tNo = tNo;
	}

	public Person getpDet() {
		return pDet;
	}


	public void setpDet(Person pDet) {
		this.pDet = pDet;
	}


	public PnrDetails(int ticketID, BusDetails tBusID, String tSeat, Integer tPhone, String tEmail, Integer tFare,
			String tStatus, String tNo, Person pDet) {
		super();
		this.ticketID = ticketID;
		this.tBusID = tBusID;
		this.tSeat = tSeat;
		this.tPhone = tPhone;
		this.tEmail = tEmail;
		this.tFare = tFare;
		this.tStatus = tStatus;
		this.tNo = tNo;
		this.pDet = pDet;
	}


	
	
	


}
