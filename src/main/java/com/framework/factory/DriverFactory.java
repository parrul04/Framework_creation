package com.framework.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	//public WebDriver driver;
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	/**
	 * 
	 * this method is used to set the threadlocal driver based on the browser
	 * @param browser
	 * @return this will return the webdriver
	 */
	public WebDriver setDriver(String browser) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}
		
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
		
		else {
			System.out.println("Please pass the correct browser value: " + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
/**
 * This is used to get the driver from thread local
 * 
 * @return
 */
	public static WebDriver getDriver() {
		return driver.get();
	}
}
