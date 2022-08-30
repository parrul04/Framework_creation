package stepdefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.framework.factory.DriverFactory;
import com.framework.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	DriverFactory driverfactory;
	WebDriver driver;
	Properties prop;
	
	
	/**
	 * To set the driver Frist we need Browser that we need to read from properties class
	 */
	
	@Before(order = 0)
	public void getProperty() {
		ConfigReader cr = new ConfigReader();
		prop = cr.init_prop();
	}
	
	/**
	 * Will set the driver based on the Browser we pass
	 **/
	@Before(order = 1)
	public void launchDriver() {
		String browserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.setDriver(browserName); 
	}
	
	@After(order = 0)
	public void quitDriver() {
		driver.quit();
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			//Take screenshot
			
			String screenShotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); // Will store the screenShot a sourcePath
			
			//Now attatch the screenshot
			
			scenario.attach(sourcePath, "image/png", screenShotName);
			
		}
	}
	
}
