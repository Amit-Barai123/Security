package com.amit.spingSecurity.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class LoginRequest {

	
	private String username;
	
	private String password;
	
}
