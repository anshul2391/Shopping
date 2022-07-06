package parallel;

import java.util.List;
import java.util.Map;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;


@SuppressWarnings("deprecation")
public class AccountsPageSteps {

	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		List<Map<String, String>> credentials =dataTable.asMaps();
		String un =credentials.get(0).get("username");
	    String pwd = credentials.get(0).get("password");
	    DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	    accountPage= loginPage.doLogin(un, pwd);
	    
	    // addning the code
	    
	}

	@Given("user is on account page")
	public void user_is_on_account_page() {
	    String title = accountPage.getTitle();
	    System.out.println(title);
	}

	@Then("user get account section")
	public void user_get_account_section(DataTable dataTable) {
	    List<String> expectedSection= dataTable.asList();
	    System.out.println("Expected Section list"+ expectedSection);
	    
	    List<String> actualSection=accountPage.getAccountSectionName();
	    System.out.println("Actual Section List" + actualSection);
	    
	    Assert.assertTrue(expectedSection.containsAll(actualSection));
	}

	@Then("Account section count should be {int}")
	public void account_section_count_should_be(Integer int1) {
		int count =accountPage.getAccountSectionCount();
		Assert.assertTrue(count==int1);
	   
	}
}
