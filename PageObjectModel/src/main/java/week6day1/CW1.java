package week6day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wrappers.LeafTapsWrappers;

public class CW1 {
	public class CreateLead extends LeafTapsWrappers{
		@BeforeClass
		public void setData() {
			testCaseName="CW1";
			testDescription="CW1";
			browserName="chrome";
			//dataSheetName="TC001";
			category="Smoke";
			authors="Mithra";
		}
	@Test
	public void drag() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		// maximize browser
		driver.manage().window().maximize();
		// Step2: Load URL
		driver.get("http://jqueryui.com/draggable/");
		// Set timeout
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		WebElement dragable = driver.findElementById("draggable");
		// WebElement droppable =
		// driver.findElementByXPath("//div[@style='position: relative; left:
		// 229px; top: 23px;']");
		// int xoffset = droppable.getLocation().getX();
		// int yOffset = droppable.getLocation().getY();
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(dragable, 229, 23).build().perform();

	}
}
}