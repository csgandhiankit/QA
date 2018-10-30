package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		// find by id
		driver.findElement(By.id("email")).sendKeys("ankit@info.com");
		
		// find by name
		driver.findElement(By.name("pass")).sendKeys("password");
		
		// find by className: not usefull
		WebElement element = driver.findElement(By.className("inputtext"));
		element.clear();
		element.sendKeys("Ankit");
		
		// linktext: look for forgottonaccount? on page then click on it
		//driver.findElement(By.linkText("Forgotten account?")).click();
		
		// partiallink: if any changes happen to forgot account
		driver.findElement(By.partialLinkText("Forgot")).click();
		
		//driver.findElement(By.id("u_0_2")).click();
		
		
		Thread.sleep(1000);
		
		// close driver
		driver.close();
		// quite driver
		driver.quit();

	}

}
