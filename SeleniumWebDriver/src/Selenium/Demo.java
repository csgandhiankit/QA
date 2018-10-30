package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.id("email")).sendKeys("Infosys");
		
		driver.findElement(By.cssSelector("input.inputtext[type='password']")).sendKeys("password");
		
		driver.findElement(By.linkText("Forgotten account?")).click();
		
		driver.navigate().to("https://www.facebook.com/");
		
		WebElement e1 = driver.findElement(By.id("u_0_j"));
		e1.clear();
		e1.sendKeys("Ankit");
		
		WebElement e2 = driver.findElement(By.name("lastname"));
		e2.clear();
		e2.sendKeys("Patel");
		
		WebElement e3 = driver.findElement(By.name("reg_email__"));
		e3.clear();
		e3.sendKeys("311-246-4721");
		
		WebElement e4 = driver.findElement(By.cssSelector("input[data-type='password']"));
		e4.clear();
		e4.sendKeys("password");
		
		driver.findElement(By.xpath("//*[@id='day']")).sendKeys("12");
		driver.findElement(By.xpath("//*[@id='month']")).sendKeys("Feb");
		driver.findElement(By.xpath("//*[@id='year']")).sendKeys("1987");
		
		//driver.findElement(By.cssSelector("#u_0_a")).click();
		driver.findElement(By.xpath("//*[@id='u_0_a']")).click();
		
		driver.findElement(By.xpath(".//input[@name='firstname']")).clear();
		driver.findElement(By.xpath(".//input[@name='firstname']")).sendKeys("Raleigh");
		
		
	
		Thread.sleep(1000);
		
		driver.close();
		driver.quit();
		

	}

}
