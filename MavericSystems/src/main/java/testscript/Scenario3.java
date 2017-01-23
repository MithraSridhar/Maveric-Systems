package testscript;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import wrappers.AnnotationsSetup;

public class Scenario3 extends AnnotationsSetup {

	@BeforeClass
	public void setData() {
		/*
		 * In the excel sheet "TC1" which is located in the "data" folder, the given customer ID and password are dummy
		 * values, please update it with the real account details and run the
		 * script
		 */
		dataSheetName = "TC1";
	}

	@Test(dataProvider = "fetchData")
	public void addBene(String CID, String PW) throws InterruptedException {
		login(CID, PW);
		switchToFrame("common_menu1");
		clickByXpath("//a[@title='Funds Transfer']");
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame("left_menu");
		Thread.sleep(3000);
		clickByXpath("//li[@class='accord-menu last-child']");
		clickByXpath("//li[@id='TPA_nohref']");
		switchToDefaultContent();
		switchToFrame("main_part");
		clickByXpath("//img[@src='default/gif/go_grey_btn.gif']");
		switchToDefaultContent();
		switchToFrame("main_part");
		/*
		 * Below are dummy account number, please update it with the real
		 * account number and run the script
		 */
		enterByXpath("//input[@name='fldAcctNo']", "00000052709999");
		enterByXpath("//input[@name='fldAcctNo2']", "00000052709999");
		enterByXpath("//input[@name='fldNamBenef']", "Sri");
		enterByXpath("//input[@name='fldEmail']", "srdhar@gmail.com");
		clickByXpath("//img[@src='default/gif/add.gif']");
		acceptAlert();
		switchToDefaultContent();
		switchToFrame("main_part");
		clickByXpath("//img[@src='default/gif/confirm.gif']");
		switchToDefaultContent();
		switchToFrame("main_part");
		clickByXpath("//input[@name='fldMobile']");
		clickByXpath("//img[@src='default/gif/continue.gif']");
		switchToDefaultContent();
		switchToFrame("main_part");
		/*
		 * In the next next step I am hard coding the OTP which will be sent to
		 * the account holders mobile number which require manual interruption
		 */
		enterByXpath("//input[@name='fldOtpToken']", "024685");
		clickByXpath("//img[@src='default/gif/continue.gif']");
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame("common_menu1");
		clickByXpath("//img[@src='default/gif/logoutbtn.gif']");

	}
}
