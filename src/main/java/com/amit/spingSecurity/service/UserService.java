package com.amit.spingSecurity.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.spingSecurity.dto.UserResponse;
import com.amit.spingSecurity.entity.AppUser;
import com.amit.spingSecurity.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserResponse getByUserName(String username) {
		
		AppUser appUser = userRepository.findByUsername(username)
				.orElseThrow(()-> new RuntimeException("user not found: "+ username));
		
		Set<String> roles = appUser.getRoles()
				.stream().map(Role-> Role.getName())
				.collect(Collectors.toSet());
		
		Set<String> permissions = appUser.getRoles()
				.stream()
				.flatMap(role-> role.getPermissions().stream())
				.map(Permission-> Permission.getName())
				.collect(Collectors.toSet());
		
		return new UserResponse(appUser.getId(), appUser.getUsername(),
				roles, permissions);
	}
	
}
