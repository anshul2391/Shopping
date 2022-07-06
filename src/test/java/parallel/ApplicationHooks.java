package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private ConfigReader config;
	private DriverFactory driverFactory;
	private WebDriver driver;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		 config = new ConfigReader();
		 prop = config.init_prop();
		 
	}
	
	@Before(order=1)
	public void launchBrowser(){
		String browserName =prop.getProperty("browser");
		 driverFactory = new DriverFactory();
		driver= driverFactory.init_driver( browserName);
	}
	
	@After(order=0)
	public void quit() {
		driver.quit();
	}
	
	@After(order=1)
	public void teardown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
			String screenShotName = scenario.getName().replaceAll(" ", " ");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenShotName);
			
			
		}
		
	}
	

}
