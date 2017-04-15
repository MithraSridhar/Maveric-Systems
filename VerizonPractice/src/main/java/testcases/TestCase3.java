package testcases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wrappers.TestNGMethods;

public class TestCase3 extends TestNGMethods{
	
	@BeforeClass
	public void setData() {
		testCaseName="Same URL MUL browser check";
		testDescription="Creating Leads";
		browserName="chrome";
		//dataSheetName="TC001";
		category="Smoke";
		authors="Mithra";
	}
@Test	
	public void mulbrowsercheck() throws InterruptedException {
	login();	
    String url=getcurrenturl();
    System.out.println(url);
   openurl(url);
   switchToLastWindow();
   verifyTitle("Login.Page.Title");
}

}