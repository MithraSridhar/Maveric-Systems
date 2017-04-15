package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wrappers.TestNGMethods;

public class TestCase8 extends TestNGMethods{
	
	@BeforeClass
	public void setData() {
		testCaseName="Sensitive Data In URL check";
		testDescription="Creating Leads";
		browserName="chrome";
		//dataSheetName="TC001";
		category="Smoke";
		authors="Mithra";
	}
@Test	
	public void sensdatacheck() throws InterruptedException {
	login();
	clickByLink("CRM/SFA");
	String curl=getcurrenturl();
	System.out.println(curl);
	clickByXpath("CRH.Home.logout");
	
}

}

