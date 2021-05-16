package ticketBookingMethods;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

public class BookATicket {
	public WebDriver driver = null;
	String result = "Fail";
	WebElement element = null;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	public String openBrowser_navigate(String url) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-no-sandbox");
		options.addArguments("-disable-dev-shm-usage");
		options.addArguments("--disable-infobars");
		// options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		log.debug("Window Maximised");
		driver.get(url);
		log.debug("Mail Travel Website Opened");
		driver.getTitle();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		result = "Pass";
		return result;
	}

	public void validateTitle() throws InterruptedException {
        	String title1 = driver.getTitle();
        	String expectTitle = "Home Page | Mail Travel";
        	if(expectTitle.equals(title1)){
        		log.debug("Title Verified");
        	} else {
        	        log.debug("Title Verification failed");
                }   
		Assert.assertEquals(expectTitle, title1);
	}
	
	public void search(String srchtxt) throws InterruptedException {
		element = driver.findElement(By.xpath("(//*[@name='searchtext'])[1]"));
		element.sendKeys(srchtxt);
		log.debug("Entered Country name India in Search Box");
		element = driver.findElement(By.xpath("(//*[@class='nbf_button'])[1]"));
		element.click();
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//*[@tabindex='3']"));
		element.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		element = driver.findElement(By.id("content"));
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			System.out.println("Is Present");
			return true;

		} catch (NoSuchElementException e) {
			System.out.println("Is Not Present");
			return false;

		}
	}

	public void clickMore() throws InterruptedException {

		element = driver.findElement(By.xpath("//*[@id='iterator_1_product_custom_more-info-button']"));
		element.click();
		log.debug("Clicked More Info on first displayed result");
		// Thread.sleep(2000);

	}

	public void bookOnline() throws InterruptedException {

		element = driver.findElement(By.xpath("//*[@id=\"book-2276432a15eaf65ebfc0ffb211e6bf09\"]"));
		element.click();
		log.debug("Clicked Book Online");

	}

	public void clickContinue() throws InterruptedException {
		// wait= new WebDriverWait(driver,30);
		// element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paxDepDateForm\"]/div[4]/button")));
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//*[@id=\"paxDepDateForm\"]/div[4]/button"));
		element.click();
		log.debug("Clicked Continue");

	}

	public void clickRoomContinue() throws InterruptedException {
		// wait= new WebDriverWait(driver,30);
		// element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paxDepDateForm\"]/div[4]/button")));
		//
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//*[@id=\"accomForm-select\"]/button"));
		element.click();
		//

	}

	public void clickRoomWithoutExtra() throws InterruptedException {
		// wait= new WebDriverWait(driver,30);
		// element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"paxDepDateForm\"]/div[4]/button")));
		Thread.sleep(2000);
		element = driver.findElement(By.xpath("//*[@id=\"extrasButton\"]"));
		element.click();

	}

	public void defaultRadio() throws InterruptedException {
		Thread.sleep(3000);
		element = driver.findElement(By.xpath("//*[@id=\"calbox-2276432a15eaf65ebfc0ffb211e6bf09-1\"]"));
		if (element.isSelected()) {
			log.debug("First Available Date is Selected");
		} else {
			log.debug("First Available Date is Selected");
		}

	}

	public void selRoom() throws InterruptedException {
		Thread.sleep(3000);
		element = driver.findElement(By.xpath("//*[@id=\"room-0-numselect\"]"));
		Select sel = new Select(element);
		sel.selectByIndex(1);
		log.debug("Standard Room Selected");

	}

	public String comp() {
		String str1 = driver.findElement(By.xpath("//*[@id=\"nbf_product_pricingsummary\"]/div[2]/div[2]")).getText();
		return str1;
	}

	public void passengerForm() throws InterruptedException {
		System.out.println("passengerForm");
		Thread.sleep(10000);
		Select sel11 = new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-title-1\"]")));
		sel11.selectByVisibleText("Ms");
//		driver.findElement(By.xpath("//*[@id=\"pax-a-first-1\"]")).sendKeys("ABC");
		element = driver.findElement(By.id("pax-a-first-1"));

		element.sendKeys("ABC");
//		driver.findElement(By.xpath("//*[@id=\"pax-a-last-1\"]")).sendKeys("defg");
		driver.findElement(By.id("pax-a-last-1")).sendKeys("defg");
		Select sel12 = new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-dobd-1\"]")));
		sel12.selectByIndex(12);
		Select sel13 = new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-dobm-1\"]")));
		sel13.selectByVisibleText("March");
		Select sel14 = new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-doby-1\"]")));
		sel14.selectByVisibleText("1984");
		Select sel21 = new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-title-2\"]")));
		sel21.selectByVisibleText("Mrs");
		driver.findElement(By.xpath("//*[@id=\"pax-a-first-2\"]")).sendKeys("xgt");
		driver.findElement(By.xpath("//*[@id=\"pax-a-last-2\"]")).sendKeys("hfg");
		Select sel22 = new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-dobd-2\"]")));
		sel22.selectByIndex(14);
		Select sel23 = new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-dobm-2\"]")));
		sel23.selectByVisibleText("July");
		Select sel24 = new Select(driver.findElement(By.xpath("//*[@id=\"pax-a-doby-2\"]")));
		sel24.selectByVisibleText("2000");
		driver.findElement(By.xpath("//*[@id=\"contact-mobile\"]")).sendKeys("0576878544353");
		driver.findElement(By.xpath("//*[@id=\"contact-email\"]")).sendKeys("ABC@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"contact-address1\"]")).sendKeys("AB");
		driver.findElement(By.xpath("//*[@id=\"contact-address2\"]")).sendKeys("ABC");
		driver.findElement(By.xpath("//*[@id=\"contact-city\"]")).sendKeys("ABC");
		driver.findElement(By.xpath("//*[@id=\"contact-postcode\"]")).sendKeys("AB123C");
		Select sel31 = new Select(driver.findElement(By.xpath("//*[@id=\"contact-country\"]")));
		sel31.selectByVisibleText("United Kingdom");

		Select sel32 = new Select(driver.findElement(By.xpath("//*[@id=\"contact-hearabout\"]")));
		sel32.selectByVisibleText("Email");
		driver.findElement(By.xpath("//*[@id=\"contact-promocode\"]")).sendKeys("agjh123");
		driver.findElement(By.xpath("//*[@id=\"paxform-select\"]/button")).click();
		log.debug("Passenger Form filled");

	}

	public void comp2() throws InterruptedException {
		Thread.sleep(10000);
		String actPrice = comp();

		String calculatedPrice = driver.findElement(By.className("nbf_total"))
				.getText();
		
		if (actPrice.equals(calculatedPrice)) {
			log.debug(" Payment amount is as per selected Accomodation ");
		
		} else {
			log.debug("Payment amount is not as per selected Accomodation ");
		}
		Assert.assertEquals(actPrice, calculatedPrice);
		
	    driver.close();
		driver.quit();
	}

}
