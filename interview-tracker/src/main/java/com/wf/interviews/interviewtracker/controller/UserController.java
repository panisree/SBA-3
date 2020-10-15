package com.wf.interviews.interviewtracker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wf.interviews.interviewtracker.DTO.UserDTO;
import com.wf.interviews.interviewtracker.entity.User;
import com.wf.interviews.interviewtracker.exception.UserNotFoundException;
import com.wf.interviews.interviewtracker.service.UserService;
import com.wf.interviews.interviewtracker.exception.model.ExceptionResponse;

@RestController
//@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		List<UserDTO> users = this.service.getAll();
		
		ResponseEntity<List<UserDTO>> response = 
				new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long userid) {
		
		UserDTO user = this.service.getById(userid);
		
		if(user == null) {
			throw  new UserNotFoundException("User not Found with Id-" + userid);
		}
		
		ResponseEntity<UserDTO> response = 
				new ResponseEntity<UserDTO>(user, HttpStatus.OK);
		return response;
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO userDto) {
		UserDTO addedUser = this.service.addUser(userDto);
		ResponseEntity<UserDTO> response = 
				new ResponseEntity<UserDTO>(addedUser, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") Long userid) {
		UserDTO user = this.service.deleteUser(userid);
		if(user == null) {
			throw  new UserNotFoundException("User not Found with Id-" + userid);
		}
		ResponseEntity<UserDTO> response = 
				new ResponseEntity<UserDTO>(user, HttpStatus.OK);
		return response;
	}
	

}
