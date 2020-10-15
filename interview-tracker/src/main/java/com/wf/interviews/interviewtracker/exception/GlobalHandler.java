package com.wf.interviews.interviewtracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wf.interviews.interviewtracker.exception.model.ExceptionResponse;

@ControllerAdvice 
public class GlobalHandler {

//	// Exception Handler Method
		@ExceptionHandler(UserNotFoundException.class)
		public ResponseEntity<ExceptionResponse> handler(UserNotFoundException ex) {
			ExceptionResponse exResponse =
					new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
					ResponseEntity<ExceptionResponse> response = 
							new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.NOT_FOUND);
					return response;
		}
		
		@ExceptionHandler(UserAlreadyExistsForTheInterviewException.class)
		public ResponseEntity<ExceptionResponse> handler(UserAlreadyExistsForTheInterviewException ex) {
			ExceptionResponse exResponse =
					new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(), HttpStatus.CONFLICT.value());
					ResponseEntity<ExceptionResponse> response = 
							new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.CONFLICT);
					return response;
		}
//	
//	// Exception Handler Method
		@ExceptionHandler(Exception.class)
		public ResponseEntity<ExceptionResponse> handler(Exception ex) {
			ExceptionResponse exResponse =
				new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value());
					ResponseEntity<ExceptionResponse> response = 
					new ResponseEntity<ExceptionResponse>(exResponse, HttpStatus.BAD_REQUEST);
					return response;
		}
}
