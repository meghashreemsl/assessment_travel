package com.wolken.wolkenapp.demoTravelTour.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.demoTravelTour.entity.User;
import com.wolken.wolkenapp.demoTravelTour.exception.NullException;
import com.wolken.wolkenapp.demoTravelTour.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	
	private static final Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	

	@Override
	public User validateandsaveMyUser(User user){
		logger.info("saving data");
	try {
		if (user == null) {
			throw new NullException();
			
		}else {
			return repo.save(user);
		}
	}catch(NullException e) {
		logger.error(e.toString());
	}
	return null;
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
			logger.info("setting firstname");
			userentity.setFirstname(newuser.getFirstname());
			logger.info("setting lastname");
			userentity.setUsername(newuser.getUsername());
			logger.info("setting lastname");
			userentity.setLastname(newuser.getLastname());
			logger.info("setting age");
			userentity.setAge(newuser.getAge());
			logger.info("setting password");
			userentity.setPassword(newuser.getPassword());
			logger.info("setting confirm password");
			userentity.setConfirmpassword(newuser.getConfirmpassword());
			logger.info("saving entity");
			 return repo.save(userentity);
			 //return userentity;
		} else {
			return null;
		}
	}

	@Override
	public User validateandsearch(int id) {
		logger.info("inside search by id");
		return repo.findById(id);
	
}
}
