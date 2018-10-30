package AdvSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Broswers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = null;
		
		String browser = "chrome";
		
		if (browser.equalsIgnoreCase("chrome")) {
			String service = "C:\\SeleniumBrowserDriver\\chromedriver.exe";
			System.setProperty("webdriver.ie.driver", service);
		} 
		else if (browser.equalsIgnoreCase("firefox")) {
			String service = "C:\\SeleniumBrowserDriver\\geckodriver.exe";
			System.setProperty("webdriver.ie.driver", "C:\\SeleniumBrowserDriver\\geckodriver.exe");
		}
		else if (browser.equalsIgnoreCase("ie")) {
			String service = "C:\\SeleniumBrowserDriver\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", "C:\\SeleniumBrowserDriver\\IEDriverServer.exe");
		}
		else
		{
			System.out.println("Broswer is not selected.");
		}
		
		driver.get("http://www.newtours.demoaut.com/");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		

	}

}
