package com.wolken.wolkenapp.demoTravelTour.service;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.demoTravelTour.dto.LoginDTO;
import com.wolken.wolkenapp.demoTravelTour.exception.NullLoginDTOException;
import com.wolken.wolkenapp.demoTravelTour.exception.NullLoginEnityException;
import com.wolken.wolkenapp.demoTravelTour.repository.UserRepository;


@Service

public class LoginServiceImpl implements LoginService {

private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	
	@Autowired
    UserRepository repo;

	@Override
	public String ValidateAndLogin(LoginDTO loginDTO) {
		logger.info("validate and login");
		
			logger.info("inside validate and login inside login service ");
			com.wolken.wolkenapp.demoTravelTour.entity.User user=repo.findByUsername(loginDTO.getUsername());
			if(user!=null) {
				logger.info(" company entity is not null inside validate and login inside login service ");
				if(loginDTO.getPassword().equals(loginDTO.getPassword())) {
					logger.info(" Login successfull  inside validate and login inside login service ");
					return "Login SuccessFully";
				}else {
				
					return "Password incorrect";
				}
			}
		
			return "Username Not Found ";
		}
     }
