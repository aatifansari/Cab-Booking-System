package com.example.cabbooking.entity;

public class Car {
	
	private String carCompany;
	private String carRegistrationNumber;
	
	public Car() {
		
		
	}
	
	// parameterized constructor
	public Car(String carCompany, String carRegistrationNumber) {
		this.carCompany = carCompany;
		this.carRegistrationNumber = carRegistrationNumber;
	}


	public String getCarCompany() {
		return carCompany;
	}
	
	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}
	
	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}
	
	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}


	@Override
	public String toString() {
		return "Car [carCompany=" + carCompany + ", carRegistrationNumber=" + carRegistrationNumber + "]";
	}
	
	
	
	
}
