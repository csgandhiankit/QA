package AdvSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		// maximize window
		driver.manage().window().maximize();
		
		// open url
		driver.get("http://www.newtours.demoaut.com/");
		
		// get all links unsing findElements
		String underConsTitle = "Under Costruction: Mercury Tours";
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		String[] linkText = new String[links.size()];
		
		// extract link text of each link elements
		int i = 0;
		for (WebElement x : links) {
			linkText[i] = x.getText();
			System.out.println(linkText[i]);
			i++;
		}
		
		
		// test each link
		for (String lt : linkText) {
			if (lt == "Register \n                    here") {
				driver.findElement(By.xpath(".//a[contains(text(), 'Register ')]")).click();
			} else {
				driver.findElement(By.linkText(lt)).click();
				Thread.sleep(1000);
			}

			if (driver.getTitle().equals(underConsTitle)) {
				System.out.println("\"" + lt + "\"" + " is under construction");
			} else {
				System.out.println("\"" + lt + "\"" + " is working");
			}

			driver.navigate().back();
			Thread.sleep(1000);
		}
		
		
		Thread.sleep(1000);
		
		driver.close();
		driver.quit();

	}

}
