package com.samplespringsecurityproject.app.utils;

import org.springframework.stereotype.Component;

import com.samplespringsecurityproject.app.dtos.UserDto;
import com.samplespringsecurityproject.app.entities.UserEntity;

@Component
public class ModelMapper {
	
	public UserEntity mapToUserEntity(UserDto userDto) {
		return new UserEntity(userDto.getId(), userDto.getUsername(), userDto.getPassword());
	}
	
	public UserDto mapToUserDto(UserEntity userEntity) {
		return new UserDto(userEntity.getId(), userEntity.getUsername(), userEntity.getPassword());
	}
}
