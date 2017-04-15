package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class MyHome extends LeafTapsWrappers{
	
	public MyHome(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		if(!verifyTitle("My Home | opentaps CRM")){
			reportStep("This is not My Home Page", "Fail");
		}
	}
	public MyLeads clickleads(){
		clickByXpath("//a[@href='/crmsfa/control/leadsMain']");
		return new MyLeads(driver, test); 
		
	}

}
