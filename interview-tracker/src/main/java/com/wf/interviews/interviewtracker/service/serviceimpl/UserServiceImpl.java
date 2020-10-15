package com.wf.interviews.interviewtracker.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wf.interviews.interviewtracker.DTO.UserDTO;
import com.wf.interviews.interviewtracker.entity.Interview;
import com.wf.interviews.interviewtracker.entity.User;
import com.wf.interviews.interviewtracker.exception.UserNotFoundException;
import com.wf.interviews.interviewtracker.respository.InterviewRepository;
import com.wf.interviews.interviewtracker.respository.UserRepository;
import com.wf.interviews.interviewtracker.service.InterviewService;
import com.wf.interviews.interviewtracker.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository repository;
	
	@Autowired
	InterviewRepository repo;
	
	@Override
	public List<UserDTO> getAll() {
		List<User> user =this.repository.findAll();
		List<UserDTO> userDTO=new ArrayList<UserDTO>();
		for(User s:user) {		
			userDTO.add(new UserDTO(s.getUserid(),s.getFirstName(),s.getLastName(),s.getEmail(),s.getMobile()));
		}
		return userDTO;
	}

	@Override
	public UserDTO getById(Long userid) {
		User user =this.repository.findById(userid).orElse(null);
		if(user==null)
			throw  new UserNotFoundException("User not Found with Id-" + userid);
		else
			return new UserDTO(user.getUserid(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getMobile());
	}
	
	@Override
	public UserDTO addUser(UserDTO userDto) {
		User user=new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setMobile(userDto.getMobile());
		User created=this.repository.save(user);
		return new UserDTO(created.getUserid(),created.getFirstName(),created.getLastName(),created.getEmail(),created.getMobile());
	}
	
	@Override
	public UserDTO deleteUser(Long id) {
		
		UserDTO user = this.getById(id);
		
		List<Interview> interviews=this.repo.findByUser(id);		
		for(Interview i:interviews) {
			this.repo.deleteById(i.getInterviewId());
		}
		if(user != null)
			this.repository.deleteById(id);
		return user;
	}

}
