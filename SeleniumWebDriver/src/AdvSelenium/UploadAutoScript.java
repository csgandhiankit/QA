package AdvSelenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadAutoScript {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// implicit wait
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//driver.manage().window().maximize();
		
		driver.get("http://the-internet.herokuapp.com/upload");
		
		driver.findElement(By.id("file-upload")).click();
		
		Thread.sleep(1000);
		
		// run AutoIT
		Runtime.getRuntime().exec("C:\\Users\\ankit.gandhi\\Documents\\UploadAutoScript.exe");
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("file-submit")).click();
		
		driver.close();
		driver.quit();

	}

}
