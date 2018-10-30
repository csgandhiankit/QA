package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CallPage extends TestBase{
	
	public CallPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateCallPageeTitle() {
		return driver.getTitle();
	}
	

}
