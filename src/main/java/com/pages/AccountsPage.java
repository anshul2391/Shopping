package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	private WebDriver driver;
	
	private By accountSections = By.xpath("//div[@id='content']/h2");
	
	
	public  AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
  public int getAccountSectionCount() {
	  return driver.findElements(accountSections).size();
  }

  public String getTitle() {
	  return driver.getTitle();
  }
  
  public List<String> getAccountSectionName() {
	 List<String> name = new ArrayList<>(); 
	  
	 List<WebElement> sectionNames= driver.findElements(accountSections);
	 for(WebElement e: sectionNames) {
		 name.add(e.getText());
		 
	 }
	return name;
		 
  }
}
