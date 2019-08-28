package com.bridgelabz.userservice.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseImage {
	
	private String message;
	private long timeStamp;
	private int status;
	private String url;
}
