package AdvSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// implicit wait
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// driver.manage().window().maximize();

		driver.get("http://jqueryui.com/droppable/");

		// create action
		Actions act = new Actions(driver);

		// switch to <iframe>
		driver.switchTo().frame(0);

		// identify element
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		// click and hold, move anf release
		//act.clickAndHold(source).moveToElement(target).release().build().perform();
		act.dragAndDrop(source, target).build().perform();

		Thread.sleep(1000);

		driver.close();
		driver.quit();

	}

}
