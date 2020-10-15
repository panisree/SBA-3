package com.wf.interviews.interviewtracker.DTO;

public class InterviewTrackDTO {
	private Long interviewId;	
	private String interviewerName;	
	private String interviewName;	
	private String userSkills;	
	private String date;	
	private String time;	
	private String interviewStatus;	
	private String remarks;	
	private Long userid;	
	private String firstName;	
	private String lastName;	
	private String email;
	private String mobile;
	
	public InterviewTrackDTO(Long interviewId, String interviewerName, String interviewName, String userSkills,
			String date, String time, String interviewStatus, String remarks, Long userid, String firstName,
			String lastName, String email, String mobile) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.userSkills = userSkills;
		this.date = date;
		this.time = time;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile=mobile;
	}
	public Long getInterviewId() {
		return interviewId;
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
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
