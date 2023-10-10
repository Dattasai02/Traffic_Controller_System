package com.src.model;

import com.src.annotations.Constraint;
import com.src.annotations.Table;
import com.src.annotations.TableAnnotation;
@TableAnnotation
public class Customer {
	@Constraint(constraint="primary key")
	private String customerId ; 
	private String customerName ; 
	private String customerPassword ; 
	private long customerMobNum ; 
	private String customerEmail ;
	public Customer(String customerId, String customerName, String customerPassword, long customerMobNum,
			String customerEmail) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.customerMobNum = customerMobNum;
		this.customerEmail = customerEmail;
	}
	public Customer() {
		if(this.getClass().isAnnotationPresent(TableAnnotation.class)) {
			Table.createTable(this.getClass().getCanonicalName());
		}

	}
	public Customer(String customerId, String customerPassword) {
		this.customerId = customerId;
		this.customerPassword = customerPassword;
		
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
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public long getCustomerMobNum() {
		return customerMobNum;
	}
	public void setCustomerMobNum(long customerMobNum) {
		this.customerMobNum = customerMobNum;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

}
