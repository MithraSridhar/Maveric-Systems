package testcases;




import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wrappers.TestNGMethods;

public class TestCase5  extends TestNGMethods{
	
	@BeforeClass
	public void setData() {
		testCaseName="Cookies check";
		testDescription="Creating Leads";
		browserName="chrome";
		//dataSheetName="TC001";
		category="Smoke";
		authors="Mithra";
	}
@Test	
	public void cookiescheck() throws InterruptedException {
	login();
	clickByClassName("Home.Logout.Class");
	getcookies();
}

}
