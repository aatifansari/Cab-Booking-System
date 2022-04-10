package com.example.cabbooking.entity;

public class Driver {
	
	private String driverName;
	private String driverGender;
	private int driverAge;
	private boolean driverStatus;
	
	private Location driverLocation=null;
	
	private Car Car=null;
	
	public Driver(){
		
		
	}

	// parameterized constructor
	public Driver(String driverName, String driverGender, int driverAge) {
		this.driverName = driverName;
		this.driverGender = driverGender;
		this.driverAge = driverAge;
	}


	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverGender() {
		return driverGender;
	}

	public void setDriverGender(String driverGender) {
		this.driverGender = driverGender;
	}

	public int getDriverAge() {
		return driverAge;
	}

	public void setDriverAge(int driverAge) {
		this.driverAge = driverAge;
	}
	
	public boolean getDriverStatus() {
		return driverStatus;
	}

	public void setDriverStatus(boolean driverStatus) {
		this.driverStatus = driverStatus;
	}

	public Location getDriverLocation() {
		return driverLocation;
	}

	public void setDriverLocation(Location driverLocation) {
		this.driverLocation = driverLocation;
	}

	public Car getCar() {
		return Car;
	}

	public void setCar(Car car) {
		Car = car;
	}


	@Override
	public String toString() {
		return "Driver [driverName=" + driverName + ", driverGender=" + driverGender + ", driverAge=" + driverAge
				+ ", driverStatus=" + driverStatus + ", driverLocation=" + driverLocation + ", Car=" + Car + "]";
	}
	
	
	
	
	


	


	
	
	

}
