package AdvSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		// create action
		Actions act = new Actions(driver);

		// identify element
		WebElement search = driver.findElement(By.name("q"));

		// key stocks
		Action kb = act.keyDown(search, Keys.SHIFT).sendKeys("Java Code").keyUp(search, Keys.SHIFT).doubleClick().build();
		kb.perform();
		act.sendKeys(search, Keys.ENTER);
		act.sendKeys(search, Keys.TAB);
		
//		act.keyDown(search, Keys.SHIFT).build().perform();
//		act.sendKeys("Seleniumhq").build().perform();
//		act.sendKeys(search, Keys.ENTER).build().perform();
//		act.sendKeys(search, Keys.TAB).build().perform();
//		act.doubleClick().build().perform();
//		driver.navigate().back();
//		act.sendKeys(search, Keys.TAB).build().perform();
//		act.sendKeys(Keys.TAB).build().perform();
//		act.contextClick().build().perform();
//		act.keyUp(search, Keys.SHIFT).build().perform();

		Thread.sleep(1000);

		driver.close();
		driver.quit();

	}

}
