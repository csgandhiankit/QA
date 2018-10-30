package AdvSelenium;

import static org.testng.Assert.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG {
	// webdriver
	public WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		// Create instance of WebDriver
		driver = new ChromeDriver();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// max window
		driver.manage().window().maximize();

		// Open url into browser
		driver.get("http://newtours.demoaut.com/");
		assertEquals(driver.getTitle(), "Welcome: Mercury Tours");

	}

	@Test
	public void login() {

		// Enter username
		WebElement username = driver.findElement(By.name("userName"));
		username.clear();
		username.sendKeys("tutorial");

		// Enter password
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("tutorial");

		// click on sign-in button
		driver.findElement(By.name("login")).click();
		assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");

		assertTrue(isElementPresent(By.xpath("//td/table/tbody/tr/td[2]/table/tbody/tr/td/img")));
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@AfterTest
	public void CleanUp() {
		driver.findElement(By.linkText("SIGN-OFF")).click();

		driver.close();
		driver.quit();
	}
	
	@Test
	public void Test2(){
		System.out.println("This is test 2");
	}
	@Test
	public void Test3(){
		System.out.println("This is test 3");
	}
}
