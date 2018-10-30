package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class CasesPage extends TestBase{
	
	public CasesPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateCasesPageTitle() {
		return driver.getTitle();
	}

}
