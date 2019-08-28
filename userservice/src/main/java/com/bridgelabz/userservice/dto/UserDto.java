package com.bridgelabz.userservice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserDto 
{
	@NotEmpty(message="please enter firstname")
	private String firstName;
	
	@NotEmpty(message="please enter lastname")
	private String lastName;
	
	@Email(message = "please enter emailid")
	private String emailid;
	
	@Pattern(regexp = "[0-9]{10}", message = "provide valid mobile number")
	private String phoneno;
	
	@NotEmpty(message = "provide password ")
	private String password;
	
	public UserDto() {
		
	}

	public UserDto(@NotEmpty(message = "please enter firstname") String firstName,
			@NotEmpty(message = "please enter lastname") String lastName,
			@Email(message = "please enter emailid") String emailid,
			@Pattern(regexp = "[0-9]{10}", message = "provide valid mobile number") String phoneno,
			@NotEmpty(message = "provide password ") String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailid = emailid;
		this.phoneno = phoneno;
		this.password = password;
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

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDto [firstName=" + firstName + ", lastName=" + lastName + ", emailid=" + emailid + ", phoneno="
				+ phoneno + ", password=" + password + "]";
	}
	
	
	
}
