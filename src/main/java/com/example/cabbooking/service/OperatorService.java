package com.example.cabbooking.service;

import java.util.List;

import com.example.cabbooking.entity.Driver;
import com.example.cabbooking.entity.Location;

public interface OperatorService {
	
	public void account();
	
	public List<Driver> findRide(String name,
			Location source, Location destination);
	
	public boolean chooseRide(String userName, String drivername);
	
	public int calculateBill(String userName);
	
	public void totalEarning();

}
