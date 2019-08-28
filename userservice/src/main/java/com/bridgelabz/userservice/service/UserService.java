package com.bridgelabz.userservice.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bridgelabz.userservice.dto.LoginDto;
import com.bridgelabz.userservice.dto.UserDto;
import com.bridgelabz.userservice.exception.UserException;
import com.bridgelabz.userservice.model.User;
import com.bridgelabz.userservice.response.Response;
import com.bridgelabz.userservice.response.ResponseToken;


@Service
public interface UserService {
	public ResponseEntity<ResponseToken> onLogin(LoginDto loginDto) throws UnsupportedEncodingException;

	public ResponseEntity<Response> onRegister(UserDto userDto) throws UserException, UnsupportedEncodingException;

	public ResponseEntity<Response> forgetPassword(String emailId) throws UserException, UnsupportedEncodingException;

	public  ResponseEntity<Response> resetPassword(String token, String password) throws UserException, UnsupportedEncodingException;

	public ResponseEntity<Response> validEmail(String token) throws UserException, UnsupportedEncodingException;

	public List<User> findAll();
}
