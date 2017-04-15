package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wrappers.TestNGMethods;

public class TestCase4 extends TestNGMethods{
	
	@BeforeClass
	public void setData() {
		testCaseName="Multi System check";
		testDescription="Creating Leads";
		browserName="chrome";
		//dataSheetName="TC001";
		category="Smoke";
		authors="Mithra";
	}
@Test	
	public void mulsyscheck() throws InterruptedException {
	login();	
	invokeApp(browserName);	
    login();
   
}

}

