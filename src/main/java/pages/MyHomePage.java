package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class MyHomePage extends OpentapsWrappers  {

	public MyHomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("My Home | opentaps CRM")){
			reportStep("This is not MyHome Page", "FAIL");
		}
	}
	
		
	public MyLeadPage clickLeadTab(){
		clickByLink("Leads");
		return new MyLeadPage(driver,test); 
	}
}
