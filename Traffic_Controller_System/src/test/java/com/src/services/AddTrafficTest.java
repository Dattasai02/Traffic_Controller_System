package com.src.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddTrafficTest {
	
	public void addTraffic(WebDriver driver) {
		
		driver.get("http://localhost:8080/Traffic_Controller_System/index.jsp");
		
		WebElement link = driver.findElement(By.linkText("Admin"));
		link.click();
		
		WebElement idField = driver.findElement(By.id("admid"));
		idField.sendKeys("TSPS525");
		
		WebElement pswdField = driver.findElement(By.id("admpswd"));
		pswdField.sendKeys("Dattu@2002");
		
		driver.findElement(By.name("adminlogin")).click();
		
		WebElement link1 = driver.findElement(By.linkText("Dashboard"));
		link1.click();
		
		WebElement link2 = driver.findElement(By.linkText("ADD TRAFFIC"));
		link2.click();
				
		
		WebElement trafficid = driver.findElement(By.name("trafficid"));
		trafficid.sendKeys("TSAP07");
		
		WebElement routetype = driver.findElement(By.name("trafficroutetype"));
		Select rt = new Select(routetype);
		rt.selectByVisibleText("Other Roads");
		
		WebElement trafficreason = driver.findElement(By.name("traffictype"));
		Select tr = new Select(trafficreason);
		tr.selectByVisibleText("Other");
		
		WebElement traffictime = driver.findElement(By.name("traffictime"));
		traffictime.sendKeys("7 pm");
		
		WebElement trafficstatus = driver.findElement(By.name("trafficstatus"));
		Select ts = new Select(trafficstatus);
		ts.selectByVisibleText("Low");
		
		WebElement trafficlocation = driver.findElement(By.name("trafficlocation"));
		trafficlocation.sendKeys("Madhapur");
		
		driver.findElement(By.name("addtraffic")).click();
		
		WebElement link4 = driver.findElement(By.linkText("Logout"));
		link4.click();
		
		
		
	}

}
