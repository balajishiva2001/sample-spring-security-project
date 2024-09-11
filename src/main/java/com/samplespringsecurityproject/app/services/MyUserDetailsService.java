package com.samplespringsecurityproject.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.samplespringsecurityproject.app.entities.UserEntity;
import com.samplespringsecurityproject.app.entities.UserPrincipal;
import com.samplespringsecurityproject.app.repos.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepo.findByUsername(username);
		if (userEntity == null) {
			System.out.println("User details not found");
		}
		return new UserPrincipal(userEntity);
	}

}
