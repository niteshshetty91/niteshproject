package com.nitesh.spring.project.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "Policy")
@ApiModel(description = "Details of the property")
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Policy_Number")
	@ApiModelProperty("Unique policy number mapped to Each Customer")
	private int policyNumber;

	@ApiModelProperty("Unique Id assigned to Customer")
	@Column(name = "Customer_Id")
	private String customerId;

	@ApiModelProperty("Name of the Customer")
	@Column(name ="Customer_Name")
	private String customerName;
	
	//
	//Insured Name, 
	@ApiModelProperty("Name of the Insured Person")
	@Column(name ="Insured_Name")
	private String insuredName;

	//
	//DOB, 
	@ApiModelProperty("Customer's Date of Birth")
	@Column(name ="Dob")
//	@Temporal(TemporalType.DATE)
	private Date dob;
	
	
	//
	//Email Address,
	@ApiModelProperty("Customer's Email Address")
	@Column(name ="Email_Address")
	private String emailAddress;

	
	//
	//Mobile Number,
	@ApiModelProperty("Customer's Mobile No")
	@Column(name ="Mobile_Number")
	private String mobileNumber;

	
	//
	//Premium Mode[Monthly,Half Yearly, Yearly],
	@ApiModelProperty("Premium Mode")
	@Column(name ="Premium_Mode")
	@Enumerated(EnumType.STRING)
	private PremuimMode premiumMode;

	
	//
	//Policy Status[Active,Inactive],
	//

	@ApiModelProperty("Policy Status")
	@Column(name ="Policy_Status")
	@Enumerated(EnumType.STRING)
	private PolicyStatus policyStatus;

	
	
	//Customer PAN NO, 
	@ApiModelProperty("Customers PAN No")
	@Column(name ="Customer_Pan_No")
	private String customerPanNo;

	
	//
	//Policy Issuance Date,
	@ApiModelProperty("Policy Issuance Date")	
	@Column(name ="Policy_Issuance_Date")
	private Date policyIssuanceDate;
	
	//
	//Contact Number Last_updated,
	@Column(name ="Contact_Number_Last_Updated")
	@ApiModelProperty("Customers Contact Number")	
	private String contactNumberLastUpdated;

	
	
	//
	//Email Address Last_updated,
	@ApiModelProperty("Customers Email Address")	
	@Column(name ="Email_Address_Last_Updated")
	private String emailAddressLastUpdated;

	
	//
	//Bank Account Number, 
	@ApiModelProperty("Customers Bank Account Number")	
	@Column(name ="Bank_Account_Number")
	private String bankAccountNumber;
	
	
	//
	//whatsapp_opt_in_status,
	@ApiModelProperty("Whether the Customer opted whatsapp or not")	
	@Column(name ="Whatsapp_Opt_In_Status")
	private String whatsappOptInStatus;

	
	//
	//Product Name,
	@ApiModelProperty("Product Name")	
	@Column(name ="Product_Name")
	private String productName;

	
	//
	//Product ID,
	@ApiModelProperty("Product ID")	
	@Column(name ="Product_Id")
	private String productId;
	
	
	
	//Reinvest Applicable[Boolean], 
	@ApiModelProperty("Whether Reivestment is applicable or not")	
	@Column(name ="Reinvest_Applicable")
	private boolean reinvestApplicable; 
	
	//
	//Outstanding Payout,
	@Column(name ="Outstanding_Payout")
	@ApiModelProperty("Outstanding Payment Amount")	
	private double outstandingPayout; 
	
	
	//
	//Unclaimed Amount,
	@Column(name ="Unclaimed_Amount")
	@ApiModelProperty("Unclaimed Amount")	
	private double unclaimedAmount; 
	
	//
	//NEFT Registered[Boolean] ,
	@Column(name ="NEFT_Registered")
	@ApiModelProperty("Neft Registered or Not")	
	private boolean neftRedoublegistered; 
	
	//
	//Last Premium Paid[Y,N]}
	@Column(name ="Last_Premium_Paid")
	@Enumerated(EnumType.STRING)
	@ApiModelProperty("Last Premium Paid Date")	
	private LastPremiumPaid lastPremiumPaid;

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public PremuimMode getPremiumMode() {
		return premiumMode;
	}

	public void setPremiumMode(PremuimMode premiumMode) {
		this.premiumMode = premiumMode;
	}

	public PolicyStatus getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(PolicyStatus policyStatus) {
		this.policyStatus = policyStatus;
	}

	public String getCustomerPanNo() {
		return customerPanNo;
	}

	public void setCustomerPanNo(String customerPanNo) {
		this.customerPanNo = customerPanNo;
	}

	public Date getPolicyIssuanceDate() {
		return policyIssuanceDate;
	}

	public void setPolicyIssuanceDate(Date policyIssuanceDate) {
		this.policyIssuanceDate = policyIssuanceDate;
	}

	public String getContactNumberLastUpdated() {
		return contactNumberLastUpdated;
	}

	public void setContactNumberLastUpdated(String contactNumberLastUpdated) {
		this.contactNumberLastUpdated = contactNumberLastUpdated;
	}

	public String getEmailAddressLastUpdated() {
		return emailAddressLastUpdated;
	}

	public void setEmailAddressLastUpdated(String emailAddressLastUpdated) {
		this.emailAddressLastUpdated = emailAddressLastUpdated;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getWhatsappOptInStatus() {
		return whatsappOptInStatus;
	}

	public void setWhatsappOptInStatus(String whatsappOptInStatus) {
		this.whatsappOptInStatus = whatsappOptInStatus;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public boolean isReinvestApplicable() {
		return reinvestApplicable;
	}

	public void setReinvestApplicable(boolean reinvestApplicable) {
		this.reinvestApplicable = reinvestApplicable;
	}

	public double getOutstandingPayout() {
		return outstandingPayout;
	}

	public void setOutstandingPayout(double outstandingPayout) {
		this.outstandingPayout = outstandingPayout;
	}

	public double getUnclaimedAmount() {
		return unclaimedAmount;
	}

	public void setUnclaimedAmount(double unclaimedAmount) {
		this.unclaimedAmount = unclaimedAmount;
	}

	public boolean isNeftRedoublegistered() {
		return neftRedoublegistered;
	}

	public void setNeftRedoublegistered(boolean neftRedoublegistered) {
		this.neftRedoublegistered = neftRedoublegistered;
	}

	public LastPremiumPaid getLastPremiumPaid() {
		return lastPremiumPaid;
	}

	public void setLastPremiumPaid(LastPremiumPaid lastPremiumPaid) {
		this.lastPremiumPaid = lastPremiumPaid;
	} 

	
	
}