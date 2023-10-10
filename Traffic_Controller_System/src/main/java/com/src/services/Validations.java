package com.src.services;

public class Validations {
	
	public boolean checkId(String s) {
		
		boolean result=false ; 
		boolean caps = false ; 
		boolean nums = false ; 
		
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch>='a' && ch<='z') {
				return false ;
			}
			else if(ch>='A' && ch<='Z') {
				caps=true ; 
			}
			else if(ch>='0' && ch<='9') {
				nums=true ; 
			}
		}
		if(caps && nums) result=true ; 
		return result ; 
	}
	public boolean checkPassword(String s) {
		boolean spcl = false ; 
		boolean lower =  false ; 
		boolean upper =  false ; 
		boolean nums = false ; 
		
		boolean result = false ;
		
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch>='a' && ch<='z') {
				lower=true ; 
			}
			else if(ch>='A' && ch<='Z') {
				upper=true ; 
			}
			else if(ch>='0' && ch<='9') {
				nums=true ; 
			}
			else {
				spcl = true ; 
			}
		}
		
		
		if(spcl && lower && upper && nums) result = true ; 
		return result ; 
		
		
		
		
		
	}

}
