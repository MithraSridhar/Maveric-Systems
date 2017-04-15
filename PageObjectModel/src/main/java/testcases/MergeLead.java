package testcases;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLead;
import pages.LoginPage;
import pages.MergeLeadPage;
import pages.ViewLead;
import wrappers.LeafTapsWrappers;

public class MergeLead extends LeafTapsWrappers{
	//public String dataSheetName5;
	@BeforeClass
	public void setData() {
		testCaseName="DuplicateLead";
		testDescription="Duplicating Leads";
		browserName="chrome";
		//dataSheetName="TC004";
		category="Smoke";
		authors="Mithra";
	}

	
@Test
public void ML() throws InterruptedException{
		new LoginPage(driver, test).
		enterUserName()
		.enterPassword()
		.clickLogin()
		.clickcrmsfa()
		.clickleads()
		.clickmergelead();
		Thread.sleep(3000);
		new MergeLeadPage(driver,test).clickfromiconbyxpath();
		switchToLastWindow();
		Thread.sleep(3000);
		new FindLead(driver,test).clickfindleadbytext();
		Thread.sleep(4000);
		String src= new FindLead(driver,test).getleadidbyxpath();
		new FindLead(driver,test).clickleadbyxpath();
		switchToParentWindow();
		new MergeLeadPage(driver,test).clicktoiconbyxpath();
		switchToLastWindow();
		new FindLead(driver,test).clickfindleadbytext();
		Thread.sleep(4000);
		new FindLead(driver,test).clicksecondleadbyxpath();
		switchToParentWindow();
		new MergeLeadPage(driver,test).clickmerge();
		acceptAlert();
		Thread.sleep(4000);
		new ViewLead(driver,test).clickviewfindlead();
		new FindLead(driver,test).enterleadid(src)
		.clickfindleadbytext();
		  Thread.sleep(4000);
		  new FindLead(driver,test).verifynoleadtext();
		
	}
}
