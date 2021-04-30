package com.wolken.wolkenapp.demoTravelTour.service;

import com.wolken.wolkenapp.demoTravelTour.entity.User;

public interface UserService {
	
	public void validateandsaveMyUser(User user);
	public Iterable<User> allUsers();
	public Iterable<User> deleteByUsername(String username);
	public User findByUsername(String username);
	public User validateandUpdate(User newuser,int id);

}