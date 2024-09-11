package com.samplespringsecurityproject.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.samplespringsecurityproject.app.dtos.UserDto;
import com.samplespringsecurityproject.app.entities.UserEntity;
import com.samplespringsecurityproject.app.repos.UserRepo;
import com.samplespringsecurityproject.app.utils.ModelMapper;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
	
	public void addUser(UserDto userDto) {
		UserEntity userEntity = modelMapper.mapToUserEntity(userDto);
		userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));
		userRepo.save(userEntity);
	}
}
