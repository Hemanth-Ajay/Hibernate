package com.example.Hibernate.controller;

import com.example.Hibernate.entity.UserEntity;
import com.example.Hibernate.restmodel.JWTToken;
import com.example.Hibernate.restmodel.LoginModel;
import com.example.Hibernate.service.MyUserDetailService;
import com.example.Hibernate.service.UserService;
import com.example.Hibernate.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.Hibernate.entity.StudentEntity;
import com.example.Hibernate.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	 AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailService myUserDetailService;

	@Autowired
	private JWTUtility jwtUtility;

	@GetMapping("getById/{id}")
	private StudentEntity getByStudentId(@PathVariable Long id) {
		if (id == 0) {
			throw new IllegalStateException("Id Field should not be empty");
		}
		StudentEntity enStudentEntity = studentService.getByStudentId(id);
		return enStudentEntity;

	}

     @PostMapping("/createuser")
	private UserEntity createUser(@RequestBody UserEntity userEntity){
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

		 return  userService.createUser(userEntity);
	 }
	 //new code for JWT
	 @PostMapping("/authenticate")
	private JWTToken createTicket(@RequestBody LoginModel loginModel) throws Exception {
		try{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginModel.getUserName()
			,loginModel.getPassword()));

		}
		catch (BadCredentialsException e) {
			throw new Exception("User is not Valid " + loginModel.getUserName(), e);
		}
			User user= (User)myUserDetailService.loadUserByUsername(loginModel.getUserName());
		 final String token = jwtUtility.generateToken(user);
		 return new JWTToken(token);
	 }

}
