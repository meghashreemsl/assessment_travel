package com.wolken.wolkenapp.demoTravelTour.resource;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.wolken.wolkenapp.demoTravelTour.entity.User;
import com.wolken.wolkenapp.demoTravelTour.service.UserService;


@org.springframework.web.bind.annotation.RestController

public class RestController {

	@Autowired
	UserService userService;
	
	private static final Logger logger=LoggerFactory.getLogger(RestController.class);
	
	@PostMapping("/saveuser")
	@Transactional
	@CrossOrigin
	public String registerUser(@RequestBody User user) {
		logger.info("inisde register");
		userService.validateandsaveMyUser(user);
		return "hello"  + user.username +  "your registration is successfull";

	}
	
	@GetMapping("/allusers")
	@CrossOrigin
	public Iterable<User> allUsers(){
		logger.info("inside get all users");
		return userService.allUsers();
	}
	
	@GetMapping("/delete/{username}")
	@CrossOrigin
	@Transactional
	public Iterable<User> deleteUser(@PathVariable String username){
		logger.info("inside delete");
		return userService.deleteByUsername(username);
	}
	
	@GetMapping("/searchid/{id}")
	@CrossOrigin
	public User searchid(@PathVariable int id){
		logger.info("inside search id");
		return userService.validateandsearch(id);
	}
	
	
	@GetMapping("/search/{username}")
	@CrossOrigin
	public User searchUser(@PathVariable String username) {
		logger.info("inside search");
		return userService.findByUsername(username);
	}
	
	@PutMapping("/update/{id}")
	@CrossOrigin
	public User updateUser(@PathVariable int id,@RequestBody User newuser) {
		logger.info("inside update");
		return userService.validateandUpdate(newuser, id);
		
	}
}
