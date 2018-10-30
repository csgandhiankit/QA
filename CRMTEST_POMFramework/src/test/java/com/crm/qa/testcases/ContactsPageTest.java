package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	NewContactsPage newContactsPage;
	
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		initilization();
		testUtil = new TestUtil();
		newContactsPage = new NewContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		newContactsPage = homePage.clickOnNewContactsLink();
	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(newContactsPage.verifyNewContactsLabel(), "Contacts label is missing on the page");
	}

	@Test(priority = 2)
	public void selectSingleContactsTest() {
		newContactsPage.selectContactsByName("test2 test2");
	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() {
		newContactsPage.selectContactsByName("test2 test2");
		newContactsPage.selectContactsByName("ui uiii");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 4, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContactsLink();
		// newContactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		newContactsPage.createNewContact(title, firstName, lastName, company);
	}

	@AfterMethod
	public void tearDown() throws IOException {
		TestUtil.takeScreenshotAtEndOfTest();
		driver.quit();
	}

}
