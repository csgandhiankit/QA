package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class ReportsPage extends TestBase{
	
	public ReportsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateReportsPageTitle() {
		return driver.getTitle();
	}
	
}
