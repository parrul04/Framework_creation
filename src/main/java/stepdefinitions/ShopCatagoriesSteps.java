package stepdefinitions;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.*;
import org.junit.Assert;

import com.framework.factory.DriverFactory;
import com.framework.pages.LoginPage;
import com.framework.pages.ShopCatagories;
import com.framework.utils.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShopCatagoriesSteps {
	
	private LoginPage lp = new LoginPage(DriverFactory.getDriver());
	private Properties prop;
	private ShopCatagories	shopCat;
	@Given("User has already logged into the application")
	public void user_has_already_logged_into_the_application(DataTable dataTable) throws InterruptedException {
		
		// ReadData
		List<Map<String, String>> credDetails = dataTable.asMaps();
		String userName = credDetails.get(0).get("username");
		String password = credDetails.get(0).get("password");
		
		// Launch the url
		
		ConfigReader cr = new ConfigReader();
		prop = cr.init_prop();
		DriverFactory.getDriver().get(prop.getProperty("url"));
		
		shopCat = lp.doLogin(userName, password);
	
	}

	@Given("User is on DashBoard page")
	public void user_is_on_dash_board_page() throws InterruptedException {
	   boolean result = lp.verifyDashBoard();
	   Assert.assertTrue("User is not on Dashboard", result);
	   System.out.println("User is On dashBoard");
	   
	}

	@When("User clicks on Home link on Header")
	public void user_clicks_on_home_link_on_header() {
	    shopCat.clickHome();
	}

	@When("User clicks on Shop Now link")
	public void user_clicks_on_shop_now_link() throws InterruptedException {
	    shopCat.clickShopNow();
	}

	@Then("User should Navigate to https:\\/\\/qa.biskane.com\\/shop-Indigenous page")
	public void user_should_navigate_to_https_qa_biskane_com_shop_indigenous_page() throws InterruptedException {
	  boolean result = shopCat.isShopPageUrlCorrect();
	  Assert.assertTrue("User is not on Shop Page", result);
	  System.out.println("User is on Shop Page");
	}

	@When("User count number of Categories on shop page")
	public void user_count_number_of_categories_on_shop_page() throws InterruptedException {
		System.out.println();
		System.out.println("Total shop categories are : "+ shopCat.countCategories());
		System.out.println();
		shopCat.getingCategories_Text();
	}

	@When("User click on Dashboard")
	public void user_click_on_dashboard() {
		shopCat.clickDashBoard();
	}
	

}
