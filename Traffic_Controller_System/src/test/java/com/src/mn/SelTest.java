package com.src.mn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.src.services.AddTrafficTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelTest {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		AddTrafficTest at = new AddTrafficTest();
		at.addTraffic(driver);
		
	}

}
