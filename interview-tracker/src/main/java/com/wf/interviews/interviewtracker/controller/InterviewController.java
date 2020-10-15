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
import org.springframework.web.bind.annotation.RestController;

import com.wf.interviews.interviewtracker.DTO.InterviewDTO;
import com.wf.interviews.interviewtracker.DTO.InterviewTrackDTO;
import com.wf.interviews.interviewtracker.DTO.UserDTO;
import com.wf.interviews.interviewtracker.exception.UserAlreadyExistsForTheInterviewException;
import com.wf.interviews.interviewtracker.exception.UserNotFoundException;
import com.wf.interviews.interviewtracker.exception.model.ExceptionResponse;
import com.wf.interviews.interviewtracker.service.InterviewService;
import com.wf.interviews.interviewtracker.service.UserService;

@RestController
public class InterviewController {
	
	@Autowired
	InterviewService service;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/interviews")
	public ResponseEntity<List<InterviewDTO>> getAllInterviews() {
		List<InterviewDTO> interviews = this.service.getAll();
			
		
		ResponseEntity<List<InterviewDTO>> response = 
				new ResponseEntity<List<InterviewDTO>>(interviews, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/interviews/getcount")
	public ResponseEntity<Integer> getCount() {
		List<InterviewDTO> interviews = this.service.getAll();
		
		Integer count=interviews.size();
		
		ResponseEntity<Integer> response = 
				new ResponseEntity<Integer>(count, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/interviews/users/{interviewName}")
	public ResponseEntity<List<UserDTO>> getUsersForInterview(@PathVariable("interviewName") String interviewName) {
		List<UserDTO> users = this.service.getUsersForInterview(interviewName);
				
		
		ResponseEntity<List<UserDTO>> response = 
				new ResponseEntity<List<UserDTO>>(users,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/interviews/interviewname/{interviewName}")
	public ResponseEntity<List<InterviewDTO>> getInterviewByInterviewName(@PathVariable("interviewName") String interviewName) {
		List<InterviewDTO> interviews = this.service.getByInterviewName(interviewName);
				
		
		ResponseEntity<List<InterviewDTO>> response = 
				new ResponseEntity<List<InterviewDTO>>(interviews,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/interviews/interviewername/{interviewerName}")
	public ResponseEntity<List<InterviewDTO>> getInterviewerByInterviewName(@PathVariable("interviewerName") String interviewerName) {
		List<InterviewDTO> interviews = this.service.getByInterviewName(interviewerName);
				
		
		ResponseEntity<List<InterviewDTO>> response = 
				new ResponseEntity<List<InterviewDTO>>(interviews,HttpStatus.OK);
		return response;
	}
	
	
	@PostMapping("/interviews")
	public ResponseEntity<InterviewDTO> addInterview(@Valid @RequestBody InterviewDTO interviewDto) {
		
		System.out.println("==="+interviewDto.getUserSkills());
		
		InterviewDTO addedInterview = this.service.addInterview(interviewDto);
		
		ResponseEntity<InterviewDTO> response = 
				new ResponseEntity<InterviewDTO>(addedInterview, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/interviews/updateuser/{interviewId}/{userId}")
	public ResponseEntity<InterviewTrackDTO> updateUserForInterview(@Valid @PathVariable("interviewId") Long interviewId, 
			@PathVariable("userId") Long userId) {
		
		if(this.service.getById(interviewId)==null)
			throw  new UserNotFoundException("Interview not Found with Id-" + interviewId);
		
		if(this.userService.getById(userId)==null)
			throw  new UserNotFoundException("User not Found with Id-" + userId);
		
		try {
				InterviewTrackDTO addedUserForInterview = this.service.UpdateUserForInterview(interviewId, userId);
				
				ResponseEntity<InterviewTrackDTO> response = 
						new ResponseEntity<InterviewTrackDTO>(addedUserForInterview, HttpStatus.OK);
				return response;
			}
			catch(UserAlreadyExistsForTheInterviewException e) {
				throw new UserAlreadyExistsForTheInterviewException("User already has already assigned for the Interview-" + userId);
			}
	}
	
	@PutMapping("/interviews/updatestatus/{interviewId}/{status}")
	public ResponseEntity<InterviewDTO> updateUserForInterview(@Valid @PathVariable("interviewId") Long interviewId, 
			@PathVariable("status") String Status) {
		
		if(this.service.getById(interviewId)==null)
			throw  new UserNotFoundException("Interview not Found with Id-" + interviewId);
		
		InterviewDTO addedUserForInterview = this.service.updateStatus(interviewId, Status);
		ResponseEntity<InterviewDTO> response = 
				new ResponseEntity<InterviewDTO>(addedUserForInterview, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/interviews/{id}")
	public ResponseEntity<InterviewDTO> deleteInterview(@PathVariable("id") Long interviewid) {
		InterviewDTO interview = this.service.deleteInterview(interviewid);
		if(interview == null) {
			throw  new UserNotFoundException("Interview not Found with Id-" + interviewid);
		}
		ResponseEntity<InterviewDTO> response = 
				new ResponseEntity<InterviewDTO>(interview, HttpStatus.OK);
		return response;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(UserNotFoundException ex) {
		ExceptionResponse exResponse =
				new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		ResponseEntity<ExceptionResponse> response = 
				new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.NOT_FOUND);
		return response;
	}

}
