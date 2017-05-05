package main.java.com.brwa.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import main.java.com.brwa.model.BusDetails;
import main.java.com.brwa.model.BusType;
import main.java.com.brwa.model.City;
import main.java.com.brwa.model.Person;
import main.java.com.brwa.model.PnrDetails;

import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	 /**
	 * 
	 */
	private static final long serialVersionUID = -726958146259925017L;
	
		private Integer cityOrigID;
		private Integer cityDestID;
		private Date onwardDate;
		private Integer busTypeID;
		private Person person = new Person();
		private PnrDetails pnrDet = new PnrDetails();
		private int pnrTicketID;
		private PnrDetails  ticketDetails = new PnrDetails();
		private Integer homeID;
		private BusDetails busDet = new BusDetails();
		private Integer noOfSeats;
		

		public Integer getNoOfSeats() {
			return noOfSeats;
		}

		public void setNoOfSeats(Integer noOfSeats) {
			this.noOfSeats = noOfSeats;
		}

		public BusDetails getBusDet() {
			return busDet;
		}

		public void setBusDet(BusDetails busDet) {
			this.busDet = busDet;
		}

		public Integer getHomeID() {
			return homeID;
		}

		public void setHomeID(Integer homeID) {
			this.homeID = homeID;
		}

		public Integer getPnrTicketID() {
			return pnrTicketID;
		}

		public void setPnrTicketID(Integer pnrTicketID) {
			this.pnrTicketID = pnrTicketID;
		}

		public PnrDetails getPnrDet() {
			return pnrDet;
		}

		public void setPnrDet(PnrDetails pnrDet) {
			this.pnrDet = pnrDet;
		}


		public PnrDetails getTicketDetails() {
			return ticketDetails;
		}

		public void setTicketDetails(PnrDetails ticketDetails) {
			this.ticketDetails = ticketDetails;
		}

		public Person getPerson() {
			return person;
		}

		public void setPerson(Person person) {
			this.person = person;
		}

		public Integer getBusTypeID() {
			return busTypeID;
		}

		public void setBusTypeID(Integer busTypeID) {
			this.busTypeID = busTypeID;
		}

		public Date getOnwardDate() {
			return onwardDate;
		}

		public void setOnwardDate(Date onwardDate) {
			this.onwardDate = onwardDate;
		}

		public Integer getCityOrigID() {
			return cityOrigID;
		}

		public void setCityOrigID(Integer cityOrigID) {
			this.cityOrigID = cityOrigID;
		}

		public Integer getCityDestID() {
			return cityDestID;
		}

		public void setCityDestID(Integer cityDestID) {
			this.cityDestID = cityDestID;
		}
		
		public Date getToday() {
			   Calendar c = Calendar.getInstance(); 
			   return c.getTime();
			}
	
		//Getting cities from City table
	public List<City> getCities() {
	      ResultSet rs = null;
	      PreparedStatement pst = null;
	      Connection con = getConnection();
	      String stm = "Select * from city order by city_name";
	      List<City> records = new ArrayList<City>();
	      
	      try {   
	         pst = con.prepareStatement(stm);
	         pst.execute();
	         rs = pst.getResultSet();

	         while(rs.next()) {
	            City city = new City();
	            city.setCityID(rs.getInt(1));
	            city.setCityName(rs.getString(2));
	            records.add(city);				
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return records;
	   }
	
	//Getting the bus types like A/C sleeper etc
	public List<BusType> getBTypes() {
	      ResultSet rs = null;
	      PreparedStatement pst = null;
	      Connection con = getConnection();
	      String stm = "Select * from bus_type order by bustype_name";
	      List<BusType> records = new ArrayList<BusType>();
	      
	      try {   
	         pst = con.prepareStatement(stm);
	         pst.execute();
	         rs = pst.getResultSet();

	         while(rs.next()) {
	        	 BusType bType = new BusType();
	        	 bType.setBusTypeID(rs.getInt(1));
	        	 bType.setBusTypeName(rs.getString(2));
	            records.add(bType);				
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return records;
	   }
	
	public void loadDetails(){
		
		//Vallidation is successful then load the bus listing page
		if(!validateDetails()){
			
			 ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		      try {
				context.redirect(context.getRequestContextPath() +  "/busListing.jsf" );
				RequestContext.getCurrentInstance().update("frmList:dtblBus");
		      }catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	}
	
	//Validation on search/home screen
	public boolean validateDetails() {

		boolean validate = false;
		
		//Checking if Origin city and Destination city are selected same
		if(cityOrigID == cityDestID){
			
			validate = true;
			
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Please select different City"));
			
		}
		
		//Checking if Date field is empty
		if(null == onwardDate ){
			
			validate = true;
			
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", ""
							+ "Date cannot be empty"));
			
		}
		
		if(null == noOfSeats){
			validate = true;
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Please enter no of seats"));
		}
		
		if(null != noOfSeats && noOfSeats <= 0){
			validate = true;
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Seats should be greater than zero"));
		}
		// TODO Auto-generated method stub
		return validate;
	}
	
	//Getting the bus details
	public List<BusDetails> getBuses(){
		ResultSet rs = null;
	      PreparedStatement pst = null;
	      Connection con = getConnection(); 
	      String stm = "";
	      java.sql.Date sqlDate = new java.sql.Date(onwardDate.getTime());
	      
	      //checking if homeID is clicked from search screen or from filter
	      //1= search page
	      //2 = Filter from bus listing
	      if(null != homeID){
	      if(homeID==1){
	       stm = "Select * from bus_details where ORIGIN_ID = ? and DESTINATION_ID = ? and TRUNC(DEPART_TIME) = TO_DATE('"+ sqlDate + "','yyyy-mm-dd') ";
	      }
	      else if(homeID == 2 && busTypeID > -1){
	    	  
	    	  stm = "Select * from bus_details where ORIGIN_ID = ? and DESTINATION_ID = ? and TRUNC(DEPART_TIME) = TO_DATE('"+ sqlDate + "','yyyy-mm-dd') and bus_bustype_id = " + busTypeID;
	    	  
	      }else{
	    	  stm = "Select * from bus_details where ORIGIN_ID = ? and DESTINATION_ID = ? and TRUNC(DEPART_TIME) = TO_DATE('"+ sqlDate + "','yyyy-mm-dd')" ;
	      }
	      
	      }else{
	    	  stm = "Select * from bus_details where ORIGIN_ID = ? and DESTINATION_ID = ? and TRUNC(DEPART_TIME) = TO_DATE('"+ sqlDate + "','yyyy-mm-dd')" ;
	      }
	      List<BusDetails> records = new ArrayList<BusDetails>();
	     
	      
	      
	      try {   
	         pst = con.prepareStatement(stm);
	         pst.setInt(1, cityOrigID);
	         pst.setInt(2, cityDestID);
	         //pst.setDate(3, sqlDate);
	         pst.execute();
	         rs = pst.getResultSet(); 

	         while(rs.next()) {
	        	 BusDetails bDetail = new BusDetails();
	        	 bDetail.setBusID(rs.getInt(1));
	        	 BusType bType = new BusType();
	        	 bType.setBusTypeID(rs.getInt(2));
	        	 bDetail.setbBusTypeID(bType);
	        	 bDetail.setFare(rs.getInt(3));
	        	 bDetail.setDestTime(new java.sql.Date((rs.getTimestamp(4).getTime())));
	        	 bDetail.setArrivalTime(new java.sql.Date((rs.getTimestamp(5).getTime())));
	        	 City oriCity = new City();
	        	 oriCity.setCityID(rs.getInt(6));
	        	 bDetail.setOriginID(oriCity);
	        	 City destCity = new City();
	        	 destCity.setCityID(rs.getInt(7));
	        	 bDetail.setDestID(destCity);
	        	 bDetail.setBusName(rs.getString(8));
	        	 bDetail.setTotSeats(rs.getInt(9));
	        	 bDetail.setAvailSeats(rs.getInt(10));
	        	 bDetail.setBookedSeats(rs.getInt(11));
	        	 
	            records.add(bDetail);				
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return records;
		
		
	}
	
	//Generating Ticket number
	public String generateTNo()  {
		String genTNo ="";
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 Connection con = getConnection(); 
		 
		 try {   
	         pst = con.prepareStatement("select SEQ_PNRNO.NEXTVAL from dual");
	         pst.execute();
	         rs = pst.getResultSet();

	         while(rs.next()) {
	        	 
	        	  genTNo = "TPJ000" +rs.getInt(1);

			
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally{


	      }
		 return genTNo;
		
		
	}
	
	//Loading the passenger detail screen
	public void loadPassenger(){
		  ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
	      try {
			context.redirect(context.getRequestContextPath() +  "/passenger.jsf" );
			
			

	      }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	//Saving the passenger details and ticket details
	public void savePnr(){
		
		ResultSet rs = null;
	      PreparedStatement pst = null;
	      PreparedStatement pst1 = null;
	      PreparedStatement pst2 = null;
	      PreparedStatement pst3 = null;
	      
	      
	      
	      Connection con = getConnection(); 
	      
	      String tNoGen = generateTNo();
	      //Calculating the seats based on no of seats
	      busDet.setAvailSeats(busDet.getTotSeats() - noOfSeats);
    	  busDet.setBookedSeats(busDet.getBookedSeats() + noOfSeats);
    	  //calculating the fare based on no of seats
    	  busDet.setFare(busDet.getFare() * noOfSeats);
    	  
    	  //Inserting into pnr details
	      String sql = "INSERT INTO pnrdetails " +
                  "VALUES (seq_pnr.nextval,?,?,?,?,?,?,?)";
	      //String stm = "Select * from pnrdetails";
	      //Inserting into person table which contains personal details
	      String sqlP = "INSERT INTO person " +
                  "VALUES (?,seq_person.nextval,?,?,?)";
	      //Updating the bus details seats
	      String sqlBusDet = "update bus_details set AVAIL_SEATS = ?, "
	      		+ " BOOKED_SEATS =? where bus_id = ?";
	      
	      Long key = null;

	      try {   

	    	  pst = con.prepareStatement(sql,new String[] { "t_id" });

	    	  //inserting data in pnrdetails table related to ticket information
	    	  pst.setInt(1, busDet.getBusID());
	    	  pst.setString(2, pnrDet.gettEmail());
	    	  pst.setString(3, noOfSeats.toString());
	    	  pst.setInt(4,busDet.getFare());
	    	  pst.setString(5, "Confirmed");
	    	  pst.setInt(6, pnrDet.gettPhone());
	    	  pst.setString(7, tNoGen);
	    	  
	    	// execute insert SQL statement
	    	  pst.executeUpdate();
	    	  
	    	  rs = pst.getGeneratedKeys();
	    	  if (null != rs && rs.next()) {

	    	        // voila! we got student id which was generated from sequence
	    	        key = rs.getLong(1);
	    	    }
	    	  //rs.next();
	    	  //String str = rs.getString(1);
	    	  //pnrTicketID = Integer.parseInt(str);

	    	  pnrTicketID = key.intValue();
	    	  pst2 = con.prepareStatement(sqlP);
		         //updating person table 
		    	  pst2.setInt(1, pnrTicketID);
		    	  pst2.setString(2, person.getpName());
		    	  pst2.setString(3,person.getpAge());
		    	  pst2.setString(4,person.getpTitle());
		    	  pst2.executeUpdate();
	    	      
		    	  
		    	  pst3 = con.prepareStatement(sqlBusDet);
		    	  
		    	  //updating the bus details for seats
		    	  pst3.setInt(1, busDet.getAvailSeats());
		    	  pst3.setInt(2, busDet.getBookedSeats());
		    	  pst3.setInt(3, busDet.getBusID());
		    	  pst3.executeUpdate();

			
		    	  loadConfirmPage();
	      
	 	      } catch (SQLException e) {
	 	         e.printStackTrace();
	 	      }	finally{
	 	    	  


	 	      }
	      
	       
	      //loadTicketDetails();
	     
		
	}
	
	public void loadConfirmPage(){
		
	      ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
	      try {
			context.redirect(context.getRequestContextPath() +  "/confirmation.jsf" );


			RequestContext.getCurrentInstance().update("frmCon");
	      }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void loadTicketDetails(){
		ticketDetails= getTicketDetails(pnrTicketID);
	}
	
	private PnrDetails getTicketDetails(Integer ticketID) {
		ResultSet rs = null;
		PnrDetails pnr = new PnrDetails();
	      PreparedStatement pst = null;
	      Connection con = getConnection(); 
	      String stm = "";
	      
	       stm = "select pn.T_NO,pn.T_EMAIL_ID,pn.T_SEAT,pn.T_FARE,pn.T_PHONE,bt.BUSTYPE_NAME,b.DEPART_TIME,b.ARRIVAL_TIME,c1.CITY_NAME,c2.CITY_NAME,p.P_NAME,p.p_age,b.bus_name"
	    		   +" from pnrdetails pn,BUS_DETAILS b, person p, city c1,city c2, BUS_TYPE bt"
	    		   	+" where pn.t_id = "+ticketID+" and pn.t_bus_id = b.BUS_ID and"
	    		   	+" b.ORIGIN_ID=c1.CITY_ID and b.DESTINATION_ID = c2.CITY_ID and  b.BUS_BUSTYPE_ID = bt.BUSTYPE_ID and"
	    		   	+" pn.T_ID = p.P_T_ID ";
	      
	      try {   
	         pst = con.prepareStatement(stm);
	         pst.execute();
	         rs = pst.getResultSet();

	         while(rs.next()) {
	        	 
	        	 pnr.settNo(rs.getString(1));
	        	 pnr.settEmail(rs.getString(2));
	        	 pnr.settSeat(rs.getString(3));
	        	 pnr.settFare(rs.getInt(4));
	        	 pnr.settPhone(rs.getInt(5));	      
	        	 BusDetails bDet = new BusDetails();
	        	 
	        	 BusType bType = new BusType();
	        	 bType.setBusTypeName(rs.getString(6));
	        	 bDet.setbBusTypeID(bType);
	        	 bDet.setDestTime(new java.sql.Date((rs.getTimestamp(7).getTime())));
	        	 bDet.setArrivalTime(new java.sql.Date((rs.getTimestamp(8).getTime())));
	        	 City city = new City();
	        	 city.setCityName(rs.getString(9));
	        	 bDet.setOriginID(city);
	        	 City destCity = new City();
	        	 destCity.setCityName(rs.getString(10));
	        	 bDet.setDestID(destCity);
	        	 Person per = new Person();
	        	 per.setpName(rs.getString(11));
	        	 per.setpAge(rs.getString(12));
	        	 pnr.setpDet(per);
	        	 bDet.setBusName(rs.getString(13));
	        	 pnr.settBusID(bDet);

	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally{


	      }
	      return pnr; 
		
	}
	
	//onchanging filter option from bus listing calling
	public void sortType(Integer val){
	
		System.out.println(val);
		homeID = val;
	//Getting selected bus type id	
	//busTypeID = (Integer) ((UIOutput)e.getSource()).getValue();
	
	
	//Based on the filter get the bus details	
	getBuses();
		
	}


	   public Connection getConnection() {
	      Connection con = null;
	      try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      String url = "jdbc:oracle:thin:@localhost:1521:xe";
	      String user = "brwa";
	      String password = "Admin@123";
	      
	      try {
	         con = DriverManager.getConnection(url, user, password);
	      } catch (SQLException ex) {
	         System.out.println(ex.getMessage());
	      }
	      
	      finally {
	      }
	      return con;
	   }
}