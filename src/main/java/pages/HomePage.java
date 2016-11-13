package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class HomePage extends OpentapsWrappers  {

	public HomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Opentaps Open Source ERP + CRM")){
			reportStep("This is not Home Page", "FAIL");
		}
	}
	
	public HomePage verifyUserName(String uname){
		return this;
	}
	
		
	public MyHomePage clickCrmsfa(){
		clickByLink("CRM/SFA");
		return new MyHomePage(driver,test); 
	}
}
