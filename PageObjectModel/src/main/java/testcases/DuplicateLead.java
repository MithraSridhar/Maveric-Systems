package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.DuplicateLeadpage;
import pages.FindLead;
import pages.LoginPage;
import pages.ViewLead;
import utils.DataInputProvider;
import wrappers.LeafTapsWrappers;

public class DuplicateLead extends LeafTapsWrappers {
	public String dataSheetName4;
	@BeforeClass
	public void setData() {
		testCaseName="DuplicateLead";
		testDescription="Duplicating Leads";
		browserName="chrome";
		dataSheetName4="TC004";
		category="Smoke";
		authors="Mithra";
	}
	@Test(dataProvider="fetchData4")
	public void DUL(String mailid) throws InterruptedException{
		new LoginPage(driver, test).
		enterUserName()
		.enterPassword()
		.clickLogin()
		.clickcrmsfa()
		.clickleads()
		.clickfindlead()
		.findleadbyemail();
		Thread.sleep(3000);
		new FindLead(driver,test). 
		enterbyemail(mailid)
		.clickfindlead();
		Thread.sleep(3000);
		new FindLead(driver,test).clickleadbyxpath();
		Thread.sleep(3000);
		String origLeadname =new ViewLead(driver,test).getleadname();
		System.out.println("Orig Lead name is " + origLeadname + "");
		new ViewLead(driver,test).clickduplicatelead();
		Thread.sleep(3000);
		new DuplicateLeadpage(driver,test).clickcreatelead();
		Thread.sleep(3000);
		String dupLeadname  =new ViewLead(driver,test).getleadname();
		System.out.println("Orig Lead name is " + dupLeadname  + "");
		
		
		if (origLeadname.equals(dupLeadname))

		{
			System.out
					.println("The original " + origLeadname + " and duplicated " + dupLeadname + " Lead ID's are same");

		} else {
			System.out.println(
					"The original " + origLeadname + " and duplicated " + dupLeadname + " Lead ID's are not same");
		}
	}
	@DataProvider(name="fetchData4")
	public Object[][] getData(){
		return DataInputProvider.getSheet(dataSheetName4);		
	}	
}
