package com.samplespringsecurityproject.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.samplespringsecurityproject.app.dtos.UserDto;
import com.samplespringsecurityproject.app.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<String> createUser(@RequestBody  UserDto userDto){
		userService.addUser(userDto);
		return new ResponseEntity<String>("User Created", HttpStatus.CREATED);
	}
}
