package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class DuplicateLead extends OpentapsWrappers  {

	public DuplicateLead(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Duplicate Lead | opentaps CRM")){
			reportStep("This is not Duplicate Lead Page", "FAIL");
		}
	}
	
	
	public ViewLead clickCreateLead(){
		clickByName("submitButton");
		return new ViewLead(driver, test);
	}
		
	}
