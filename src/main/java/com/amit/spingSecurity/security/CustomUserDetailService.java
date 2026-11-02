package com.amit.spingSecurity.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.amit.spingSecurity.entity.AppUser;
import com.amit.spingSecurity.repo.UserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user= userRepository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("user not found: "+ username));
		
		return new User(user.getUsername(),user.getPassword(),List.of());
	}

}
