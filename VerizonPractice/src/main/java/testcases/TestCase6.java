package testcases;

import org.openqa.selenium.JavascriptExecutor;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wrappers.TestNGMethods;

public class TestCase6 extends TestNGMethods{
	
	@BeforeClass
	public void setData() {
		testCaseName="History check";
		testDescription="Creating Leads";
		browserName="chrome";
		//dataSheetName="TC001";
		category="Smoke";
		authors="Mithra";
	}
@Test	
	public void historycheck() throws InterruptedException {
	login();
	clickByClassName("Home.Logout.Class");
	( (JavascriptExecutor)driver).executeScript("window.open('your url','_blank');");	
	switchToLastWindow();
	driver.navigate().to("chrome://history-frame/");
	Thread.sleep(5000);
	clickByXpath("History.URL");
	 verifyTitle("Login.Page.Title");
}

}

