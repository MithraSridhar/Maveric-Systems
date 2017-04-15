package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriverException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import utils.Reporter;

public class CommonMethods extends Reporter {
	public CommonMethods(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl, primaryWindowHandle, username, password;

	public CommonMethods() {
		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			username = prop.getProperty("UN");
			password = prop.getProperty("PW");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void loadObjects() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/object.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void unloadObjects() {
		prop = null;
	}

	/**
	 * This method will launch the browser in grid node (if remote) and maximise
	 * the browser and set the wait for 30 seconds and load the url
	 * 
	 * @author M -
	 * @param url
	 *            - The url with http or https
	 * 
	 */

	public void invokeApp(String browser) {
		try {

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);

			primaryWindowHandle = driver.getWindowHandle();
			reportStep("The browser:" + browser + " launched successfully", "PASS");

		} catch (Exception e) {
			e.printStackTrace();
			reportStep("The browser:" + browser + " could not be launched", "FAIL");
		} finally {
			takeSnap();
		}
	}

	public void login() {

		try {
			enterById("Login.UserName.Id", username);
			enterByXpath("Login.Password.Id", password);
			clickByClassName("Login.LoginButton.Class");
			reportStep("The data: entered successfully in field :", "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data:  could not be entered in the field :", "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering in the field :", "FAIL");
		} finally {
			takeSnap();
		}

	}

	public void navigateback() {
		try {
			driver.navigate().back();
			reportStep("The browser navigated to the previous page successfully", "PASS");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering in the field :", "FAIL");
		} finally {
			takeSnap();
		}

	}

	public void openurl(String URL) {
		try {
			((JavascriptExecutor) driver).executeScript("window.open('URL','_blank');");
			reportStep("THe URL " + URL + " Opened successfully :", "PASS");
		} catch (Exception e) {
			reportStep("THe URL " + URL + " could not be Opened:", "FAIL");
		} finally {
			takeSnap();
		}

	}

	public void getcookies() {

		Set<Cookie> cookie = null;
		try {
			cookie = driver.manage().getCookies();
			System.out.println(cookie);
			reportStep("The Cookie " + cookie + " captured successfully :", "PASS");
		} catch (Exception e) {

			reportStep("The Cookie " + cookie + " could not be captured:", "PASS");
		} finally {
			takeSnap();
		}

	}

	/**
	 * This method will enter the value to the text field using id attribute to
	 * locate
	 * 
	 * @param idValue
	 *            - id of the webelement
	 * @param data
	 *            - The data to be sent to the webelement
	 * @author M -
	 * @throws IOException
	 * @throws COSVisitorException
	 */

	public void enterById(String element, String data) {
		try {
			driver.findElementById(prop.getProperty(element)).clear();
			driver.findElementById(prop.getProperty(element)).sendKeys(data);
			reportStep("The data: " + data + " entered successfully in field :" + prop.getProperty(element), "PASS");
		} catch (NoSuchElementException e) {
			reportStep("The data: " + data + " could not be entered in the field :" + prop.getProperty(element),
					"FAIL");
		} catch (Exception e) {
			reportStep(
					"Unknown exception occured while entering " + data + " in the field :" + prop.getProperty(element),
					"FAIL");
		} finally {
			takeSnap();
		}
	}

	/**
	 * This method will enter the value to the text field using name attribute
	 * to locate
	 * 
	 * @param nameValue
	 *            - name of the webelement
	 * @param data
	 *            - The data to be sent to the webelement
	 * @author M -
	 * @throws IOException
	 * @throws COSVisitorException
	 */
	public void enterByClassName(String element, String data) {
		try {
			driver.findElementByClassName(prop.getProperty(element)).clear();
			driver.findElementByClassName(prop.getProperty(element)).sendKeys(data);
			reportStep("The data: " + data + " entered successfully in field :" + prop.getProperty(element), "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: " + data + " could not be entered in the field :" + prop.getProperty(element),
					"FAIL");
		} catch (Exception e) {
			reportStep(
					"Unknown exception occured while entering " + data + " in the field :" + prop.getProperty(element),
					"FAIL");
		} finally {
			takeSnap();
		}

	}

	/**
	 * This method will enter the value to the text field using name attribute
	 * to locate
	 * 
	 * @param xpathValue
	 *            - xpathValue of the webelement
	 * @param data
	 *            - The data to be sent to the webelement
	 * @author M -
	 * @throws IOException
	 * @throws COSVisitorException
	 */
	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElementByXPath(prop.getProperty(xpathValue)).clear();
			driver.findElementByXPath(prop.getProperty(xpathValue)).sendKeys(data);
			reportStep("The data: " + data + " entered successfully in field :" + xpathValue, "PASS");

		} catch (NoSuchElementException e) {
			reportStep("The data: " + data + " could not be entered in the field :" + xpathValue, "FAIL");
		} catch (Exception e) {
			reportStep("Unknown exception occured while entering " + data + " in the field :" + xpathValue, "FAIL");
		}

	}

	/**
	 * This method will verify the title of the browser
	 * 
	 * @param title
	 *            - The expected title of the browser
	 * @author M -
	 */
	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		try {
			if (driver.getTitle().equalsIgnoreCase(prop.getProperty(title))) {
				reportStep("The title of the page matches with the value :" + title, "PASS");
				bReturn = true;
			} else
				reportStep("The title of the page:" + driver.getTitle() + " did not match with the value :" + title,
						"SUCCESS");

		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
		return bReturn;
	}

	public void quitBrowser() {
		try {
			driver.quit();
			reportStep("The browser:" + driver.getCapabilities().getBrowserName() + "closed Successfully.", "PASS");

		} catch (Exception e) {
			reportStep("The browser:" + driver.getCapabilities().getBrowserName() + " could not be closed.", "FAIL");
		} finally {
			takeSnap();
		}

	}

	public void closeBrowser() {
		try {
			driver.close();
			reportStep1("The browser:" + driver.getCapabilities().getBrowserName() + "closed Successfully.", "PASS");

		} catch (Exception e) {
			reportStep1("The browser:" + driver.getCapabilities().getBrowserName() + " could not be closed.", "FAIL");
		}
		/*
		 * finally{ takeSnap(); }
		 */

	}

	/**
	 * This method will verify the given text matches in the element text
	 * 
	 * @param xpath
	 *            - The locator of the object in xpath
	 * @param text
	 *            - The text to be verified
	 * @author M -
	 */
	public void verifyTextByXpath(String xpath, String text) {
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.equalsIgnoreCase(text)) {
				reportStep("The text: " + sText + " matches with the value :" + text, "PASS");
			} else {
				reportStep("The text: " + sText + " did not match with the value :" + text, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * 
	 * @param xpath
	 *            - The locator of the object in xpath
	 * @param text
	 *            - The text to be verified
	 * @author M -
	 */
	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)) {
				reportStep("The text: " + sText + " contains the value :" + text, "PASS");
			} else {
				reportStep("The text: " + sText + " did not contain the value :" + text, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * 
	 * @param id
	 *            - The locator of the object in id
	 * @param text
	 *            - The text to be verified
	 * @author M -
	 */
	public void verifyTextById(String id, String text) {
		try {
			String sText = driver.findElementById(id).getText();
			if (sText.equalsIgnoreCase(text)) {
				reportStep("The text: " + sText + " matches with the value :" + text, "PASS");
			} else {
				reportStep("The text: " + sText + " did not match with the value :" + text, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * 
	 * @param id
	 *            - The locator of the object in id
	 * @param text
	 *            - The text to be verified
	 * @author M -
	 */
	public void verifyTextContainsById(String id, String text) {
		try {
			String sText = driver.findElementById(id).getText();
			if (sText.contains(text)) {
				reportStep("The text: " + sText + " contains the value :" + text, "PASS");
			} else {
				reportStep("The text: " + sText + " did not contain the value :" + text, "FAIL");
			}
		} catch (Exception e) {
			reportStep("Unknown exception occured while verifying the title", "FAIL");
		}
	}

	/**
	 * This method will close all the browsers
	 * 
	 * @author M -
	 */

	/**
	 * This method will click the element using id as locator
	 * 
	 * @param id
	 *            The id (locator) of the element to be clicked
	 * @author M -
	 */
	public void clickById(String id) {
		try {
			driver.findElement(By.id(id)).click();
			reportStep("The element with id: " + id + " is clicked.", "PASS");

		} catch (Exception e) {
			reportStep("The element with id: " + id + " could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using id as locator
	 * 
	 * @param id
	 *            The id (locator) of the element to be clicked
	 * @author M -
	 */
	public void clickByClassName(String element) {
		try {
			driver.findElementByClassName(prop.getProperty(element)).click();
			reportStep("The element with class Name: " + element + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with class Name: " + element + " could not be clicked.", "FAIL");
		} finally {
			takeSnap();
		}
	}

	/**
	 * This method will click the element using name as locator
	 * 
	 * @param name
	 *            The name (locator) of the element to be clicked
	 * @author M -
	 */
	public void clickByName(String name) {
		try {
			driver.findElement(By.name(name)).click();
			reportStep("The element with name: " + name + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with name: " + name + " could not be clicked.", "FAIL");
		}
	}

	public String getcurrenturl() {
		String CURL = null;
		try {
			CURL = driver.getCurrentUrl();
			reportStep("The URL got captured", "PASS");
		} catch (Exception e) {
			reportStep("The URL did not get captured", "FAIL");
		} finally {
			takeSnap();
		}
		return CURL;
	}

	/**
	 * This method will click the element using link name as locator
	 * 
	 * @param name
	 *            The link name (locator) of the element to be clicked
	 * @author M -
	 */
	public void clickByLink(String name) {
		try {
			driver.findElement(By.linkText(name)).click();
			reportStep("The element with link name: " + name + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with link name: " + name + " could not be clicked.", "FAIL");
		}
	}

	/**
	 * This method will click the element using xpath as locator
	 * 
	 * @param xpathVal
	 *            The xpath (locator) of the element to be clicked
	 * @author M -
	 */
	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(prop.getProperty(xpathVal)).click();
			reportStep("The element : " + xpathVal + " is clicked.", "PASS");
		} catch (Exception e) {
			reportStep("The element with xpath: " + xpathVal + " could not be clicked.", "FAIL");
		} finally {
			takeSnap();
		}
	}

	/**
	 * This method will mouse over on the element using xpath as locator
	 * 
	 * @param xpathVal
	 *            The xpath (locator) of the element to be moused over
	 * @author M -
	 */
	public void mouseOverByXpath(String xpathVal) {
		try {
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			reportStep("The mouse over by xpath : " + xpathVal + " is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by xpath : " + xpathVal + " could not be performed.", "FAIL");
		}
	}

	/**
	 * This method will mouse over on the element using link name as locator
	 * 
	 * @param xpathVal
	 *            The link name (locator) of the element to be moused over
	 * @author M -
	 */
	public void mouseOverByLinkText(String linkName) {
		try {
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			reportStep("The mouse over by link : " + linkName + " is performed.", "PASS");
		} catch (Exception e) {
			reportStep("The mouse over by link : " + linkName + " could not be performed.", "FAIL");
		}
	}

	/**
	 * This method will return the text of the element using xpath as locator
	 * 
	 * @param xpathVal
	 *            The xpath (locator) of the element
	 * @author M -
	 */
	public String getTextByXpath(String xpathVal) {
		String bReturn = "";
		try {
			return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			reportStep("The element with xpath: " + xpathVal + " could not be found.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will return the text of the element using id as locator
	 * 
	 * @param xpathVal
	 *            The id (locator) of the element
	 * @author M -
	 */
	public String getTextById(String idVal) {
		String bReturn = "";
		try {
			return driver.findElementById(idVal).getText();
		} catch (Exception e) {
			reportStep("The element with id: " + idVal + " could not be found.", "FAIL");
		}
		return bReturn;
	}

	/**
	 * This method will select the drop down value using id as locator
	 * 
	 * @param id
	 *            The id (locator) of the drop down element
	 * @param value
	 *            The value to be selected (visibletext) from the dropdown
	 * @author M -
	 */
	public void selectVisibileTextById(String id, String value) {
		try {
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);
			;
			reportStep("The element with id: " + id + " is selected with value :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The value: " + value + " could not be selected.", "FAIL");
		}
	}

	public void selectVisibileTextByXPath(String xpath, String value) {
		try {
			new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(value);
			;
			reportStep("The element with xpath: " + xpath + " is selected with value :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The value: " + value + " could not be selected.", "FAIL");
		}
	}

	public void selectIndexById(String id, String value) {
		try {
			new Select(driver.findElement(By.id(id))).selectByIndex(Integer.parseInt(value));
			;
			reportStep("The element with id: " + id + " is selected with index :" + value, "PASS");
		} catch (Exception e) {
			reportStep("The index: " + value + " could not be selected.", "FAIL");
		}
	}

	public void switchToParentWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
				break;
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the first window.", "FAIL");
		}
	}

	public void switchToLastWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
			reportStep("The window switched to the last window.", "PASS");
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window.", "FAIL");
		} finally {
			takeSnap();
		}
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}

	}

	public String getAlertText() {
		String text = null;
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}
		return text;

	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			reportStep("The alert could not be found.", "FAIL");
		} catch (Exception e) {
			reportStep("The alert could not be accepted.", "FAIL");
		}

	}

	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {

			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
					new File("./reports/images/" + number + ".jpg"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (WebDriverException e) {
			// reportStep("The browser has been closed.", "FAIL");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken", "WARN");
		}
		return number;
	}

}
