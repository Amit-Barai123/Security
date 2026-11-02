package com.amit.spingSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/")
	public String test() {
		return "welcome to spring security";
	}
	
	@GetMapping("/api/demo")
	public String demo() {
		return "welcome to  spring security authicated demo routes";
	}
	
	
	
}
