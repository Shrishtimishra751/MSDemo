package com.bridgelabz.userservice.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ResponseToken 
{
	private String message;
	private long timeStamp;
	private int status;
	private String token;
	
}
