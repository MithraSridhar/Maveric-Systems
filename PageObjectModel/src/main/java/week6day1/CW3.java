package week6day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CW3 {
	@Test
	public void sort() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// maximize browser
		driver.manage().window().maximize();
		// Step2: Load URL
		driver.get("http://jqueryui.com/sortable/");
		// Set timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));

		WebElement item1 = driver.findElementByXPath("//ul[@id='sortable']/li[1]");
		WebElement item2 = driver.findElementByXPath("//ul[@id='sortable']/li[5]");
		int y = item2.getLocation().getY();

		Actions builder = new Actions(driver);
		builder.clickAndHold(item1).perform();

		builder.moveByOffset(0, y).release().perform();
	}

}
