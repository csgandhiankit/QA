package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TourBook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumBrowserDriver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		// implicit wait
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		// maximize window
		driver.manage().window().maximize();
		
		// open url
		driver.get("http://www.newtours.demoaut.com/");
		
		// current url
		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		driver.get("http://www.newtours.demoaut.com/");
		
		// Title of page
		String titleText = driver.getTitle();
		System.out.println(titleText);

		//
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
		
		
		
		//login with valid credentail
		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();
		
		
		// click oneway radio option
		//driver.findElement(By.xpath(".//*[@type='radio'][@value='oneway']")).click();
		WebElement tripType = driver.findElement(By.xpath(".//*[@type='radio'][@value='oneway']"));
		boolean selected = tripType.isSelected();
//		boolean enabled = tripType.isEnabled();
//		boolean displayed = tripType.isDisplayed();
		
		if (selected) {
			System.out.println("One way trip is selected");
			driver.findElement(By.xpath(".//*[@value='oneway']")).click();
		} else {
			System.out.println("Round trip was not selected by default.");
			tripType.click();
			driver.findElement(By.xpath(".//*[@value='oneway']")).click();
		}
		
		// select passanger
		new Select(driver.findElement(By.xpath(".//select[@name='passCount']"))).selectByVisibleText("3");
		
		// selcect departure
		new Select(driver.findElement(By.xpath(".//select[@name='fromPort']"))).selectByVisibleText("San Francisco");
		
		// select daparture date
		new Select(driver.findElement(By.xpath(".//select[@name='fromMonth']"))).selectByVisibleText("December");
		new Select(driver.findElement(By.xpath(".//select[@name='fromDay']"))).selectByVisibleText("22");
		
		// select arrival
		new Select(driver.findElement(By.xpath(".//select[@name='toPort']"))).selectByVisibleText("Sydney");
		
		// select arrival date
		new Select(driver.findElement(By.xpath(".//select[@name='toMonth']"))).selectByVisibleText("January");
		new Select(driver.findElement(By.xpath(".//select[@name='toDay']"))).selectByVisibleText("5");
		
		// type of serive
		driver.findElement(By.xpath(".//*[@type='radio'][@value='First']")).click();
		
		// prefereance
		new Select(driver.findElement(By.xpath(".//select[@name='airline']"))).selectByVisibleText("Blue Skies Airlines");
		
		// continue
		//driver.findElement(By.xpath(".//input[contains(@name,'findFlights')]")).click();
		driver.findElement(By.name("findFlights")).submit();
		
		// next page
		// pick depart time
		driver.findElement(By.xpath(".//*[@type='radio'][@value='Unified Airlines$363$281$11:24']")).click();
		
		// pick arrival time
		driver.findElement(By.xpath(".//*[@type='radio'][@value='Blue Skies Airlines$631$273$14:30']")).click();
		
		// continue
		driver.findElement(By.xpath(".//input[contains(@name,'findFlights')]")).click();
		
		// flyer info page
		// input firstname
		driver.findElement(By.xpath(".//input[@name='passFirst0']")).sendKeys("Scooby");
		driver.findElement(By.xpath(".//input[@name='passLast0']")).sendKeys("Doo");
		Select meal = new Select(driver.findElement(By.xpath(".//select[@name='pass.0.meal']")));
		meal.selectByVisibleText("Low Sodium");
