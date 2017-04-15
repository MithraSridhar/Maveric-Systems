package week6day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CW2 {
	@Test
	public void resize() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// maximize browser
		driver.manage().window().maximize();
		// Step2: Load URL
		driver.get("http://jqueryui.com/resizable/");
		// Set timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));

		WebElement resizepoint = driver.findElementByXPath(
				"//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']");
		Actions builder = new Actions(driver);
		// builder.clickAndHold(resizepoint).moveByOffset(367,
		// 193).build().perform();
		builder.moveToElement(resizepoint).clickAndHold().moveByOffset(367, 193).build().perform();

		
	}
}