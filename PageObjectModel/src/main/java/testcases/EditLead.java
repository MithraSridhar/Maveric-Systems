package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FindLead;
import pages.LoginPage;
import pages.ViewLead;
import utils.DataInputProvider;
import wrappers.LeafTapsWrappers;

public class EditLead extends LeafTapsWrappers{
	public String dataSheetName1;
	@BeforeClass
	public void setData() {
		testCaseName="EditLead";
		testDescription="Editing Leads";
		browserName="chrome";
		dataSheetName1="TC002";
		category="Sanity";
		authors="Mithra";
	}
@Test(dataProvider="fetchData2")
public void EL(String ECN,String EFN,String editedCN) throws InterruptedException
{
	new LoginPage(driver, test).
	enterUserName()
	.enterPassword()
	.clickLogin()
	.clickcrmsfa()
	.clickleads()
	.clickfindlead()
	.enterfirstname(EFN);
	Thread.sleep(2000);
	new FindLead(driver, test).clickfindlead();
	Thread.sleep(3000);
	new FindLead(driver, test).clicklead("15135");
	Thread.sleep(3000);
	new ViewLead(driver, test).clickeditlead()
	.entereditname(ECN)
	.clicksubmit()
	.getcompanyname(editedCN);
	
}

@DataProvider(name="fetchData2")
public Object[][] getData(){
	return DataInputProvider.getSheet(dataSheetName1);		
}	

}
