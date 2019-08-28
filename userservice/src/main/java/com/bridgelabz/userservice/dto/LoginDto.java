package com.bridgelabz.userservice.dto;

public class LoginDto 
{
	private String emailid;
	private String password;
	
	public LoginDto(String emailid, String password) {
		super();
		this.emailid = emailid;
		this.password = password;
	}
	
	public LoginDto() {}
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginDto [emailid=" + emailid + ", password=" + password + "]";
	}

	


}
