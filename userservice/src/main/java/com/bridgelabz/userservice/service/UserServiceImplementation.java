package com.bridgelabz.userservice.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.userservice.dto.LoginDto;
import com.bridgelabz.userservice.dto.UserDto;
import com.bridgelabz.userservice.exception.UserException;
import com.bridgelabz.userservice.model.Mail;
import com.bridgelabz.userservice.model.User;
import com.bridgelabz.userservice.repository.UserRepository;
import com.bridgelabz.userservice.response.Response;
import com.bridgelabz.userservice.response.ResponseToken;
import com.bridgelabz.userservice.utility.EmailService;
import com.bridgelabz.userservice.utility.MailHelper;
import com.bridgelabz.userservice.utility.ResponseSender;
import com.bridgelabz.userservice.utility.TokenUtil;



@PropertySource("classpath:message.properties")
@Service
public class UserServiceImplementation implements UserService {
	



	@Autowired
	private	UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private Environment environment;
	
	 @Autowired
	    private EmailService emailService;
	 
	Date date = new Date();	

	String updateDate = date.toString();

	String registerDate = date.toString();

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public ResponseEntity<ResponseToken> onLogin(LoginDto loginDto) throws UnsupportedEncodingException {

		User user = modelMapper.map(loginDto, User.class);
		// System.out.println(user.getEmailid());

		User validUser = userRepository.findByEmailid(user.getEmailid())
				.orElseThrow(() -> new UserException(401, environment.getProperty("100")));
			String token  = TokenUtil.createToken(validUser.getId());
		System.out.println(validUser);
		if (validUser.isVerified()==true) {

			// match the loginDto password && validUser password
			boolean passwordStatus = passwordEncoder.matches(loginDto.getPassword(), validUser.getPassword());

			if (passwordStatus == false) {
				throw new UserException(401, environment.getProperty("100"));
			} else {
				
				return ResponseSender.sendResponse(environment.getProperty("200"), 200, token);
			}
		}
		return ResponseSender.sendResponse(environment.getProperty("404"),404,token);
	}

	public ResponseEntity<Response> onRegister(UserDto userDto) throws UserException, UnsupportedEncodingException {

		User user = modelMapper.map(userDto, User.class);
		System.out.println(user.getFirstName());
		Optional<User> useralreadyPresent = userRepository.findByEmailid(user.getEmailid());

		if (useralreadyPresent.isPresent()) {
			System.out.println(useralreadyPresent.isPresent());
			throw new UserException(401, environment.getProperty("101"));
		}

		String password = passwordEncoder.encode(userDto.getPassword());

		user.setPassword(password);

		user.setUpdateDate(updateDate);

		user.setRegisterDate(registerDate);
		user.setImage("circle-512.png");
		
		System.out.println(user.getImage());
		user = userRepository.save(user);
		System.out.println(user.getId());
		 Mail mail = new Mail();
	        mail.setFrom("venky70662@gmail.com");
	        mail.setTo(user.getEmailid());
	        mail.setSubject("verify your mail");
	        mail.setContent("http://localhost:4200/user/validEmail/"+MailHelper.getUrl(user.getId()));
	       emailService.sendSimpleMessage(mail);
		System.out.println(user.getImage());
		
		
		return ResponseSender.sendResponse(environment.getProperty("201"), 200);
	}

	
	 

	public ResponseEntity<Response> forgetPassword(String emailId) throws UserException, UnsupportedEncodingException {

		Optional<User> alreadyPresent = userRepository.findByEmailid(emailId);

		if (!alreadyPresent.isPresent()) {
			throw new UserException(401, environment.getProperty("102"));
		}

		Long id = alreadyPresent.get().getId();
		
		Mail mail = new Mail();
        mail.setFrom("venky70662@gmail.com");
        mail.setTo(emailId);
        mail.setSubject("link to reset your password");
        mail.setContent("http://localhost:4200/resetpassword/"+MailHelper.getUrl(id));
	       emailService.sendSimpleMessage(mail);
		return ResponseSender.sendResponse(environment.getProperty("203"), 200);
	}

	public  ResponseEntity<Response> resetPassword(String token, String password) throws UserException, UnsupportedEncodingException {
			
		Long userid = TokenUtil.decodeToken(token);

		Optional<User> alreadyPresent = userRepository.findById(userid);

		if (!alreadyPresent.isPresent()) {
			throw new UserException(401, environment.getProperty("103"));
		}

		String newpassword = passwordEncoder.encode(password);

		alreadyPresent.get().setPassword(newpassword);

		User user = alreadyPresent.get();

		user = userRepository.save(user);

		return ResponseSender.sendResponse(environment.getProperty("200"), 200);
	}
		

	public  ResponseEntity<Response> validEmail(String token) throws UserException, UnsupportedEncodingException {
		

		Long userid = TokenUtil.decodeToken(token);

		Optional<User> alreadyPresent = userRepository.findById(userid);

		if (!alreadyPresent.isPresent()) {
			throw new UserException(401, environment.getProperty("104"));
		}
		alreadyPresent.get().setVerified(true);

		User user = alreadyPresent.get();

		user = userRepository.save(user);
		
		return ResponseSender.sendResponse(environment.getProperty("200"), 200);
		}
}
