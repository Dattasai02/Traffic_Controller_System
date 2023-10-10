package com.src.model;

import com.src.annotations.Constraint;
import com.src.annotations.Table;
import com.src.annotations.TableAnnotation;

@TableAnnotation
public class Admin {
	@Constraint(constraint="primary key")
	private String adminId ; 
	private String adminName ; 
	private String adminPassword ; 
	private long adminMobNum ; 
	private String adminEmail ;
	
	//constructors
	public Admin(String adminId, String adminName, String adminPassword, long adminmobnum, String adminemail) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminMobNum = adminmobnum;
		this.adminEmail = adminemail;
	}

	public Admin() {
		if(this.getClass().isAnnotationPresent(TableAnnotation.class)) {
			Table.createTable(this.getClass().getCanonicalName());
		}
	}

	public Admin(String adminId, String adminPassword) {
		this.adminId = adminId;
		this.adminPassword = adminPassword;
	}

	//getters and setters
	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public long getAdminmobnum() {
		return adminMobNum;
	}

	public void setAdminmobnum(long adminmobnum) {
		this.adminMobNum = adminmobnum;
	}

	public String getAdminemail() {
		return adminEmail;
	}

	public void setAdminemail(String adminemail) {
		this.adminEmail = adminemail;
	} 
	
	
	
	
	

}
