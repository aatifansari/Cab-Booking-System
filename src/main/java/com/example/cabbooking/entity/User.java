package com.example.cabbooking.entity;


public class User {
	
	private String userName;
	private String userGender;
	private int userAge;
	
	private Location userLocation=null;
	
     public User(){
    	 
		
	}
     
    
    // parameterized constructor
    public User(String userName, String userGender, int userAge) {
		this.userName = userName;
		this.userGender = userGender;
		this.userAge = userAge;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	public Location getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(Location userLocation) {
		this.userLocation = userLocation;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userGender=" + userGender + ", userAge=" + userAge + ", userLocation="
				+ userLocation + "]";
	}

	

	
     
     

}
