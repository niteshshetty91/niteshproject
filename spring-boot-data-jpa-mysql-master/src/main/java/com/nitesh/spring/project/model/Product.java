package com.nitesh.spring.project.model;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Product_ID")
	private String productId;

	@Column(name = "Product_Name")
	private String productName;

	@Column(name = "Product_Details")
	private String productDetails;

	@Column(name = "Product_Launch_Date")
	private String productLaunchDate;

	@Column(name = "Product_End_Date")
	private String productEndDate;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public String getProductLaunchDate() {
		return productLaunchDate;
	}

	public void setProductLaunchDate(String productLaunchDate) {
		this.productLaunchDate = productLaunchDate;
	}

	public String getProductEndDate() {
		return productEndDate;
	}

	public void setProductEndDate(String productEndDate) {
		this.productEndDate = productEndDate;
	}
	
}
