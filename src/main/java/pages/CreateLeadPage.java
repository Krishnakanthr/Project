package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class CreateLeadPage extends OpentapsWrappers  {

	public CreateLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Create Lead | opentaps CRM")){
			reportStep("This is not Create Lead Page", "FAIL");
		}
	}
	
	
	public CreateLeadPage enterCmpName(String cname){
	enterById("createLeadForm_companyName", cname);
	return this;
	}
	
	public CreateLeadPage enterFirstName(String fname){
	enterById("createLeadForm_firstName", fname);
	return this;
	}
	
	public CreateLeadPage enterLastName(String lname){
	enterById("createLeadForm_lastName", lname);
	return this;
	}
	
	public CreateLeadPage enterPhone(String phone){
		enterById("createLeadForm_primaryPhoneNumber", phone);
		return this;
		}
	
	public CreateLeadPage enterEmail(String email){
		enterByXpath("//*[@id='createLeadForm_primaryEmail']", email);
		return this;
		}
	
	public ViewLeadPage clickSubmit(){
	clickByName("submitButton");
	return new ViewLeadPage(driver,test) ;
	}
}
