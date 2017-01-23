package testscript;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import wrappers.AnnotationsSetup;

public class Scenario2 extends AnnotationsSetup {

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
	public void viewBeneList(String CID, String PW) throws InterruptedException {
		login(CID, PW);
		switchToFrame("common_menu1");
		clickByXpath("//a[@title='Funds Transfer']");
		Thread.sleep(3000);
		switchToDefaultContent();
		switchToFrame("left_menu");
		clickByXpath("(//a[@class='accounts opener'])[2]");
		clickByXpath("//li[@id='TPI_nohref']");
		switchToDefaultContent();
		switchToFrame("main_part");
		clickByXpath("//img[@src='default/gif/view_grey_btn.gif']");
		WebElement table1 = driver.findElementByXPath("//table[@class='datatable']");
		List<WebElement> rows = table1.findElements(By.tagName("tr"));
		int rowcount = rows.size();
		System.out.println(rowcount);
		List<WebElement> cols = rows.get(0).findElements(By.tagName("th"));
		int colcount = cols.size();
		System.out.println(colcount);
		/*
		 * Below I am returning all the rows in the Beneficiaries table, as it
		 * is not static you can add your asserts based on the application
		 * tested.
		 */for (int i = 0; i <= rowcount; i++) {
			System.out.println(rows.get(i).getText());
		}
		switchToDefaultContent();
		switchToFrame("common_menu1");
		clickByXpath("//img[@src='default/gif/logoutbtn.gif']");

	}
}
