package testcases;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wrappers.TestNGMethods;

public class TestCase1 extends TestNGMethods{
	
	@BeforeClass
	public void setData() {
		testCaseName="backbuttoncheck";
		testDescription="Creating Leads";
		browserName="chrome";
		//dataSheetName="TC001";
		category="Smoke";
		authors="Mithra";
	}
@Test	
	public void backbuttoncheck() {
	login();
	clickByClassName("Home.Logout.Class");	
	navigateback();
	verifyTitle("Home.Page.Title");
}

}

