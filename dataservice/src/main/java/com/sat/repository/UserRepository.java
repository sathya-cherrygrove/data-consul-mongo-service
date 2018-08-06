package com.sat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sat.controller.User;


public interface UserRepository extends MongoRepository<User, String> {

	public User findOneByName(String name);

}
