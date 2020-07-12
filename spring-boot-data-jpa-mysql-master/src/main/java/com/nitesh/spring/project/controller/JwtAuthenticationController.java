package com.nitesh.spring.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nitesh.spring.project.model.Policy;
import com.nitesh.spring.project.model.TempUser;
import com.nitesh.spring.project.repository.PolicyRepository;
import com.nitesh.spring.project.repository.TempUserRepository;
import com.nitesh.spring.project.response.JsonResponse;
import com.nitesh.spring.project.util.CustomHttpStatus;
import com.nitesh.spring.project.util.JwtTokenUtil;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	PolicyRepository policyRepository;
	
	@Autowired
	TempUserRepository tempUserRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<JsonResponse> securityToken(@RequestParam("mobileNumber") String mobileNumber,@RequestParam("otp") String otp) {
		JsonResponse jsonResponse = new JsonResponse();
		try {

			List<Policy> policyList = policyRepository.findByMobileNumber(mobileNumber);

			if (policyList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {


				TempUser tempUser = new TempUser();
				tempUser.setCreatedTime(new java.sql.Date(System.currentTimeMillis()));
				tempUser.setExpireTime(new java.sql.Date(System.currentTimeMillis()+3600000)); // token expires in 1 hour
				tempUser.setMobileNumber(mobileNumber);
				tempUser.setOtp(otp);

				tempUserRepository.save(tempUser);
				
				UserDetails userDetails = new User(mobileNumber, otp,new ArrayList<>());
				String token = jwtTokenUtil.generateToken(userDetails);

				jsonResponse.setToken(token);
				jsonResponse.setStatus(CustomHttpStatus.NEW_USER.statusCode());

				//ObjectMapper mapper = new ObjectMapper();
				//json = mapper.writeValueAsString(jsonResponse);


			}

			return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}


	}	

}
