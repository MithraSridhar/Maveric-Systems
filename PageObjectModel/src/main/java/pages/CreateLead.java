package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class CreateLead extends LeafTapsWrappers{
	
	public CreateLead(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("Create Lead | opentaps CRM")){
			reportStep("This is not Home Page", "Fail");
		}
	}
	public CreateLead entercompanyname(String CN){
		driver.findElementById(prop.getProperty("CreateLead.Company.Id")).sendKeys("Verizon");
		return this;
	}
	public CreateLead enterfisrtname(String FN){
		enterById("createLeadForm_firstName", FN); 
		return this;
	}
	public CreateLead enterlastname(String LN){
		enterById("createLeadForm_lastName", LN);
		return this;
	}
	public ViewLead clickcreatelead(){
		clickByName("submitButton");
		return new ViewLead(driver,test);
	}
	}
	
	