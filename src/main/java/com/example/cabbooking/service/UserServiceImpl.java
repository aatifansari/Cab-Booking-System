package com.example.cabbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cabbooking.entity.Location;
import com.example.cabbooking.entity.User;



@Service
public class UserServiceImpl implements UserService {
	
	List<User> users = new ArrayList<User>();
	
	// get user object based on username
	@Override
	public User getUser(String name) {
		
		for(User theUser : users) {
			if(theUser.getUserName().equalsIgnoreCase(name)) {
				return theUser;
			}
		}
		return null;
	}
	
	// get list of all the user
	@Override
	public List<User> getUsers() {
		return users;
	}
	
	
	// add new user
	@Override
	public void addUser(User theUser) {
		
		users.add(theUser);

	}

	//implementing update location for the given user
	@Override
	public User updateUserLocation(String name, Location location) {
		
		for(User theUser : users) {
			if(theUser.getUserName().equalsIgnoreCase(name)) {
				theUser.setUserLocation(location);
				return theUser;
			}
		}
		
		System.out.println("No record found");
		
		return null;
	}




	@Override
	public User updateUserDetails(String userName, User theUser) {
		for(User tempUser : users) {
			if(tempUser.getUserName().equalsIgnoreCase(userName)) {
				tempUser.setUserName(theUser.getUserName());
				tempUser.setUserGender(theUser.getUserGender());
				tempUser.setUserAge(theUser.getUserAge());
				return tempUser;
			}
		}
		
		System.out.println("No record found");
		
		return null;
		
	}
	
	



}
