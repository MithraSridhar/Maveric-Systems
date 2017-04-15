package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class HomePage extends LeafTapsWrappers  {

	public HomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Opentaps Open Source ERP + CRM")){
			reportStep("This is not Home Page", "Fail");
		}
	}
	
	public LoginPage clickLogOut(){
		clickByClassName("decorativeSubmit");
		return new LoginPage(driver, test); 
	}	
	
	public MyHome clickcrmsfa(){
		clickByLink("CRM/SFA");
		return new MyHome(driver, test); 
	}
}
