 package com.bridgelabz.userservice.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.userservice.dto.LoginDto;
import com.bridgelabz.userservice.dto.UserDto;
import com.bridgelabz.userservice.model.User;
import com.bridgelabz.userservice.response.Response;
import com.bridgelabz.userservice.response.ResponseToken;
import com.bridgelabz.userservice.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*",exposedHeaders={"jwtTokens"})

public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/getall")
	@ApiOperation(value = "api to get all the user details from the  database")
	public List<User> findAll() {
		return userService.findAll();
	}

	@PostMapping("/login")
	@ApiOperation(value = "api for a user to login to fundoo app")
	public ResponseEntity<ResponseToken> Login(@RequestBody LoginDto loginDto) throws UnsupportedEncodingException {

		return userService.onLogin(loginDto);
	}

	@PostMapping("/register")
	@ApiOperation(value = "api to register a user for fundoo app")
	public ResponseEntity<Response> registerUser(@RequestBody UserDto userDtO) throws UnsupportedEncodingException {
		System.out.println(userDtO.getEmailid());
		return userService.onRegister(userDtO);
	}

	@PostMapping(value = "/forgetpassword")
	@ApiOperation(value = "api for user when user forgot password")
	public ResponseEntity<Response> forgotPassword(@RequestParam(name="emailid") String emailid) throws UnsupportedEncodingException {
		System.out.println(emailid);
		return userService.forgetPassword(emailid);
	}

	@PutMapping(value = "/resetPassword/{token}")
	@ApiOperation(value = "api to reset the password of a paticular user" )
	public ResponseEntity<Response> resetPassword(@PathVariable String token, @RequestParam(name = "password") String password)
			throws UnsupportedEncodingException {
		System.out.println("token " + token + " ,  password" + password);
		return userService.resetPassword(token, password);
	}

	@PutMapping(value = "/validEmail/{token}")
	@ApiOperation(value = "api to validate the user through mail")
	public ResponseEntity<Response> validEmail(@PathVariable String token) throws UnsupportedEncodingException {
		 System.out.println("token "+token);

		return userService.validEmail(token);
	}

}
