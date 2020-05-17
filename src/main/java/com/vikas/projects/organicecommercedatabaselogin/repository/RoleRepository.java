package com.vikas.projects.organicecommercedatabaselogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vikas.projects.organicecommercedatabaselogin.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Role findByRole(String role);

}
