package com.example.cabbooking.testdriver;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabbooking.entity.Car;
import com.example.cabbooking.entity.Driver;
import com.example.cabbooking.entity.Location;
import com.example.cabbooking.entity.User;
import com.example.cabbooking.service.DriverService;
import com.example.cabbooking.service.OperatorService;
import com.example.cabbooking.service.UserService;

@Service
public class TestDriver {

	// need to inject services
	private UserService userService;
	private DriverService driverService;
	private OperatorService operatorService;
	
	@Autowired()
	public TestDriver(UserService userService, DriverService driverService, OperatorService operatorService) {
	   this.userService  = userService;
	   this.driverService = driverService;
	   this.operatorService= operatorService;
	}
	

	public void runCabOpeartor() {
		
		
		/*
		 * for user input 
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of User");
		int testCase=sc.nextInt();
		
		while(testCase>0) {
			System.out.println("Enter "+testCase+" user name");
			String userName=sc.next();
			System.out.println("Enter "+testCase+" user gender");
			String gender=sc.next();
			System.out.println("Enter "+ testCase+" user Age");
			int age=sc.nextInt();
			System.out.println("Enter "+testCase + "location as x y");
			int x=sc.nextInt();
			int y=sc.nextInt();
			
			User theUser1 =new User(userName, gender, age);
			Location theLocation1 =new Location(x,y);
		    userService.updateUserLocation(userName, theLocation1);
			
			testCase--;
		}
		*/

		
		User theUser1 =new User("Abhishek", "M", 23);
		User theUser2=new User("Rahul", "M", 29);
		User theUser3 =new User("Nandini", "M", 22);
		
		userService.addUser(theUser1);
		userService.addUser(theUser2);
		userService.addUser(theUser3);
		
		Location theLocation1 =new Location(0,0);
		userService.updateUserLocation("Abhishek",theLocation1);
		
		Location theLocation2 =new Location(10,0);
		userService.updateUserLocation("Rahul",theLocation2);
		
		Location theLocation3 =new Location(15,6);
		userService.updateUserLocation("Nandini",theLocation3);
		
		
		/*
		List<User> list=userService.getUsers();
		
		for(User tempUser : list) {
			System.out.println("\n Username "+tempUser.getUserName());
			System.out.println("\n Gender "+tempUser.getUserGender());
			System.out.println("\n Age "+tempUser.getUserAge());
			
			Location tempLocation=null;
			try {
			tempLocation = tempUser.getUserLocation();
			}catch(Exception exc) {
				
			}
			
			if(tempLocation!=null) {
			System.out.println("X-Coordinate \n"+tempLocation.getX());
			System.out.println("Y-Coordinate \n"+tempLocation.getY());
			}

		
		}
		
		*/
		
		Driver theDriver1=new Driver("Driver1", "M", 22);
		Car theCar1 =new Car("Swift","KA-01-12345");
		Location driverLocation1=new Location(10,1);
		
		
		Driver theDriver2=new Driver("Driver2", "M", 29);
		Car theCar2 =new Car("Swift","KA-01-12345");
		Location driverLocation2=new Location(11,10);
		
		
		Driver theDriver3=new Driver("Driver3", "M", 24);
		Car theCar3 =new Car("Swift","KA-01-12345");
		Location driverLocation3=new Location(5,3);
		
		driverService.addDriver(theDriver1, theCar1, driverLocation1);
		driverService.addDriver(theDriver2, theCar2, driverLocation2);
		driverService.addDriver(theDriver3, theCar3, driverLocation3);
		
		//for adding driver to totalearning
		operatorService.account();
		
		
		/*
		List<Driver> drivers=driverService.getDrivers();
		
		for(Driver tempUser : drivers) {
			System.out.println("\n Username "+tempUser.getDriverName());
			System.out.println("\n Gender "+tempUser.getDriverGender());
			System.out.println("\n Age "+tempUser.getDriverAge());
			System.out.println("\n Status "+tempUser.getDriverStatus());
			
			Location tempLocation=null;
			try {
			tempLocation = tempUser.getDriverLocation();
			}catch(Exception exc) {
				
			}
			
			if(tempLocation!=null) {
			System.out.println("X-Coordinate \n"+tempLocation.getX());
			System.out.println("Y-Coordinate \n"+tempLocation.getY());
			}
			
			Car tempCar =null;
			try {
				tempCar = tempUser.getCar();
				}catch(Exception exc) {
					
				}
				
				if(tempLocation!=null) {
				System.out.println(tempCar.getCarCompany());
				System.out.println(tempCar.getCarRegistrationNumber());
				}
		  }
		  
		  */

		
		String name ="Abhishek";
		Location source=new Location(0,0);
		Location destination =new Location(20,1);
		operatorService.findRide(name, source, destination);
		
		
		
		String name2 ="Rahul";
		Location source2=new Location(10,0);
		Location destination2 =new Location(15,3);
		operatorService.findRide(name2, source2, destination2);

		
		String name3 ="Rahul";
		String driver ="Driver1";
		operatorService.chooseRide(name3, driver);
		
		operatorService.totalEarning();
		
		String name4 ="Nandini";
		Location source4=new Location(15,6);
		Location destination4 =new Location(20,4);
		operatorService.findRide(name4, source4, destination4);
			
		
		
		

	}

}
