package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class MyHome extends OpentapsWrappers  {
	
	public MyHome(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("My Home | opentaps CRM")){
			reportStep("This is not Home Page", "FAIL");
		}
	}



	public MyLead ClickLead(){
		clickByLink("Leads");
		return new MyLead(driver,test);
	}
	




	
	
}
