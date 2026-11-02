package com.amit.spingSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amit.spingSecurity.dto.UserResponse;
import com.amit.spingSecurity.service.UserService;

@RestController
@RequestMapping("/api")
public class SecurityDemoController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('Admin')")
	public String adminOnly() {
		return "Hello admin you passed role admin Authorization";
	}
	
	@GetMapping("/reports")
	@PreAuthorize("hasAuthority(REPORT_READ)")
	public String readReports() {
		return "you have report Read Permission";
	}
	
	@PostMapping("/createReports")
	@PreAuthorize("hasAuthority(REPORT_CREATE)")
	public String CreateReports() {
		return "you have report create Permission";
	}

	@GetMapping("/admin/Reports")
	@PreAuthorize("hasAuthority(REPORT_CREATE)")
	public String adminReports() {
		return "you have report create and admin Role Permission";
	}
	
	@GetMapping("/user/me")
	@PreAuthorize("hasAuthority('USER_READ')")
	public UserResponse currentUser(Authentication authentication) {
		return userService.getByUserName(authentication.getName());
	}
	
}
