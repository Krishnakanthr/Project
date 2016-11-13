package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class DuplicatePage extends OpentapsWrappers  {

	public DuplicatePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Duplicate Lead | opentaps CRM")){
			reportStep("This is not Duplicate Lead Page", "FAIL");
		}
	}
	
		
	public ViewLeadPage clickCreateLead(){
		clickByXpath("//input[@value='Create Lead']");
		return new ViewLeadPage(driver,test); 
	}
}
