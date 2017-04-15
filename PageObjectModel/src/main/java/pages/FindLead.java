package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class FindLead extends LeafTapsWrappers {
	String LeadID;
	public FindLead(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		if (!verifyTitle("Find Leads | opentaps CRM")) {
			reportStep("This is not Find Lead Page", "Fail");
		}
	}

	public FindLead enterfirstname(String EFN) {
		enterByXpath("(//input[@name='firstName'])[3]",EFN);
		return this;
	}
	public FindLead clickfindlead(){
		clickByXpath("(//button[@class='x-btn-text'])[7]");
		return this;
	}
	public FindLead enterleadid(String src){
		enterByName("id", src);
		return this;
	}
	public FindLead clickfindleadbytext(){
		clickByXpath("//button[text()='Find Leads']");
		return this;
	}
	public FindLead findleadbyphoneno() {
		clickByXpath("//span[contains(text(),'Phone')]");
		return this;
	}
	public FindLead findleadbyemail() {
		clickByXpath("//span[contains(text(),'Email')]");
		return this;
	}
	public FindLead enterbyemail(String mailid) {
		enterByXpath("(//div[@class='x-form-element']//input)[26]", mailid);
		return this;
	}
	public FindLead enterphoneno(String phoneno) {
		enterByXpath("(//div[@class='x-plain-body x-plain-body-noheader x-plain-body-noborder']//input)[13]",phoneno);
		return this;
	}
	public ViewLead clicklead(String LeadID){
		clickByLink(LeadID);
		return new ViewLead(driver,test);
	}
	public ViewLead clickleadbyxpath(){
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a");
					
		return new ViewLead(driver,test);
	}
	public ViewLead clicksecondleadbyxpath(){
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]");
					
		return new ViewLead(driver,test);
	}
	public String getleadidbyxpath(){
		 getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a");
					
		return toString();
	}
	public FindLead findbyleadxpath(){
		
        enterByXpath("(//div[@class='x-form-element']/input)[13]","LeadID");
		
		return this;
	}
	
	public FindLead verifynoleadtext(){
		verifyTextByXpath("//div[contains(text(),'No records to display')]", "No records to display");		
		return this;
	}
	
}
