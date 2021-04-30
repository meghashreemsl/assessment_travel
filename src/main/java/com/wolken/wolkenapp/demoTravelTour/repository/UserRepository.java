package com.wolken.wolkenapp.demoTravelTour.repository;

import org.springframework.data.repository.CrudRepository;

import com.wolken.wolkenapp.demoTravelTour.entity.User;

public interface UserRepository extends CrudRepository<User,Integer>{

public Iterable<User> deleteByUsername(String username); 
public User findByUsername(String username);
public User findById(int id);
}
