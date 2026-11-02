package com.amit.spingSecurity.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.amit.spingSecurity.entity.AppUser;
import com.amit.spingSecurity.entity.Permission;
import com.amit.spingSecurity.entity.Role;

public class UserPrincipal implements UserDetails {

	@Autowired
	private AppUser appUser;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		for(Role role : appUser.getRoles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+ role.getName()));
			
			for (Permission permission : role.getPermissions()) {
				authorities.add(new SimpleGrantedAuthority(permission.getName()));
			}
		}
		
		return authorities;
	}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return appUser.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return appUser.getUsername();
	}

}
