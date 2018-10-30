package AdvSelenium;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class OpenSourceDemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		// create action
		Actions act = new Actions(driver);

		// identify element
		WebElement input = driver.findElement(By.id("txtUsername"));
		input.sendKeys("Admin");
		act.sendKeys(Keys.TAB).sendKeys("admin123").build().perform();
		act.sendKeys(Keys.ENTER).build().perform();

		// mouse hover
		WebElement pim = driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/b"));
		WebElement addEmp = driver.findElement(By.xpath("//*[@id='menu_pim_addEmployee']"));
		// mouse action
		act.moveToElement(pim).moveToElement(addEmp).click().build().perform();
		
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("Tom");//*[@id="firstName"]
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Jerry");
		
		//driver.findElement(By.id("photofile")).click();
		//Runtime.getRuntime().exec("C:\\Users\\ankit.gandhi\\Documents\\UploadAutoScript.exe");
		
		//*[@id="chkLogin"]
		driver.findElement(By.xpath("//*[@id='chkLogin']")).click();
		//*[@id="btnSave"]
		driver.findElement(By.xpath("//*[@id='btnSave']")).click();
		
		WebElement dash = driver.findElement(By.xpath("//*[@id='menu_dashboard_index']/b"));
		act.doubleClick(dash).build().perform();
		
		WebElement rightClick = driver.findElement(By.xpath("//*[@id='menu_directory_viewDirectory']/b"));
		act.contextClick(rightClick).build().perform();
		act.sendKeys(Keys.ALT).keyDown(Keys.SHIFT).click(rightClick);
		act.sendKeys(Keys.ARROW_RIGHT).build().perform();
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();

		Set<String> handles = driver.getWindowHandles();
		System.out.println(handles);
		
		for (String handle_1 : driver.getWindowHandles()) {
			Thread.sleep(1000);
			System.out.println(handle_1);
			driver.switchTo().window(handle_1);
			System.out.println(driver.getTitle());
		}
		
		Thread.sleep(2000);

		driver.close();
		driver.quit();

	}

}
