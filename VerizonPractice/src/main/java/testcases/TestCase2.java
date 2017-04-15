package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wrappers.TestNGMethods;

public class TestCase2 extends TestNGMethods{
	
	@BeforeClass
	public void setData() {
		testCaseName="Close button check";
		testDescription="Creating Leads";
		browserName="chrome";
		//dataSheetName="TC001";
		category="Smoke";
		authors="Mithra";
	}
@Test	
	public void backbuttoncheck() throws InterruptedException {
	login();
	Thread.sleep(5000);
	closeBrowser();
	invokeApp(browserName);	
	verifyTitle("Login.Page.Title");
	//Thread.sleep(5000);
}

}

