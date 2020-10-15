package com.wf.interviews.interviewtracker.exception.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class ExceptionResponse {

	
	private String message;
	private Long timeStamp;
	private int status;
	
	public ExceptionResponse(String message2, long currentTimeMillis, int value) {
		super();
		this.message=message2;
		this.timeStamp=currentTimeMillis;
		this.status=value;
	}
	
	public ExceptionResponse() {
		super();
	}
}
