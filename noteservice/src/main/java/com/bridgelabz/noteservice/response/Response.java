package com.bridgelabz.noteservice.response;

public class Response 
{
	
	private String message;
	private long timeStamp;
	private int status;
	
	public Response() {

	}
	public Response(String message, long timeStamp, int status) {

		this.message = message;
		this.timeStamp = timeStamp;
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
	@Override
	public String toString() {
		return "UserErrorResponse [status=" + status + ", message=" + message + ", timeStamp=" + timeStamp + "]";
	}
	
	
	
}
