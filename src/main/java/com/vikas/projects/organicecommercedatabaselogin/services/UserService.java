package com.vikas.projects.organicecommercedatabaselogin.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vikas.projects.organicecommercedatabaselogin.models.Role;
import com.vikas.projects.organicecommercedatabaselogin.models.User;
import com.vikas.projects.organicecommercedatabaselogin.repository.RoleRepository;
import com.vikas.projects.organicecommercedatabaselogin.repository.UserRepository;

@Service
public class UserService {
	
	
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	
	@Autowired
	public UserService(UserRepository userRepo, RoleRepository roleRepo, BCryptPasswordEncoder bcryptpwd) {
		this.userRepository = userRepo;
		this.roleRepository = roleRepo;
		this.bCryptPasswordEncoder = bcryptpwd;
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	
	public User findUserbyUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		Role userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		
		return userRepository.save(user);
	}
	
	
	
	
	
	
	

}
