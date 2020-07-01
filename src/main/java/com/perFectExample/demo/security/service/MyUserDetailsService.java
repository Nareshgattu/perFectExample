package com.perFectExample.demo.security.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.perFectExample.demo.security.repository.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userSevice;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// return new User("gattu", "gattu", new ArrayList<>());
		com.perFectExample.demo.security.model.User usr = userSevice.findByUsername(username);
		if (usr.getUsername() != null) {
			return new User(usr.getUsername(), usr.getPassword(), new ArrayList<>());
			// return uimp;
		}
		throw new UsernameNotFoundException("User Not found.....");
	}

}
