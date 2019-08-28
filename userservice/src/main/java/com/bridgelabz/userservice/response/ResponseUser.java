package com.bridgelabz.userservice.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseUser {
	private String message;
	private long timeStamp;
	private int status;
	private String emailid;
	private String name;
}
