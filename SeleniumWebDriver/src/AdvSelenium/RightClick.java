package AdvSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// implicit wait
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		// create action
		Actions act = new Actions(driver);

		// identify element
		WebElement button = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));

		// right click
		act.contextClick(button).build().perform();

		// select the option
		driver.findElement(By.xpath("/html/body/ul/li[3]/span")).click();

		// switch to alert and get text
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(1000);

		// close alert
		driver.switchTo().alert().accept();

		Thread.sleep(1000);

		driver.close();
		driver.quit();

	}

}
