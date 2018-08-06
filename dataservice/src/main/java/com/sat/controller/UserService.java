package com.sat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserService {

	@RequestMapping("/updateuser")
	public String inputUser(@RequestParam("name") String name, @RequestParam("age") int age) {

		return "true";
	}

}
