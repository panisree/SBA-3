package com.wf.interviews.interviewtracker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Interview {
	
	@Id  // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
	private Long interviewId;
	
	private String interviewerName;
	
	private String interviewName;
	
	private String userSkills;
	
	private String date;
	
	private String time;
	
	private String interviewStatus;
	
	private String remarks;

	private Long userId;
	
	public Interview() {
		super();
	}

	public Interview(Long interviewId, String interviewerName, String interviewName, String userSkills, String date,
			String time, String interviewStatus, String remarks, Long userId) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.userSkills = userSkills;
		this.date = date;
		this.time = time;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
		this.userId=userId;
	}

	public Long getInterviewId() {
		return interviewId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
	}

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getInterviewName() {
		return interviewName;
	}

	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}

	public String getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(String userSkills) {
		this.userSkills = userSkills;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
