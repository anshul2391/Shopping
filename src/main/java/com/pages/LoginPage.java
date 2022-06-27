package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By email = By.id("input-email");
	private By pwds = By.id("input-password");
	private By forgotpassword = By.linkText("Forgotten Password");
	private By login = By.xpath("//input[@value='Login']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void enterUsername(String username) {
		driver.findElement(email).sendKeys(username);
	}
	public void enterPassword(String pwd) {
		driver.findElement(pwds).sendKeys(pwd);
	}
	
	public boolean forgetpasswordlink() {
		return driver.findElement(forgotpassword).isDisplayed();
	}
	
	public void clickOnLogin() {
		driver.findElement(login).click();
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		driver.findElement(email).sendKeys(un);
		driver.findElement(pwds).sendKeys(pwd);
		driver.findElement(login).click();
		
		return new AccountsPage(driver);
	}
	
	
	
	

}
