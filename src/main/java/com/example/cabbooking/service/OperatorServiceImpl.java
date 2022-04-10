package com.example.cabbooking.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabbooking.entity.Driver;
import com.example.cabbooking.entity.Location;
import com.example.cabbooking.entity.User;

@Service
public class OperatorServiceImpl implements OperatorService{
	
	private UserService userService;
	private DriverService driverService;
	
	@Autowired
	public OperatorServiceImpl(UserService userService, DriverService driverService) {
		this.userService = userService;
		this.driverService = driverService;
	}
	
	
	
	private static TreeMap<String, Integer> total=new TreeMap<String,Integer>();
	private List<Driver> availableDrivers=new ArrayList<Driver>();
	private Location destination=null;
	private String selectedDriver=null;
	
	public void account() {
		List<Driver> list = driverService.getDrivers();
		for(Driver tempDriver : list) {
			total.put(tempDriver.getDriverName(), 0);
		}
	}
	


	//implementing find ride
	@Override
	public List<Driver> findRide(String name, Location source, Location destination) {
		
		List<Driver> drivers= driverService.getDrivers();
		
		// store destination in class field
		this.destination=destination;
		

		
		User theUser = userService.updateUserLocation(name, source);
		
		int user_x_ordinate=theUser.getUserLocation().getX();
		int user_y_ordinate=theUser.getUserLocation().getY();	

		
		int count=0;
		for(Driver theDriver : drivers) {
		
			int driver_x_ordinate=theDriver.getDriverLocation().getX();
			int driver_y_ordinate=theDriver.getDriverLocation().getY();
			
			int d=(int) Math.round(Math.sqrt(
					(driver_x_ordinate-user_x_ordinate)*(driver_x_ordinate-user_x_ordinate)+
					(driver_y_ordinate-user_y_ordinate)*(driver_y_ordinate-user_y_ordinate)
					));
			
			if(d<5) {
				
				
				
				availableDrivers.add(theDriver);
				System.out.println(theDriver.getDriverName());
				count++;
			}
					
		}
		
		if(count==0) {
			System.out.println("\n No ride found");
		}
		
		
		
		
		return availableDrivers;
	}
	
	
	@Override
	public boolean chooseRide(String userName, String driverName) {
		
		selectedDriver = driverName;
		
		for(Driver theDriver : availableDrivers) {
			if(theDriver.getDriverName().equalsIgnoreCase(driverName)
					&&theDriver.getDriverStatus()==true) {
				////
				System.out.println("ride started");
				
				calculateBill(userName);
			
				return true;
			}
		}
		
		System.out.println("\n No Driver Available");
		
		return false;
	}

	
	@Override
	public int calculateBill(String userName) {
		
		User theUser= userService.getUser(userName);
		Location thelocation =theUser.getUserLocation();
		
		int source_x=thelocation.getX();
		int source_y=thelocation.getY();
		
		int destination_x=destination.getX();
		int destination_y=destination.getY();
		
		int distance = (int) Math.round(Math.sqrt(
				(destination_x-source_x)*(destination_x-source_x)+
				(destination_y-source_y)*(destination_y-source_y)
				));
	
		System.out.println("Ride ended bill amount $ "+distance);
		total.put(selectedDriver,total.get(selectedDriver)+distance);
		
		userService.updateUserLocation(userName, destination);
		driverService.updateDriverLocation(selectedDriver, thelocation);
		
		driverService.getDriver(selectedDriver).setDriverStatus(false);
		
		
		return distance;
	}
	
	

	@Override
	public void totalEarning() {
		
        for (Map.Entry<String,Integer> entry : total.entrySet())
            System.out.println(entry.getKey() +" earn $"+ entry.getValue());	
		
	}
	
	
	
	
	


	
	

}
