package com.amit.spingSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.spingSecurity.dto.LoginRequest;
import com.amit.spingSecurity.dto.LoginResponse;
import com.amit.spingSecurity.dto.SignUpRequest;
import com.amit.spingSecurity.entity.AppUser;
import com.amit.spingSecurity.repo.UserRepository;
import com.amit.spingSecurity.security.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody SignUpRequest request){
		if(userRepository.existsByUsername(request.getUsername())) {
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body("user already registerd");
			
		}
		
		AppUser user = new AppUser();
		
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		userRepository.save(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("user registerd sucessfully");
		
	}
	
	@PostMapping("/login")
	public LoginResponse login (@RequestBody LoginRequest request) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
				);
		
		String token = jwtService.generateToken((UserDetails)authentication.getPrincipal());
		
		return new LoginResponse(token, request.getUsername());
		
	}
	
	
}
