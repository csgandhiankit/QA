package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Home')]")
	WebElement homeTab;
	
	@FindBy(xpath="company_name")
	WebElement coName;
	
	@FindBy(xpath = "//td[contains(text(),'User: User1 SS')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'Cases')]")
	WebElement casesLink;
	
	@FindBy(xpath="//a[contains(text(),'Call'")
	WebElement callLink;
	@FindBy(xpath="//a[contains(text(),'Call Scripts'")
	WebElement callScriptLink;
	
	@FindBy(xpath="//a[contains(text(),'Reports')]")
	WebElement reportLink;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();		
	}
	
	public ContactsPage clickOnContactsLink(){
		contactLink.click();
		return new ContactsPage();
	}
	
	public NewContactsPage clickOnNewContactsLink(){
		contactLink.click();
		return new NewContactsPage();
	}
	
	public CasesPage clickOnCasesLink() {
		casesLink.click();
		return new CasesPage();
	}
	
	public CallPage clickOnCallLink() {
		callLink.click();
		return new CallPage();
	}
	public void clickOnCallScriptLink() {
		Actions action = new Actions(driver);
		action.moveToElement(callLink).build().perform();
		callScriptLink.click();
	}
	
	public ReportsPage clickOnReportsLink() {
		reportLink.click();
		return new ReportsPage();
	}
	
}
