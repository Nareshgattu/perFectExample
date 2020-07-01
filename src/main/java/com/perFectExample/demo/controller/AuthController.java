package com.perFectExample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perFectExample.demo.security.jwt.JwtUtils;
import com.perFectExample.demo.security.model.AuthenticationRequest;
import com.perFectExample.demo.security.model.AuthenticationResponse;
import com.perFectExample.demo.security.model.UserDetailImpl;

@RestController
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;

	@RequestMapping("/signin")
	public ResponseEntity<?> doSigin(@RequestBody AuthenticationRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//		List<String> roles = userDetails.getAuthorities().stream()
//				.map(item -> item.getAuthority())
//				.collect(Collectors.toList());

		return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetails.getUsername()));
	}
}
