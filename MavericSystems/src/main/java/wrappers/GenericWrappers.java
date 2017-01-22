package wrappers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers {
	protected RemoteWebDriver driver;
	int i;

	// Based on your need you can choose your browser on which you want to run
	// the test script
	@Override
	public void invokeApp(String browser, String Url) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("gecko")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			System.setProperty("webdriver.safari.driver", "./drivers/safaridriver.exe");
			driver = new SafariDriver();
		}

		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("The browser " + browser + " launched successfully.");
	}

	@Override
	public void enterById(String idValue, String data) {
		driver.findElementById(idValue).clear();
		driver.findElementById(idValue).sendKeys(data);
		System.out.println("The Text field " + idValue + " is entered with text " + data + " successfully.");
	}

	@Override
	public void enterByName(String nameValue, String data) {
		driver.findElementByName(nameValue).clear();
		driver.findElementByName(nameValue).sendKeys(data);
		System.out.println("The Text field " + nameValue + " is entered with text " + data + " successfully.");

	}

	@Override
	public void enterByXpath(String xpathValue, String data) {
		driver.findElementByXPath(xpathValue).clear();
		driver.findElementByXPath(xpathValue).sendKeys(data);
		System.out.println("The Text field " + xpathValue + " is entered with text " + data + " successfully.");
	}

	@Override
	public void verifyTitle(String title) {
		String text = driver.getTitle();
		if (text.equals(title)) {
			System.out.println("The title " + title + " matches with the actual title " + text + "");
		} else {
			System.out.println("The title " + title + " is not matches with the actual title " + text + "");
		}

	}

	@Override
	public void verifyTextById(String id, String text) {
		if (driver.findElementById(id).getText().equals(text)) {
			System.out.println("The field  " + id + " with the text " + text + " equals my name");
		} else {
			System.out.println("The field  " + id + " with the text " + text + " does not equals my name");
		}

	}

	@Override
	public void verifyTextByXpath(String xpath, String text) {
		if (driver.findElementByXPath(xpath).getText().equals(text)) {
			System.out.println("The field  " + xpath + " with the text " + text + " equals my name");
		} else {
			System.out.println("The field  " + xpath + " with the text " + text + " does not equals my name");
		}

	}

	@Override
	public void verifyTextContainsByXpath(String xpath, String text) {
		if (driver.findElementByXPath(xpath).getText().contains(text)) {
			System.out.println("The field  " + xpath + " with the text " + text + " equals my name");
		} else {
			System.out.println("The field  " + xpath + " with the text " + text + " does not equals my name");
		}

	}

	@Override
	public void clickById(String id) {
		driver.findElementById(id).click();
		System.out.println("The button or element " + id + " is clicked successfully.");

	}

	@Override
	public void clickByClassName(String classVal) {
		driver.findElementByClassName(classVal).click();
		System.out.println("The button or element " + classVal + " is clicked successfully.");

	}

	@Override
	public void clickByName(String name) {
		driver.findElementByName(name).click();
		System.out.println("The button or element " + name + " is clicked successfully.");

	}

	@Override
	public void clickByLink(String name) {
		driver.findElementByLinkText(name).click();
		System.out.println("The button or element " + name + " is clicked successfully.");

	}

	@Override
	public void clickByLinkNoSnap(String name) {

	}

	@Override
	public void clickByXpath(String xpathVal) {
		driver.findElementByXPath(xpathVal).click();
		System.out.println("The button or element " + xpathVal + " is clicked successfully.");

	}

	@Override
	public String getTextById(String idVal) {
		System.out.println(driver.findElementById(idVal).getText());
		return idVal;
	}

	@Override
	public String getTextByXpath(String xpathVal) {
		System.out.println(driver.findElementByXPath(xpathVal).getText());
		return xpathVal;
	}

	@Override
	public void selectVisibileTextById(String id, String value) {
		WebElement source = driver.findElementById(id);
		Select dropdown = new Select(source);
		dropdown.selectByVisibleText(value);
		System.out.println("The field " + id + " contains the text " + value + "");

	}

	@Override
	public void selectIndexById(String id, int value) {
		WebElement source = driver.findElementById(id);
		Select dropdown = new Select(source);
		dropdown.selectByIndex(value);
		System.out.println("The field " + id + " contains the text " + value + "");

	}

	@Override
	public void acceptAlert() {
		String text = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("The Alert containd text " + text + " is accepted");
	}

	@Override
	public void takeSnap() {

	}

	@Override
	public void closeBrowser() {
		driver.close();

	}

	@Override
	public void closeAllBrowsers() {

		driver.quit();
	}

	public void switchToFrame(String name) {
		driver.switchTo().frame(name);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

}
