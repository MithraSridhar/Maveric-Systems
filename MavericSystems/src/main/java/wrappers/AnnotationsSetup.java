package wrappers;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import utils.DataInputProvider;

public class AnnotationsSetup extends GenericWrappers {
	public String browser;
	public String Url;
	public String dataSheetName;

	@Parameters({ "browser", "Url" })
	@BeforeMethod
	public void beforeMethod(String browser, String URL) {
		invokeApp(browser, URL);

	}

	@DataProvider(name = "fetchData")
	public Object[][] getData() {
		return DataInputProvider.getSheet(dataSheetName);
	}

	public void login(String CID, String PW) {
		switchToFrame("login_page");
		enterByName("fldLoginUserId", CID);
		clickByXpath("//img[@src='/gif/continue_new1.gif?v=1']");
		enterByXpath("(//input[@class='input_password'])[2]", PW);
		clickByXpath("//input[@name='chkrsastu']");
		clickByXpath("//img[@src='/gif/login_new1.gif']");
	}
}
