package com.wf.interviews.interviewtracker.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



public class InterviewDTO {
	
	
	private Long interviewId;
	
	@Size(min=5, message="At least 5 characters are required!")
	@NotNull(message="Interviewer Name should not be null")
	@Size(max = 30, message = "First Name value should have max characters upto 30!")
	private String interviewerName;
	
	@Size(min=3, message="At least 5 characters are required!")
	@NotNull(message="Interview Name should not be null")
	@Size(max = 30, message = "Interview Name value should have max characters upto 30!")
	private String interviewName;
	
	
	@Size(min=5, message="At least 5 characters are required!")
	@NotNull(message="user Skills should not be null")
	@Size(max = 30, message = "user Skills value should have max characters upto 30!")
	private String userSkills;
	
	@NotNull
	private String date;
	
	@NotNull
	private String time;
	
	@Size(min=5, message="At least 5 characters are required!")
	@NotNull(message="Status should not be null")
	@Size(max = 100, message = "Status value should have max characters upto 100!")
	private String interviewStatus;
	
	@Size(min=5, message="At least 5 characters are required!")
	@NotNull(message="Remarks should not be null")
	@Size(max = 100, message = "Remarks value should have max characters upto 100!")
	private String remarks;
	
	private Long userId;
	
	public InterviewDTO() {
		super();
	}
	
	public InterviewDTO(Long interviewId, String interviewerName, String interviewName, String userSkills, String date,
			String time, String interviewStatus, String remarks) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.userSkills = userSkills;
		this.date = date;
		this.time = time;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
//		this.userId=userId;
	}
	
//	public InterviewDTO(Long interviewId, String interviewerName, String interviewName, String usersSkills, String date,
//			String time, String interviewStatus, String remarks, Long userId) {
//		super();
//		this.interviewId = interviewId;
//		this.interviewerName = interviewerName;
//		this.interviewName = interviewName;
//		this.userSkills = usersSkills;
//		this.date = date;
//		this.time = time;
//		this.interviewStatus = interviewStatus;
//		this.remarks = remarks;
//		this.userId=userId;
//	}

	@Override
	public String toString() {
		return "InterviewDTO [interviewId=" + interviewId + ", interviewerName=" + interviewerName + ", interviewName="
				+ interviewName + ", userSkills=" + userSkills + ", date=" + date + ", time=" + time
				+ ", interviewStatus=" + interviewStatus + ", remarks=" + remarks + "]";
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

//	public Long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}

}
