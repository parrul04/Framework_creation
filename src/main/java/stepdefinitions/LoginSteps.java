package stepdefinitions;

import java.util.Properties;

import org.junit.*;
import org.junit.Assert;

import com.framework.factory.DriverFactory;
import com.framework.pages.LoginPage;
import com.framework.utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	Properties prop;

	@Given("User should be on login page https:\\/\\/qa.biskane.com\\/login")
	public void user_should_be_on_login_page_https_qa_biskane_com_login() throws InterruptedException {
		
		// Launch the url
		
		ConfigReader cr = new ConfigReader();
		prop = cr.init_prop();
		DriverFactory.getDriver().get(prop.getProperty("url"));
		
		// Verify the url
	    boolean result = lp.isLoginUrlCorrect();
	    Assert.assertTrue("Login Unsuccessful", result);
	    System.out.println("************Login Successfully***************");
	    
	}

	@When("User enters valid username {string}")
	public void user_enters_valid_username(String email) {
		lp.sendEmailId(email);
	}

	@When("User enters valid password {string}")
	public void user_enters_valid_password(String password) {
	   lp.sendPassword(password);
	}

	@When("User clicks on SignIn button")
	public void user_clicks_on_sign_in_button() {
		lp.clickSignIn();
	}

	@Then("User shoud navigate to his DashBoard")
	public void user_shoud_navigate_to_his_dash_board() throws InterruptedException {
		boolean result = lp.verifyDashBoard();
		Assert.assertTrue("User is not on Dashboard", result);
		System.out.println("User is On dashBoard");
	}

	@Then("User logout from dashboard")
	public void user_logout_from_dashboard() throws InterruptedException {
		lp.clickLogout();
		  boolean result = lp.isLoginUrlCorrect();
		    Assert.assertTrue("User is logOut Successfully", result);
	}

}
