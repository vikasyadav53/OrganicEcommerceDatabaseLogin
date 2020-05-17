package com.vikas.projects.organicecommercedatabaselogin.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vikas.projects.organicecommercedatabaselogin.models.Role;
import com.vikas.projects.organicecommercedatabaselogin.models.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserbyUserName(username);
		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
		return buildUserForAuthentication(user, authorities);
	}
	
	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role role: userRoles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}		
		return authorities;
	}

	
	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), user.getActive(), true, true, true, authorities);
	}

}