//		meal.selectByValue("KSML");
//		meal.selectByIndex(4);
//		meal.deselectByValue("KSML");
		
		System.out.println(meal.getFirstSelectedOption()); // print low sodium
		
		boolean mealType = meal.equals("Low Sodium");
		if(mealType){
			System.out.println("Selected");
		}
		else{
			System.out.println("Not Selected");
		}
		
		// input second flyer
		driver.findElement(By.xpath(".//input[@name='passFirst0']")).sendKeys("Pick");
		driver.findElement(By.xpath(".//input[@name='passLast0']")).sendKeys("Chu");
		new Select(driver.findElement(By.xpath(".//select[@name='pass.0.meal']"))).selectByVisibleText("Vegetarian");
		// input third flyer
		driver.findElement(By.xpath(".//input[@name='passFirst0']")).sendKeys("Tom");
		driver.findElement(By.xpath(".//input[@name='passLast0']")).sendKeys("Jerry");
		new Select(driver.findElement(By.xpath(".//select[@name='pass.0.meal']"))).selectByVisibleText("Low Cholesterol");
		
		// credit card
		new Select(driver.findElement(By.xpath(".//select[@name='creditCard']"))).selectByVisibleText("Discover");
		driver.findElement(By.xpath(".//input[@name='creditnumber']")).sendKeys("6100213409875678");
		new Select(driver.findElement(By.xpath(".//select[@name='cc_exp_dt_mn']"))).selectByVisibleText("05");
		new Select(driver.findElement(By.xpath(".//select[@name='cc_exp_dt_yr']"))).selectByVisibleText("2008");
		driver.findElement(By.xpath(".//input[@name='passFirst0']")).sendKeys("Lion");
		driver.findElement(By.xpath(".//input[@name='passLast0']")).sendKeys("is");
		driver.findElement(By.xpath(".//input[@name='passLast0']")).sendKeys("King");
		
		// bill info
		WebElement ticketLessCheckBox = driver.findElement(By.name("ticketless"));
		boolean checked = ticketLessCheckBox.isSelected();
		if (!checked) {
			ticketLessCheckBox.click();
			System.out.println("check not by default");
		} else {
			System.out.println("check is there");
		}
		
		driver.findElement(By.xpath(".//input[@name='billAddress1']")).clear();
		driver.findElement(By.xpath(".//input[@name='billAddress1']")).sendKeys("4400 Capital Blvd");
		driver.findElement(By.xpath(".//input[@name='billCity']")).clear();
		driver.findElement(By.xpath(".//input[@name='billCity']")).sendKeys("Raleigh");
		driver.findElement(By.xpath(".//input[@name='billState']")).clear();
		driver.findElement(By.xpath(".//input[@name='billState']")).sendKeys("NC");
		driver.findElement(By.xpath(".//input[@name='billZip']")).clear();
		driver.findElement(By.xpath(".//input[@name='billZip']")).sendKeys("27604");
		
		// delivery info
		WebElement addressCheckBox = driver.findElement(By.xpath(".//tbody/tr[14]/td[2]/input[@name='ticketLess']"));
		boolean isDisplayed = addressCheckBox.isDisplayed();
		if (isDisplayed) {
			System.out.println("CheckBox is dispaly");
			boolean isEnabled = addressCheckBox.isEnabled();
			if (isEnabled) {
				System.out.println("CheckBox is enable");
				boolean isChecked = addressCheckBox.isSelected();
				if (!isChecked) {
					addressCheckBox.click();
					System.out.println("Checked the checkbox");
				} else {
					System.out.println("checkbox is already check");
				}
			} else {
				System.out.println("CheckBox is not dispalyed ");
			}
		}
		driver.findElement(By.xpath(".//input[@name='billAddress1']")).clear();
		driver.findElement(By.xpath(".//input[@name='billAddress1']")).sendKeys("4400 Capital Blvd");
		driver.findElement(By.xpath(".//input[@name='billCity']")).clear();
		driver.findElement(By.xpath(".//input[@name='billCity']")).sendKeys("Raleigh");
		driver.findElement(By.xpath(".//input[@name='billState']")).clear();
		driver.findElement(By.xpath(".//input[@name='billState']")).sendKeys("NC");
		driver.findElement(By.xpath(".//input[@name='billZip']")).clear();
		driver.findElement(By.xpath(".//input[@name='billZip']")).sendKeys("27604");
		
		// submit
		driver.findElement(By.xpath(".//input[contains(@name,'buyFlights')]")).click();
		
		
		
		Thread.sleep(1000);
		
		driver.close();
		driver.quit();
		
		
		
	}

}
