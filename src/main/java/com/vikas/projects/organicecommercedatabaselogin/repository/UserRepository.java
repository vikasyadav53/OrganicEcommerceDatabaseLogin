package com.vikas.projects.organicecommercedatabaselogin.repository;

import org.springframework.stereotype.Repository;

import com.vikas.projects.organicecommercedatabaselogin.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
	User findByUserName(String userName);

}
