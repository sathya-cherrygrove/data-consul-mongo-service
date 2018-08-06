package com.sat.controller;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RestController;

@Document(collection = "userdata")
public class User {

	@Id
	public String id;
	public String name;
	public String location;
	public int age;
	
	public User(String name, String location, int age)
	{
		this.name = name;
		this.age = age;
		this.location = location;
		
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public int getAge() {
		return age;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}

}
