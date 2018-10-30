package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase {
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateSignUpPageTitle() {
		return driver.getTitle();
	}

}
