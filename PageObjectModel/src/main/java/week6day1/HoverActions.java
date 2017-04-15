package week6day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public  class HoverActions{

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		WebElement ele = driver.findElementByXPath("//span[contains(text(),'Electronics')]");
		WebElement apple = driver.findElementByXPath("//span[contains(text(),'Apple')]");
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).build().perform();
		Thread.sleep(3000);
		
		builder.moveToElement(apple).click().build().perform();
	}

}