package com.crm.qa.pages;

import com.crm.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Logout']")
	WebElement logOut;
	
	public LogOutPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLogOutPageTitle() {
		return driver.getTitle();
	}
	
	public void clickOnLogOut() {
		
	}

}
