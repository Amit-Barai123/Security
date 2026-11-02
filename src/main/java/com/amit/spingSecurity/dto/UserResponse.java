package com.amit.spingSecurity.dto;

import java.util.Set;

import com.amit.spingSecurity.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

	private Long id;
	private String username;
	private Set<String> roles;
	private Set<String> permissions;
	
}
