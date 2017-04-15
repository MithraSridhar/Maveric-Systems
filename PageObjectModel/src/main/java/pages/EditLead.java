package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class EditLead extends LeafTapsWrappers{
	
	public EditLead(RemoteWebDriver driver, ExtentTest test) {
		
		this.driver = driver;
		this.test = test;
		
		if (!verifyTitle("opentaps CRM")) {
			reportStep("This is not opentaps CRM", "Fail");
		}
	}

	
	public EditLead entereditname(String ECN){
		enterById("updateLeadForm_companyName", ECN);
		return this;
	}
	public ViewLead clicksubmit(){
		clickByClassName("smallSubmit");
		return new ViewLead(driver,test);
	}
}
