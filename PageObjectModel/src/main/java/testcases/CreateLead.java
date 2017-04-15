package testcases;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class CreateLead extends LeafTapsWrappers{
	@BeforeClass
	public void setData() {
		testCaseName="CreateLead";
		testDescription="Creating Leads";
		browserName="chrome";
		dataSheetName="TC001";
		category="Smoke";
		authors="Mithra";
	}

	@Test(dataProvider="fetchData")
	public void login( String CN, String FN, String LN)
			{

		new LoginPage(driver, test)
		.enterUserName()
		.enterPassword()
		.clickLogin()
		.clickcrmsfa()
		.clickleads()
	     .clickcreateleads()
	     .entercompanyname(CN)
	     .enterfisrtname(FN)
	     .enterlastname(LN)
	     .clickcreatelead()
	     .getfirstname();
	}
	
}
