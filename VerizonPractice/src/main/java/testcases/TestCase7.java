package testcases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wrappers.TestNGMethods;

public class TestCase7 extends TestNGMethods{
	
	@BeforeClass
	public void setData() {
		testCaseName="Timeout check";
		testDescription="Creating Leads";
		browserName="chrome";
		//dataSheetName="TC001";
		category="Smoke";
		authors="Mithra";
	}
@Test	
	public void timeoutcheck() throws InterruptedException {
	login();
	Thread.sleep(60000);
	clickByClassName("Home.Logout.Class");
	
}

}

