package TestCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_Steps {

	WebDriver driver;

	@Given("^I should be able to launch the ZeroBank app$")
	public void launch() {
		// Set system properties
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");

		// create driver object
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		// open url
		driver.get("http://zero.webappsecurity.com/");
	}

	@And("^I should be on 'Home Page'$")
	public void validateHome_Page() throws Throwable {
		assertEquals("Zero - Personal Banking - Loans - Credit Cards", driver.getTitle());
	}

	@And("^I click on 'SgnIn' button$")
	public void clickOnSgnInBtn() throws Throwable {
		driver.findElement(By.id("signin_button")).click();
	}

	@And("^I land on 'LogIn' page$")
	public void validateLogInpage() throws Throwable {
		assertEquals("Zero - Log in", driver.getTitle());
	}

	// \'(.*)\' = recursive way to get username
	@When("^I enter logIn id as \'(.*)\'$")
	public void enterUsername(String username) throws Throwable {
		driver.findElement(By.id("user_login")).sendKeys(username);
	}

	@When("^I enter password as \'(.*)\'$")
	public void enterPassword(String password) throws Throwable {
		driver.findElement(By.id("user_password")).sendKeys(password);
	}

	@When("^I click on 'SignIn' button$")
	public void clickSignInBtn() throws Throwable {
		driver.findElement(By.name("submit")).click();
	}

	@Then("^I should be able to logIn into the ZeroBank app I should land on 'User Dash Board'$")
	public void validateUserDash() throws Throwable {
		assertEquals("Zero - Account Summary", driver.getTitle());
	}
}