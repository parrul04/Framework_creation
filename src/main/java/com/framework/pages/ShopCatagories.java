package com.framework.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.framework.utils.ConfigReader;

public class ShopCatagories {
	WebDriver driver;
	private Properties prop;
	LoginPage lp = new LoginPage(driver);

	private By home = By.id("home");
	private By shopNow = By.xpath("//div[@class='carousel-item ng-star-inserted active']//a[text()='Shop now']");
	private By categories = By.xpath("//section[@id='searchart']//div[@data-aos='fade-up']");
	private By dashboard = By.id("dashboard");

	public ShopCatagories(WebDriver driver) {
		this.driver = driver;
	}

	// Actions

	public void clickHome() {
		driver.findElement(home).click();
	}

	public void clickShopNow() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(shopNow).click();
	}

	public boolean isShopPageUrlCorrect() throws InterruptedException {
		Thread.sleep(2000);
		ConfigReader cr = new ConfigReader();
		prop = cr.init_prop();
		return driver.getCurrentUrl().contains(prop.getProperty("shopPageURL"));

	}

	public int countCategories() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElements(categories).size();
	}
	
	
	public void getingCategories_Text() throws InterruptedException {
		
	
		List<WebElement> categoriesList = driver.findElements(categories);
		
//		ArrayList<String> categories = new ArrayList<>();
		
		for(WebElement e : categoriesList) {
			String text = e.getText();
			System.out.println(text);
//			categories.add(text);
		}
		
	}

	public void clickDashBoard() {
		driver.findElement(dashboard).click();
	}

}
