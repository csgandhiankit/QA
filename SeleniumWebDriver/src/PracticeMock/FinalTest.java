package PracticeMock;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FinalTest {

	WebDriver driver;

	@BeforeTest
	public void setup() {
		// driver path
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");

		// chrome driver
		driver = new ChromeDriver();

		// open url
		driver.get("https://opensource-demo.orangehrmlive.com/");

		// maximize window
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);

	}

	@Test
	public void run() throws InterruptedException, IOException {
		// create action
		Actions act = new Actions(driver);

		// logIn without locators
		act.sendKeys(Keys.TAB).sendKeys("admin").build().perform();
		act.sendKeys(Keys.TAB).sendKeys("admin123").build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);

		// validate dashboard page
		String dash = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/h1")).getText();
		Assert.assertEquals(dash, "Dashboard");
		Thread.sleep(1000);

		// logout of application
		driver.findElement(By.xpath("//*[@id='welcome']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
		Thread.sleep(1000);

		// count number of hyperlinks
		driver.get("https://opensource-demo.orangehrmlive.com/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The number of hyperlinks are: " + links.size());
		String[] linkText = new String[links.size()];

		for (int i = 0; i < links.size(); i++) {
			linkText[i] = links.get(i).getAttribute("href");
			System.out.println("Link Text is: " + linkText[i]);
		}
		for (int i = 0; i < links.size(); i++) {
			driver.navigate().to(linkText[i]);
			System.out.println("Title of the page is: " + driver.getTitle());
			Thread.sleep(1000);
			driver.navigate().back();
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
		// mouse action after hover
		act.moveToElement(rec).build().perform();
		Thread.sleep(1000);
		act.moveToElement(cand).click().build().perform();
		Thread.sleep(1000);
		
		// click add button 
		//driver.findElement(By.id("btnAdd")).click();
		
		// file
		List<String> firstname = new ArrayList();
		List<String> lastname = new ArrayList();
		List<String> email = new ArrayList();
		
		File file = new File("C:\\Users\\ankit.gandhi\\Desktop\\data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet st = wb.getSheetAt(0);
		Iterator<Row> rowLine = st.iterator();
		while(rowLine.hasNext()){
			Row row = rowLine.next();
			firstname.add(row.getCell(0).toString());
			lastname.add(row.getCell(1).toString());
			email.add(row.getCell(2).toString());
		}
		
		wb.close();
		fis.close();
		
		for(int i=0; i < firstname.size(); i++){
			
			// click add button 
			driver.findElement(By.id("btnAdd")).click();
			
			driver.findElement(By.id("addCandidate_firstName")).sendKeys(firstname.get(i));
			driver.findElement(By.id("addCandidate_lastName")).sendKeys(lastname.get(i));
			driver.findElement(By.id("addCandidate_email")).sendKeys(email.get(i));
			
			
			// Locating 'browse' button
			WebElement browse = driver.findElement(By.id("addCandidate_resume"));
			// pass the path of the file to be uploaded using Sendkeys method
			browse.sendKeys("C:\\Users\\ankit.gandhi\\Desktop\\resume.docx");
			Thread.sleep(1000);
			// save
			driver.findElement(By.id("btnSave")).click();
			driver.findElement(By.id("btnBack")).click();
			Thread.sleep(500);
		}
		

		

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
