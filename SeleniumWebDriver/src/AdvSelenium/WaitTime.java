package AdvSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("http://www.newtours.demoaut.com/");
		
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		
		// Explicit wait
		WebDriverWait expWait = new WebDriverWait(driver, 10);
		WebElement button = expWait.until(ExpectedConditions.elementToBeClickable(By.name("findFlights")));
		button.click();
		
		 
		driver.close();
		driver.quit();

	}

}
