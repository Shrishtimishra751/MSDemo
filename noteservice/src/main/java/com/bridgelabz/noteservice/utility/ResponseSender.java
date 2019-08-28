package com.bridgelabz.noteservice.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bridgelabz.noteservice.response.Response;



public class ResponseSender {

	
//	public static ResponseEntity<ResponseToken> sendResponse(String msg,int code,String token)
//	{
//		ResponseToken response = new ResponseToken();
//
//		response.setMessage(msg);
//		response.setStatus(code);
//		response.setTimeStamp(System.currentTimeMillis());
//		response.setToken(token);
//		
//		return new ResponseEntity<>(response,HttpStatus.OK) ;	
//	}
	
	public static ResponseEntity<Response> sendResponse(String msg,int code)
	{
		Response response = new Response();

		response.setMessage(msg);
		response.setStatus(code);
		response.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(response,HttpStatus.OK) ;	
	}
	
//	public static ResponseEntity<ResponseImage> sendResponseWithImage(String msg,int code,String url )
//	{
//		ResponseImage response = new ResponseImage();
//
//		response.setMessage(msg);
//		response.setStatus(code);
//		response.setTimeStamp(System.currentTimeMillis());
//		response.setUrl(url);
//		return new ResponseEntity<>(response,HttpStatus.OK) ;	
//	}
//	
//	public static ResponseEntity<ResponseUser> sendResponse(String msg,int code,String emailid,String name)
//	{
//		ResponseUser response = new ResponseUser();
//
//		response.setMessage(msg);
//		response.setStatus(code);
//		response.setTimeStamp(System.currentTimeMillis());
//		response.setEmailid(emailid);
//		response.setName(name);
//		return new ResponseEntity<>(response,HttpStatus.OK) ;	
//	}
}
	