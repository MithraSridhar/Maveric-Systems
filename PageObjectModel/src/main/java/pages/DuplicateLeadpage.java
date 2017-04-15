package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class DuplicateLeadpage extends LeafTapsWrappers {
	
	public DuplicateLeadpage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if (!verifyTitle("Duplicate Lead | opentaps CRM")) {
			reportStep("This is not Duplicate Lead Page", "Fail");
		}
	}
	
public ViewLead clickcreatelead(){
	clickByXpath("//input[@class='smallSubmit']");
	return new ViewLead(driver,test);
}
}
