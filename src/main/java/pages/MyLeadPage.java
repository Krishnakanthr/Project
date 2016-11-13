package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class MyLeadPage extends OpentapsWrappers  {

	public MyLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("My Leads | opentaps CRM")){
			reportStep("This is not Mylead Page", "FAIL");
		}
	}
	
	public FindLeadPage clickFindLeadPage(){
		clickByLink("Find Leads");
		return new FindLeadPage (driver,test);
	}
	
	public CreateLeadPage clickCreateLead(){
		clickByLink("Create Lead");
		return new CreateLeadPage (driver,test); 
	}
	
	public MergeLeadPage clickMergeLead(){
		clickByLink("Merge Leads");
		return new MergeLeadPage (driver,test); 
	}
}
