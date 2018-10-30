package AdvSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderHorizontal {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// implicit wait
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// driver.manage().window().maximize();

		driver.get("http://jqueryui.com/slider/");

		// create action
		Actions act = new Actions(driver);

		// switch to <iframe>
		driver.switchTo().frame(0);

		// identify element
		WebElement slider = driver.findElement(By.xpath("//*[@id='slider']/span"));

		// move slider
		act.moveToElement(slider).dragAndDropBy(slider, 300, 0).build().perform();

		Thread.sleep(1000);

		driver.close();
		driver.quit();

	}

}
