package AdvSelenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		// maximize window
		driver.manage().window().maximize();
		
		// open url
		driver.get("https://www.facebook.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		String[] linkText = new String[links.size()];

		
		// extract link text of each link elements
		int i = 0;
		for (WebElement x : links) {
			linkText[i] = x.getText();
			System.out.println(linkText[i]);
			i++;
		}
		
		for (String lt : linkText) {
			try{
				driver.findElement(By.linkText(lt)).click();
				System.out.println(driver.getTitle());
				
			}catch(Exception e){
				System.out.println("lt not: " + lt);
			}
			
			//driver.navigate().back();
			driver.navigate().to("https://www.facebook.com/");
			//Thread.sleep(1000);
		}
		
		Thread.sleep(1000);
		
		driver.close();
		driver.quit();

	}

}
