package com.samplespringsecurityproject.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samplespringsecurityproject.app.entities.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	
	UserEntity findByUsername(String username);
}
