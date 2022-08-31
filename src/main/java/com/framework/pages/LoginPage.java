package com.framework.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.framework.utils.ConfigReader;

public class LoginPage {
	

	WebDriver driver;
	Properties prop;
	// Locators
	
	private By emailId = By.id("name");
	private By password = By.id("password");
	private By signIn = By.id("btn_send");
	private By dashboard = By.id("dashboard");
	private By logout = By.xpath("//a[@class='logout hideOnMobile ng-star-inserted']");
	private By forgetPassword = By.xpath("//main[@id='main']/section[@class='gradiantbg']/div[@class='container']//a[@href='/forgot-password']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// Actions
	
	public boolean isLoginUrlCorrect() throws InterruptedException {
		Thread.sleep(1000);
		ConfigReader cr = new ConfigReader();
		prop = cr.init_prop();
		return driver.getCurrentUrl().contains(prop.getProperty("url"));
	}
	
	public void sendEmailId(String email) {
		driver.findElement(emailId).sendKeys(email);
	}
	
	public void sendPassword(String passWord) {
		driver.findElement(password).sendKeys(passWord);
	}
	
	public void clickSignIn() {
		driver.findElement(signIn).click();
	}
	
	public boolean verifyDashBoard() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(dashboard).isDisplayed();
	}
	
	public void clickLogout() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(logout).click();
	}
	
	public ShopCatagories doLogin(String email, String password) {
		sendEmailId(email);
		sendPassword(password);
		clickSignIn();
		return new ShopCatagories(driver);
	}
	
	public boolean idDisplayed_ForgetPassword()  throws InterruptedException {
		Thread.sleep(2000);
		return driver.findElement(forgetPassword).isDisplayed();
	}
}
