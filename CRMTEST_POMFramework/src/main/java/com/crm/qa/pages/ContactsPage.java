package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(xpath="//input[@name='cs_name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='cs_email']")
	WebElement email;
	
	@FindBy(xpath = "//td[contains(text(),'Shreyata Sugandhi')]")
	WebElement clientSearch;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel(){
		return contactLabel.isDisplayed();
	}
	
	public boolean verifyClientSearch(){
		return clientSearch.isDisplayed();
	}

}
