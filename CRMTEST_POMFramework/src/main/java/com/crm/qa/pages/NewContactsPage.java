package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewContactsPage extends TestBase{
	
	@FindBy(xpath = "//legend[contains(text(),'Contact Information')]")
	WebElement newContactLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(name="company_position")
	WebElement coPosition;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(name="address_title")
	WebElement addressTitle;
	
	@FindBy(xpath="//textarea[@name='address']")
	WebElement address;
	
	@FindBy(name="city")
	WebElement city;
	
	@FindBy(name="state")
	WebElement state;
	
	@FindBy(name="postcode")
	WebElement zipCode;
	
	@FindBy(name="country")
	WebElement country;
	
	@FindBy(xpath="//input[@value='save']")
	WebElement saveBtn;
	
	
	public NewContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyNewContactsLabel(){
		return newContactLabel.isDisplayed();
	}

	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title, String ftName, String ltName, String comp){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	
}
