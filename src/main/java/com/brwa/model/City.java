package main.java.com.brwa.model;

public class City {
	
	private Integer cityID;
	private String cityName;
	public City(){
		
	}
	public Integer getCityID() {
		return cityID;
	}
	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public City(Integer cityID, String cityName) {
		super();
		this.cityID = cityID;
		this.cityName = cityName;
	}
	
	

}
