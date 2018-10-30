package AdvSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ReSizeableBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// implicit wait
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://jqueryui.com/resizable/");

		// create action
		Actions act = new Actions(driver);

		// switch to <iframe>
		driver.switchTo().frame(0);

		// identify element
		WebElement reSize = driver.findElement(By.xpath(".//*[@id='resizable']/div[3]"));
		
		// move slider
		act.moveToElement(reSize).dragAndDropBy(reSize, 250, 350).build().perform();
		act.moveToElement(reSize).dragAndDropBy(reSize, 150, 200).build().perform();
		
		Thread.sleep(3000);

		driver.close();
		driver.quit();

	}

}
