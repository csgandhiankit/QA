package Selenium;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AsserNverify {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		String expectTitle = "Facebook – log in or sign up";
		assertEquals(driver.getTitle(), expectTitle);
		
		WebElement element = driver.findElement(By.id("email"));
		element.sendKeys("tutorial");
		// String textError = element.getText();
		String textError = element.getAttribute("value");
		//System.out.println(element.getAttribute("id"));
		assertEquals(textError, "tutorial");
		System.out.println(textError);
		
		//assertEquals(driver.findElement(By.cssSelector("div._4rbf._53ij")).getText(), "The email or phone number" + "doesn't match");
		
		// Verify
		try {
			assertEquals(driver.getTitle(), expectTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Thread.sleep(1000);
		
		driver.close();
		driver.quit();
	}

}
