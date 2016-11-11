package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class LoginPage extends OpentapsWrappers  {

	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Opentaps Open Source ERP + CRM")){
			reportStep("This is not Login Page", "FAIL");
		}
	}
	
	public LoginPage enterUserName(String userName){
		enterById("username", userName);
		return this;
	}
	
	public LoginPage enterPassword(String password){
		enterById("password", password);
		return this;
		
	}
	
	public HomePage clickLogin(){
		clickByClassName("decorativeSubmit");
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
