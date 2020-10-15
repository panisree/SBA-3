package com.wf.interviews.interviewtracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistsForTheInterviewException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsForTheInterviewException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

}
