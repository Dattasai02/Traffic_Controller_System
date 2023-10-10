package com.src.mn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SelTest {
	
	static String browser = "edge";
	static WebDriver driver;

	public static void main(String[] args) {
		
		if (browser.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.facebook.com/");

		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-popup-blocking");
			driver = new EdgeDriver(options);
			driver.get("https://www.facebook.com/");
		}
	
		

	}

}
