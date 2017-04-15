package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class LoginPage extends LeafTapsWrappers  {

	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Opentaps Open Source ERP + CRM")){
			reportStep("This is not Login Page", "Fail");
		}
	}
	
	public LoginPage enterUserName(){
		enterById("username", username);
		return this;
	}
	
	public LoginPage enterPassword(){
		//enterById("password", password);
		enterByName("PASSWORD", password);
		return this;
		
	}
	
	public HomePage clickLogin(){
		WebElement element = driver.findElementByClassName("decorativeSubmit");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				//clickByClassName("decorativeSubmit");
		
		return new HomePage(driver, test);
	}
	
	public LoginPage clickLoginForFailure(){
		clickByClassName("decorativeSubmit");
		return this;
	}
	
	public LoginPage verifyErrorMsg(String text){
		verifyTextContainsById("errorDiv", text);
		return this;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
