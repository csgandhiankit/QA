package PracticeMock;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MockTest {
	
	WebDriver driver;
	
	// setup driver and run url
	@BeforeMethod
	public void setup()
	{
		// driver path
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		
		// chrome driver
		driver = new ChromeDriver();
		
		// open url
		driver.get("http://10.67.89.86/Automation/OnlineCourse/");
		
		// maximize window
		driver.manage().window().maximize();
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
	}
	
	@Test
	public void run(){
		
		// navigate and click on Browse Catalog
		driver.findElement(By.id("indexF")).click();
		
		// get every href links and print number of links
//		WebElement linkable = driver.findElement(By.xpath(.//a))
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("The number of hyperlinks are: " + links.size());
		
		// xcel file open
		
		
		// click enroll btn of introduction to software product management 
		driver.findElement(By.id("btn8")).click();
		
		// fill out the form
		// input name as John
		driver.findElement(By.id("name")).sendKeys("John");
		
		// input email as john@gmail.com
		driver.findElement(By.id("email")).sendKeys("john@gmail.com");
		
		// select student radio btn
		driver.findElement(By.id("stuRadio")).click();
		
		// select college name HRTU from dropdown menu
		new Select(driver.findElement(By.id("pSelect1"))).selectByVisibleText("HRTU");
		
		// select collge year 2012 from dropdown menu
		new Select(driver.findElement(By.id("pSelect2"))).selectByVisibleText("2012");
		
		// select coupon
		driver.findElement(By.id("eRadio3")).click();
		
		// store cost after coupon
		String cost_1 = driver.findElement(By.xpath("//*[@id='courseCost']")).getText();
		
		// click pay btn
		driver.findElement(By.id("payNow")).click();
		
		//*[@id="courseDetail"]/tbody/tr/td[2]
		// store cost after pay btn
		String cost_2 = driver.findElement(By.xpath("//*[@id='courseDetail']/tbody/tr/td[2]")).getText();
		
		// compare costs
		Assert.assertEquals(cost_1, cost_2);
		
		// click on offer
		driver.findElement(By.id("paymentS")).click();
		
		// take screenshot of offer page
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\ankit.gandhi\\Desktop\\Reference.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	// quite driver after successfully run
	@AfterTest
	public void tearDown() throws IOException {
		driver.quit();
	}

}
