package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTours {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.newtours.demoaut.com/");
		
		driver.findElement(By.name("userName")).sendKeys("Infosys");
		driver.findElement(By.name("password")).sendKeys("pass");
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//*[@value='oneway']")).click();
				
		driver.findElement(By.linkText("CONTACT")).click();
		
		driver.findElement(By.cssSelector("a[href*='mercurywelcome.php']")).click();
		
		driver.findElement(By.partialLinkText("Crui")).click();
		
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();
	}

}
