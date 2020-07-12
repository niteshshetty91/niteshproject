package com.nitesh.spring.project.controller;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.nitesh.spring.project.model.PremuimMode;
import com.nitesh.spring.project.util.CustomHttpStatus;
import com.nitesh.spring.project.util.JwtTokenUtil;

public class Test {

	public static void main(String arsg[]) {

		String username = "nitesh";
		String password = "shetty";


		UserDetails userDetails = new User("javainuse", "1234",new ArrayList<>());


		String token = JwtTokenUtil.generateToken(userDetails);
		
		System.out.println(token);
		
		boolean flag = JwtTokenUtil.validateToken(token, userDetails);

		System.out.println(flag);

		
		System.out.println(CustomHttpStatus.NEW_USER.statusDesc());
	}

}
