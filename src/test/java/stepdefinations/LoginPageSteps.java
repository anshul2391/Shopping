package stepdefinations;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private static String title;

	@Given("user is on login page")
	public void user_is_on_login_page() {
	  DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}

	@When("user get the title of the page")
	public void user_get_the_title_of_the_page() {
		 title =loginPage.getLoginPageTitle();
	    System.out.println(title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expected) {
		
	    Assert.assertEquals(title, expected);
	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	   Assert.assertTrue(loginPage.forgetpasswordlink());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	    loginPage.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	    loginPage.enterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    loginPage.clickOnLogin();
	}

	
}
