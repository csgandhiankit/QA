package AdvSelenium;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://the-internet.herokuapp.com/windows");

		// Store and print name of the First window on the console
		String handle = driver.getWindowHandle();
		System.out.println(handle);

		// click on the link to open new window
		driver.findElement(By.linkText("Click Here")).click();

		// Store and print name of all window open
		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);

		// pass window handle to other window
		for (String handle_1 : driver.getWindowHandles()) {
			System.out.println(handle_1);
			driver.switchTo().window(handle_1);
			System.out.println(driver.getTitle());
		}

		Thread.sleep(1000);

		driver.close();
		driver.quit();

	}

}
