package com.perFectExample.demo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perFectExample.demo.security.model.User;

public interface UserService extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
