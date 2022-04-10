package com.example.cabbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cabbooking.entity.Car;
import com.example.cabbooking.entity.Driver;
import com.example.cabbooking.entity.Location;

@Service
public class DriverServiceImpl implements DriverService {

	
	List<Driver> drivers = new ArrayList<Driver>();
	
	// get particular driver based on Driver name
	@Override
	public Driver getDriver(String name) {
		for(Driver theDriver : drivers) {
			if(theDriver.getDriverName().equalsIgnoreCase(name)) {
				return theDriver;
			}
		}
		
		return null;
	}
	
	// get list of all registered drivers
	@Override
	public List<Driver> getDrivers() {
		return drivers;
	}

	
	// onboard driver on the system
	@Override
	public void addDriver(Driver theDriver,Car theCar, Location theLocation) {
		
		theDriver.setDriverStatus(true);
		theDriver.setCar(theCar);
		theDriver.setDriverLocation(theLocation);
		drivers.add(theDriver);

	}
	

	// update driver location
	@Override
	public void updateDriverLocation(String name, Location location) {
		
		for(Driver theDriver : drivers) {
			if(theDriver.getDriverName().equalsIgnoreCase(name)) {
				theDriver.setDriverLocation(location);
			}
		}
		
	}


	
	
	

}
