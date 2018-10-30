package AdvSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// implicit wait
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();

		Actions act = new Actions(driver);

		WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement usermgt = driver.findElement(By.id("menu_admin_UserManagement"));
		WebElement users = driver.findElement(By.id("menu_admin_viewSystemUsers"));

		// mouse action
		act.moveToElement(admin).build().perform();
		Thread.sleep(1000);

		act.moveToElement(usermgt).build().perform();
		Thread.sleep(1000);

		act.moveToElement(users).build().perform();
		Thread.sleep(1000);

		driver.close();
		driver.quit();

	}

}
