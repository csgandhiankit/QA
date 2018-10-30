package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {

	public static void main(String[] args) throws InterruptedException {

		// set properties
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");

		// create instance of webdriver
		WebDriver driver = new ChromeDriver();

		// open url into browser
		driver.get("http://newtours.demoaut.com/");

		Thread.sleep(100);

		// declare actual and expected outcome
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = "";

		actualTitle = driver.getTitle();

		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

		// enter username
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("tutorial");
		// enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("tutorial");

		// to write in one line
		// driver.findElement(By.name("password")).sendKeys("tutorial");

		driver.findElement(By.name("login")).click();

		// declare actual value of title

		String expectedTitle2 = "Find a Flight: Mercury Tours";
		String actualTitle2 = "";

		actualTitle2 = driver.getTitle();

		if (actualTitle2.contentEquals(expectedTitle2)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

		driver.findElement(By.linkText("SIGN-OFF")).click();

		// close browser
		driver.close();

	}

}
