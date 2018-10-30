package AdvSelenium;

import static org.testng.Assert.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertNPopUp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumWebDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		// maximize window
		driver.manage().window().maximize();
		
		// open url
		driver.get("http://www.newtours.demoaut.com/");
		
		// current url
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		
		// JavaScript Alert
		driver.findElement(By.xpath(".//button[contains(text(), 'Click for JS Alert')]")).click();
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		System.out.println("Alert is: " + alertText);
		simpleAlert.accept();
		assertEquals(driver.findElement(By.id("result")).getText(), "You successfuly clicked an alert");
		System.out.println(driver.findElement(By.id("result")).getText());
		
		Thread.sleep(1000);
		System.out.println("####################");
		
		// JS confirmation popUp
		// click OK
		WebElement element = driver.findElement(By.xpath(".//button[@onclick='jsConfirm()']"));
		element.click();
		Alert confirmAlert = driver.switchTo().alert();
		String confirmText = confirmAlert.getText();
		System.out.println("Confirmation Pop Up: " + confirmText);
		confirmAlert.accept();
		assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok");
		System.out.println(driver.findElement(By.id("result")).getText());
		Thread.sleep(1000);
		// click CANCEL
		element.click();
		Alert confirmAlert2 = driver.switchTo().alert();
		confirmAlert2.dismiss();
		assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
		System.out.println(driver.findElement(By.id("result")).getText());
		
		System.out.println("####################");
		
		// JS Prompt
		WebElement e2 = driver.findElement(By.xpath(".//button[@onclick='jsPrompt()']"));
		e2.click();
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Hello");
		String promptText = promptAlert.getText();
		System.out.println("Prompt is: " + promptText);
		promptAlert.accept();
		assertEquals(driver.findElement(By.id("result")).getText(), "You entered: Hello");
		System.out.println(driver.findElement(By.id("result")).getText());
		// click CANCEL
		e2.click();
		Alert promptAlert2 = driver.switchTo().alert();
		promptAlert2.dismiss();
		assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: null");
		System.out.println(driver.findElement(By.id("result")).getText());
		
		Thread.sleep(2000);
		
		driver.close();
		driver.quit();
	}

}
