package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FindLead;
import pages.LoginPage;
import pages.MyLeads;
import pages.ViewLead;
import utils.DataInputProvider;
import wrappers.LeafTapsWrappers;

public class DeleteLead extends LeafTapsWrappers {
	public String dataSheetName3;
	@BeforeClass
	public void setData() {
		testCaseName="Delete Lead";
		testDescription="Deleting Leads";
		browserName="chrome";
		dataSheetName3="TC003";
		category="Sanity";
		authors="Mithra";
	}
@Test(dataProvider="fetchData3")
public void DEL(String phoneno) throws InterruptedException
{
	new LoginPage(driver, test).
	enterUserName()
	.enterPassword()
	.clickLogin()
	.clickcrmsfa()
	.clickleads()
	.clickfindlead()
	.findleadbyphoneno();
	Thread.sleep(2000);
	new FindLead(driver,test).enterphoneno(phoneno);
	Thread.sleep(3000);
	new FindLead(driver,test).clickfindleadbytext();
	Thread.sleep(3000);
	new FindLead(driver,test).getleadidbyxpath();
	new FindLead(driver,test).clickleadbyxpath();	
	Thread.sleep(3000);
	new ViewLead(driver, test).clickdeletelead();
	Thread.sleep(3000);
	new MyLeads(driver, test).clickfindlead();
	Thread.sleep(3000);
	new FindLead(driver, test).findbyleadxpath();
	Thread.sleep(3000);
	new FindLead(driver, test).clickfindlead()
	 .verifynoleadtext();	
}

@DataProvider(name="fetchData3")
public Object[][] getData(){
	return DataInputProvider.getSheet(dataSheetName3);		
}	


}


