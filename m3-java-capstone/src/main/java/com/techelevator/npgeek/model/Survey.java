package com.techelevator.npgeek.model;

public class Survey {
	private int id = 0;
	private String parkCode;
	private String email;
	private String state;
	private String physicalActivityLevel;
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhysicalActivityLevel() {
		return physicalActivityLevel;
	}
	public void setPhysicalActivityLevel(String physicalActivityLevel) {
		this.physicalActivityLevel = physicalActivityLevel;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
}
