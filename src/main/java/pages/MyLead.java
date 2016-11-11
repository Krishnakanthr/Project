package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class MyLead extends OpentapsWrappers  {
	
	public MyLead(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("My Leads | opentaps CRM")){
			reportStep("This is not Login Page", "FAIL");
		}
	}



	public CreateLead ClickCreateLead(){
		clickByLink("Create Lead");
		return new CreateLead(driver,test);
	}
	
	
	
	public FindLead clickFindLead(){
		clickByLink("Find Leads");
		return new FindLead(driver,test);
	}
	
	
	public MergeLead clickMergeLead(){
		clickByLink("Merge Leads");
		return new MergeLead(driver,test);
	}



	


	
	
	
	
	
	
	

}
