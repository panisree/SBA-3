package com.wf.interviews.interviewtracker.service;

import java.util.List;

import com.wf.interviews.interviewtracker.DTO.UserDTO;
import com.wf.interviews.interviewtracker.entity.User;

public interface UserService {
	
	public List<UserDTO> getAll();
	public UserDTO getById(Long userid);
//	public User addUser(User user);
	public UserDTO addUser(UserDTO userDto);
	public UserDTO deleteUser(Long userid);
}
