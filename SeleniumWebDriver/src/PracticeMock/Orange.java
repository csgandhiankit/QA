package PracticeMock;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Orange {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDrivers\\chromedriver.exe");

		driver = new ChromeDriver();

		// open url
		driver.get("https://opensource-demo.orangehrmlive.com/");

		// maximize window
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);

	}

	@Test
	public void run() throws InterruptedException {
		// create action
		Actions act = new Actions(driver);

		// login
		WebElement input = driver.findElement(By.id("txtUsername"));
		input.sendKeys("Admin");
		act.sendKeys(Keys.TAB).sendKeys("admin123").build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);

		// verify dashboard
		String dash = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/h1")).getText();
		Assert.assertEquals(dash, "Dashboard");
		Thread.sleep(1000);

		// logout
		driver.findElement(By.xpath("//*[@id='welcome']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
		Thread.sleep(1000);

		// hyperlinks
		driver.get("https://opensource-demo.orangehrmlive.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The number of hyperlinks are: " + links.size());
		String[] linkText = new String[links.size()];
		// extract link text of each link elements
		int i = 0;
		for (WebElement x : links) {
			linkText[i] = x.getText();
			System.out.println(linkText[i]);
			i++;
		}
		for (String lt : linkText) {
			try {
				driver.findElement(By.linkText(lt));
				
				System.out.println("Title of the page is" + driver.getTitle());

			} catch (Exception e) {
				// System.out.println("lt not: " + lt);
			}

			// driver.navigate().back();
		}
		Thread.sleep(1000);

		// back to login page and login with locators
		// driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.clear();
		userName.sendKeys("admin");
		WebElement pass = driver.findElement(By.id("txtPassword"));
		pass.clear();
		pass.sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(1000);

		// hover to recruitment and click candidate
		WebElement rec = driver.findElement(By.id("menu_recruitment_viewRecruitmentModule"));
		WebElement cand = driver.findElement(By.id("menu_recruitment_viewCandidates"));
		// mouse action
		act.moveToElement(rec).build().perform();
		Thread.sleep(1000);
		act.moveToElement(cand).click().build().perform();
		Thread.sleep(1000);

		// click add
		driver.findElement(By.id("btnAdd")).click();

		// export data from excel file
		driver.findElement(By.id("addCandidate_firstName")).sendKeys("John");
		driver.findElement(By.id("addCandidate_lastName")).sendKeys("Lee");
		driver.findElement(By.id("addCandidate_email")).sendKeys("jole@gmail.com");
		Thread.sleep(1000);
		
		// Locating 'browse' button
		WebElement browse = driver.findElement(By.id("addCandidate_resume"));
		// pass the path of the file to be uploaded using Sendkeys method
		browse.sendKeys("C:\\Users\\ankit.gandhi\\Documents\\resume.docx");
		Thread.sleep(1000);
		// save
		driver.findElement(By.id("btnSave")).click();
		
		

		// excel file

		// screenShot of currentPage
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\ankit.gandhi\\Desktop\\Reference.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
