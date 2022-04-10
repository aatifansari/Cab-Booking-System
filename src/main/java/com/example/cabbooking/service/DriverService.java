package com.example.cabbooking.service;

import java.util.List;

import com.example.cabbooking.entity.Car;
import com.example.cabbooking.entity.Driver;
import com.example.cabbooking.entity.Location;

public interface DriverService {
	
	public List<Driver> getDrivers();
	
	public void addDriver(Driver theDriver, Car theCar, Location theLocation);
	
	public void updateDriverLocation(String name, Location location);
	
	public Driver getDriver(String name);
	

}
