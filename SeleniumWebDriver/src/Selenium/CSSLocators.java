package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		// this will clear input if any
		driver.findElement(By.cssSelector("#email")).clear();
		// find by css: take id value and put # in front of value
		driver.findElement(By.cssSelector("#email")).sendKeys("Infosys");
		
		// find css by tag (tag#id): tag name is first word of line follow by # and id value
		//driver.findElement(By.cssSelector("input#pass")).sendKeys("password");
		
		// find css by class (tag.class): 
		WebElement e1 = driver.findElement(By.cssSelector("input.inputtext"));
		e1.clear();
		e1.sendKeys("Ankit");
		
		// find css by css attribute: tag[attribute='value of attribute']
		WebElement e2 = driver.findElement(By.cssSelector("input[type='password']"));
		e2.clear();
		e2.sendKeys("password");
		
		// find css by tag + class + attribute: tag.class[attribute='value of attribute']
		WebElement e3 = driver.findElement(By.cssSelector("input.inputtext[type='password']"));
		e3.clear();
		e3.sendKeys("password");
		
		
		Thread.sleep(1000);
		
		driver.close();
		driver.quit();
		
	}

}
