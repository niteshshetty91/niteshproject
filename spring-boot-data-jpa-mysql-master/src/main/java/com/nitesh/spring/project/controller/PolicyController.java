package com.nitesh.spring.project.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nitesh.spring.project.model.AuditLog;
import com.nitesh.spring.project.model.Policy;
import com.nitesh.spring.project.model.TempUser;
import com.nitesh.spring.project.model.WhatsAppOptIn;
import com.nitesh.spring.project.repository.AuditRepository;
import com.nitesh.spring.project.repository.PolicyRepository;
import com.nitesh.spring.project.repository.TempUserRepository;
import com.nitesh.spring.project.repository.WhatsAppOptInRepository;
import com.nitesh.spring.project.response.JsonResponse;
import com.nitesh.spring.project.util.CustomHttpStatus;
import com.nitesh.spring.project.util.JwtTokenUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class PolicyController {

	@Autowired
	PolicyRepository policyRepository;

	@Autowired
	AuditRepository auditRepository;

	//@Autowired
	//private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;


	@Autowired
	WhatsAppOptInRepository whatsAppOptInRepository;

	@Autowired
	TempUserRepository tempUserRepository;




	/*
	@GetMapping("/authenticate/token")
	public ResponseEntity<String> securityToken(@RequestParam("mobileNumber") String mobileNumber,@RequestParam("otp") String otp) {
		String json = "";
		try {

			List<Policy> policyList = policyRepository.findByMobileNumber(mobileNumber);

			if (policyList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {


				TempUser tempUser = new TempUser();
				tempUser.setCreatedTime(new java.sql.Date(System.currentTimeMillis()));
				tempUser.setExpireTime(new java.sql.Date(System.currentTimeMillis()+3600000)); // token expires in 1 hour
				tempUser.setMobileNumber(mobileNumber);

				UserDetails userDetails = new User(mobileNumber, otp,new ArrayList<>());
				String token = jwtTokenUtil.generateToken(userDetails);

				JsonResponse jsonResponse = new JsonResponse();
				jsonResponse.setToken(token);
				jsonResponse.setStatus(CustomHttpStatus.NEW_USER.statusCode());

				ObjectMapper mapper = new ObjectMapper();
				json = mapper.writeValueAsString(jsonResponse);


			}

			return new ResponseEntity<>(json, HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}


	}	
	 */

	@ApiOperation(
			value="Find policy by policyNumber",
			notes="Get all the policy Details By Passing Policy Number",
			response=JsonResponse.class
			)
	@GetMapping("/policy/{policyNumber}")
	public ResponseEntity<JsonResponse> getAllPolicy(@ApiParam(value = "Pass policy Number")@PathVariable String policyNumber) {

		JsonResponse jsonResponse;

		try {
			List<Policy> policyList = new ArrayList<Policy>();

			if (policyNumber == null)
				policyRepository.findAll().forEach(policyList::add);
			else
				policyRepository.findByPolicyNumber(Integer.parseInt(policyNumber)).forEach(policyList::add);

			if (policyList.isEmpty()) {

				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			jsonResponse = new JsonResponse();
			jsonResponse.setData(policyList);
			jsonResponse.setStatus(CustomHttpStatus.GET.statusCode());

			return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/policy/byMobileNumberAndDob")
	public ResponseEntity<JsonResponse> getPolicyByMobileNumberAndDob(@RequestParam("mobileNumber") String mobileNumber,@RequestParam("dob") Date dob) {

		JsonResponse jsonResponse;


		try {
			List<Policy> policyList = policyRepository.findByMobileNumberAndDob(mobileNumber, dob);

			if (policyList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			jsonResponse = new JsonResponse();
			jsonResponse.setData(policyList.get(0).getMobileNumber());
			jsonResponse.setStatus(CustomHttpStatus.VALIDATION.statusCode());


			return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/policy/byEmailAddressAndDob")
	public ResponseEntity<JsonResponse> getPolicyByEmailAddressAndDob(@RequestParam("emailAddress") String emailAddress,@RequestParam("dob") Date dob) {
		try {

			JsonResponse jsonResponse;

			List<Policy> policyList = policyRepository.findByEmailAddressAndDob(emailAddress, dob);

			if (policyList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			jsonResponse = new JsonResponse();
			jsonResponse.setData(policyList.get(0).getEmailAddress());
			jsonResponse.setStatus(CustomHttpStatus.VALIDATION.statusCode());

			return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/audit/emailAddress/byPolicyNumber")
	public ResponseEntity<JsonResponse> updateEmailbyPolicyNumber(@RequestParam("emailAddress") String emailAddress,@RequestParam("policyNumber") String policyNumber) {

		JsonResponse jsonResponse;

		try {

			List<Policy> policyList = policyRepository.findByPolicyNumber(Integer.parseInt(policyNumber));

			if (policyList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {

				AuditLog auditLog = new AuditLog();
				auditLog.setTableName("Policy");
				auditLog.setColumnName("emailAddress");
				auditLog.setColumnValue(emailAddress);
				auditLog.setRequestDate(new java.sql.Date(System.currentTimeMillis()));

				auditRepository.save(auditLog);
			}

			jsonResponse = new JsonResponse();
			jsonResponse.setData(policyList.get(0).getEmailAddress());
			jsonResponse.setStatus(CustomHttpStatus.REQUEST.statusCode());
			jsonResponse.setMessage("Service Request for Email Updation Generated");

			return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	


	@PutMapping("/audit/mobileNumber/byPolicyNumber")
	public ResponseEntity<JsonResponse> updateMobileNumberbyPolicyNumber(@RequestParam("mobileNumber") String mobileNumber,@RequestParam("policyNumber") String policyNumber) {

		JsonResponse jsonResponse;

		try {

			List<Policy> policyList = policyRepository.findByPolicyNumber(Integer.parseInt(policyNumber));

			if (policyList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {

				AuditLog auditLog = new AuditLog();
				auditLog.setTableName("Policy");
				auditLog.setColumnName("mobileNumber");
				auditLog.setColumnValue(mobileNumber);
				auditLog.setRequestDate(new java.sql.Date(System.currentTimeMillis()));

				auditRepository.save(auditLog);
			}

			jsonResponse = new JsonResponse();
			jsonResponse.setData(policyList.get(0).getMobileNumber());
			jsonResponse.setStatus(CustomHttpStatus.REQUEST.statusCode());
			jsonResponse.setMessage("Service Request for Mobile Number Updation Generated");

			return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	@PutMapping("/audit/customerPanNo/byPolicyNumber")
	public ResponseEntity<JsonResponse> updatecustomerPanNobyPolicyNumber(@RequestParam("customerPanNo") String customerPanNo,@RequestParam("policyNumber") String policyNumber) {

		JsonResponse jsonResponse;

		try {

			List<Policy> policyList = policyRepository.findByPolicyNumber(Integer.parseInt(policyNumber));

			if (policyList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {

				AuditLog auditLog = new AuditLog();
				auditLog.setTableName("Policy");
				auditLog.setColumnName("customerPanNo");
				auditLog.setColumnValue(customerPanNo);
				auditLog.setRequestDate(new java.sql.Date(System.currentTimeMillis()));

				auditRepository.save(auditLog);
			}

			jsonResponse = new JsonResponse();
			jsonResponse.setData(policyList.get(0).getCustomerPanNo());
			jsonResponse.setStatus(CustomHttpStatus.REQUEST.statusCode());
			jsonResponse.setMessage("Service Request for Customer Pan No Generated");

			return new ResponseEntity<>(jsonResponse, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	


	@PutMapping("/whatsApp/opt/step1")
	public ResponseEntity<JsonResponse> whatsAppOptStepOne(@RequestParam("mobileNumber") String mobileNumber) {

		JsonResponse jsonResponse;

		try {

			List<WhatsAppOptIn> whatsAppOpList = whatsAppOptInRepository.findByMobileNumber(mobileNumber);

			if (!whatsAppOpList.isEmpty()) {

				jsonResponse = new JsonResponse();
				jsonResponse.setStatus(CustomHttpStatus.OLD_USER.statusCode());
				jsonResponse.setMessage("Thank You for Optin Request Completed");

				return new ResponseEntity<>(jsonResponse,HttpStatus.OK);
			}else {

				List<Policy> policyList = policyRepository.findByMobileNumber(mobileNumber);

				if (policyList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}else {

					//Send OTP to mobile number

					jsonResponse = new JsonResponse();
					jsonResponse.setStatus(CustomHttpStatus.OTP_SENT.statusDesc());
					jsonResponse.setMessage("Optin OTP Sent on the Mobile Number");

					return new ResponseEntity<>(jsonResponse, HttpStatus.OK);

				}
			}

		} catch (Exception e) {

			e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PutMapping("/whatsApp/opt/step2")
	public ResponseEntity<JsonResponse> whatsAppOptStepTwo(@RequestParam("mobileNumber") String mobileNumber,@RequestParam("otp") String otp) {

		JsonResponse jsonResponse;

		try {

			List<TempUser> tempUserList = tempUserRepository.findByMobileNumberAndOtp(mobileNumber, otp);

			if (tempUserList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {

				List<Policy> policyList = policyRepository.findByMobileNumber(mobileNumber);

				if (policyList.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}else {

					WhatsAppOptIn whatsAppOptIn = new WhatsAppOptIn();
					whatsAppOptIn.setMobileNumber(mobileNumber);
					whatsAppOptIn.setOptinDate(new java.sql.Date(System.currentTimeMillis()));
					whatsAppOptIn.setPolicyNumber(policyList.get(0).getPolicyNumber());
					whatsAppOptInRepository.save(whatsAppOptIn);

				}
			}

			jsonResponse=new JsonResponse();
			jsonResponse.setMessage("Thank You for Optin Request Completed");

			return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
		} catch (Exception e) {

			e.printStackTrace();

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	///////////////////////////////////////////////////    not in use /////////////////////////////////////////////////////////////////////

	@PutMapping("/policy")
	public ResponseEntity<Policy> savePolicy(@RequestBody Policy policy) {

		return new ResponseEntity<>(policyRepository.save(policy), HttpStatus.OK);

	}

	/*
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken() throws Exception {

		UserDetails userDetails = new User("javainuse", "1234",new ArrayList<>());


		String token = JwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(token);
	}
	 */

}
