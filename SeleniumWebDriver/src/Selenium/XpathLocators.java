package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.Select;

public class XpathLocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
//		// find with xpath
//		driver.findElement(By.xpath("//*[@id='day']")).sendKeys("12");
//		driver.findElement(By.xpath("//*[@id='month']")).sendKeys("Feb");
//		driver.findElement(By.xpath("//*[@id='year']")).sendKeys("1987");
		
		//driver.findElement(By.cssSelector("#u_0_a")).click();
		driver.findElement(By.xpath("//*[@id='u_0_a']")).click();
		
		driver.findElement(By.xpath(".//input[@name='firstname']")).clear();
		driver.findElement(By.xpath(".//input[@name='firstname']")).sendKeys("Raleigh");
		
		// find xpath with class and index
//		new Select(driver.findElement(By.xpath(".//*[@class='_5dba')[1]"))).selectByVisibleText("19");
//		new Select(driver.findElement(By.xpath(".//*[@class='_5dba')[2]"))).selectByVisibleText("Oct");
//		new Select(driver.findElement(By.xpath(".//*[@class='_5dba')[3]"))).selectByVisibleText("1973");
		
//		new Select(driver.findElement(By.xpath(".//*[@name='birthday_day']"))).selectByVisibleText("20");
//		new Select(driver.findElement(By.xpath(".//*[@name='birthday_month')"))).selectByVisibleText("Sept");
//		new Select(driver.findElement(By.xpath(".//*[@name='birthday_year')"))).selectByVisibleText("1973");
		
		// xpath with contains text
		driver.findElement(By.xpath(".//button[contains(text(), 'Up')]")).click();
		
		driver.findElement(By.xpath(".//a[contains(text(), 'provide')]")).click();
		
		
		//xpath contains images
		driver.findElement(By.xpath(".//img[contains(@src,'GwFs3_KxNjS.png')]")).click();
		
//		driver.navigate().to("http://www.newtours.demoaut.com/");
//		driver.findElement(By.xpath(".//img[contains(@src,'banner2.gif')]")).click();
//		
//		driver.navigate().to("https://www.facebook.com/");
		
		// xpath with value -- login button
		driver.findElement(By.xpath(".//*[@aria-label='New password']")).sendKeys("pass");
		
		//driver.findElement(By.xpath(".//*[@value='Log In']")).click();
		
		//xpath value with radio button
		driver.findElement(By.xpath(".//*[@value='2']")).click();
		
		WebElement f = driver.findElement(By.xpath(".//*[@type='radio'][@value='1']"));
		WebElement m = driver.findElement(By.xpath(".//*[@type='radio'][@value='2']"));
		for(int i = 0; i < 100; i++)
		{
			f.click();
			m.click();
		}
		
		
		WebElement genderType = driver.findElement(By.xpath(".//*[@type='radio'][@value='2']"));
		boolean selected = genderType.isSelected();
		if (selected) {
			System.out.println("Male is selected");
			driver.findElement(By.xpath(".//*[@value='2']")).click();
		} else {
			System.out.println("Male was not selected by default.");
			genderType.click();
			driver.findElement(By.xpath(".//*[@value='2']")).click();
		}
		
		//xpath with select for box/drop down menu
		new Select(driver.findElement(By.xpath(".//select[@aria-label='Day']"))).selectByVisibleText("26");
		new Select(driver.findElement(By.xpath(".//select[@aria-label='Month']"))).selectByVisibleText("Jan");
		new Select(driver.findElement(By.xpath(".//select[@aria-label='Year']"))).selectByVisibleText("1947");
		
		
		// xpath type
		driver.findElement(By.xpath(".//*[@type='radio'][@value='1']")).click();
		// driver.findElement(By.xpath(".//*[@type='password'][@tableindex='2']")).sendKeys("pass");
		

		
		
		Thread.sleep(1000);
		
		driver.close();
		driver.quit();

	}

}
