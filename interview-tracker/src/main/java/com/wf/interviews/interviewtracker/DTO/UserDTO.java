package com.wf.interviews.interviewtracker.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDTO {
	
	private Long userid;
	
	@Size(min=5, message="At least 5 characters are required!")
	@NotNull(message="First Name should not be null")
	@Size(max = 25, message = "First Name value should have max characters upto 30!")
	private String firstName;
	
	@Size(min=3, message="At least 3 characters are required!")
	@NotNull(message="Last Name should not be null")
	@Size(max = 25, message = "Last Name value should have max characters upto 25!")
	private String lastName;
	
	@NotNull(message="Last Name should not be null")
	@Email
	private String email;
	
	@Pattern(regexp="^(0|[1-9][0-9]*)$")
	@Size(min=10, message="At least 10 characters are required!")
	@Size(max = 25, message = "Mobile value should have max characters upto 25!")
	private String mobile;
	
	
	public UserDTO(Long userid, String firstName, String lastName, String email, String mobile) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}
