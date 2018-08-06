package com.sat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoClient;
import com.sat.repository.UserRepository;

@RestController
@EnableMongoRepositories("com.sat.repository")
public class UserProcess {

	@Autowired
	UserRepository userrepository;

	@RequestMapping("/findUser")
	public String findUser(@RequestParam("name") String name) {
		User user = userrepository.findOneByName(name);
		return "User Details : " + user.name + " User location: " + user.location + " User Age : "
				+ Integer.toString(user.age);

	}

	@RequestMapping("/findMoreData")
	public String findMoreData() {
		String output = "";
		List<User> userrepo = userrepository.findAll();
		// return "User Details : " + user.name + " User location: " + user.location + "
		// User Age : "+ Integer.toString(user.age);
		for (User usr : userrepo) {
			output = output + "Id : " + usr.id + "name : " + usr.name + " location: " + usr.location + " age : "
					+ Integer.toString(usr.age);
		}

		return output;

		// return Integer.toString(userrepo.size());

	}

	@RequestMapping("/testTable")
	public String testTable() {
		List<User> userrepo = userrepository.findAll();
		return "Size of collection is : " + Integer.toString(userrepo.size());

	}
	
	public MongoTemplate getMongoTemplate()
	{
		
		MongoTemplate mt = new MongoTemplate(new MongoClient("mongodb:27017"),"testdatabase");
		return mt;
		
	}
	
	@RequestMapping("/writeData")
	public String writeData()
	{
		try {
		User user = new User("Rodman", "NYC", 56);
		MongoTemplate datainstance = getMongoTemplate();
		datainstance.insert(user);
		return "User added";
		}
		catch (Exception e)
		{
			return "Unable to add user. Error trace : "+ e.getMessage();
		}
		
	}
	
	@RequestMapping("testtest")
	public String testtest()
	{
		return "Test Test Test indeed";
	}

}
