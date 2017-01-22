package testscript;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import wrappers.AnnotationsSetup;

public class Scenario1 extends AnnotationsSetup {

	@BeforeClass
	public void setData() {
		dataSheetName = "TC1";
	}

	@Test(dataProvider = "fetchData")
	public void getAccountDetails(String CID, String PW) throws InterruptedException {
		login(CID, PW);
		switchToFrame("main_part");
		clickByXpath("//span[@class='tableHeaderPSM']");
		String Expectedaccno = "50100032464093";
		String Expectedaccbal = "Total Available Balance: INR 10,341.01";
		String Accoutno = driver.findElementByXPath("//tr[@class='unhideSavingAccts']/td/a").getText();
		System.out.println(Accoutno);
		Assert.assertEquals(Expectedaccno, Accoutno);
		String Accoutbal = driver.findElementByXPath("//span[@id='SavingTotalSummary']").getText();
		System.out.println(Accoutbal);
		Assert.assertEquals(Expectedaccbal, Accoutbal);
		switchToDefaultContent();
		switchToFrame("common_menu1");
		clickByXpath("//img[@src='default/gif/logoutbtn.gif']");

	}
}
