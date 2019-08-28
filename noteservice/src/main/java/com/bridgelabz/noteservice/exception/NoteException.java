package com.bridgelabz.noteservice.exception;

public class NoteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	int errorCode;
	String msg;

	public NoteException(String msg) {
		super(msg);
	}

	public NoteException(int errorCode, String msg) {
		super(msg);
		this.errorCode = errorCode;

	}

}
