package com.wolken.wolkenapp.demoTravelTour.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.demoTravelTour.entity.User;
import com.wolken.wolkenapp.demoTravelTour.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	private static final Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	

	@Override
	public void validateandsaveMyUser(User user) {
		logger.info("saving data");
	
		if (user != null) {
			repo.save(user);
		}
	}

	@Override
	public Iterable<User> allUsers() {
    logger.info("inside get all service");
		return repo.findAll();
	}

	@Override
	public Iterable<User> deleteByUsername(String username) {
		logger.info("inisde delete service");
		repo.deleteByUsername(username);
		return repo.findAll();
	}

	@Override
	public User findByUsername(String username) {
     logger.info("inisde findby username");
		return repo.findByUsername(username);
	}

	@Override
	public User validateandUpdate(User newuser, int id) {
		logger.info("inside update service");
		User userentity = repo.findById(id);
		if (userentity != null) {
			logger.info("setting values inside update method");
			userentity.setFirstname(newuser.getFirstname());
			userentity.setLastname(newuser.getLastname());
			userentity.setAge(newuser.getAge());
			userentity.setPassword(newuser.getPassword());
			userentity.setConfirmpassword(newuser.getConfirmpassword());
			repo.save(userentity);
			return userentity;
		} else {
			return userentity;
		}
	}
}
