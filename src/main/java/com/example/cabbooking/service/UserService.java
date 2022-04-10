package com.example.cabbooking.service;

import java.util.List;

import com.example.cabbooking.entity.Location;
import com.example.cabbooking.entity.User;

public interface UserService {
	
	public User getUser(String name);
	
	public List<User> getUsers();
	
	public void addUser(User theUser);
	
	public User updateUserDetails(String userName, User theUser);
	
	public User updateUserLocation(String name,
			Location location);
	
}
