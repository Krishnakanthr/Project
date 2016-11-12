package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class CreateLead extends OpentapsWrappers  {

	
	
	public CreateLead(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Create Lead | opentaps CRM")){
			reportStep("This is not Home Page", "FAIL");
	}
	}


	public CreateLead enterbycompanyname(String companyname){
		enterById("createLeadForm_companyName",companyname);
		return this;
	}

	public CreateLead enterbyfirstname(String firstname){

       enterByXpath("//input[@id='createLeadForm_firstName']",firstname);
		return this;
	}
	
	public CreateLead enterbylastname(String lastname){

	       enterByXpath("//input[@id='createLeadForm_lastName']",lastname);
			return this;
		}
	public ViewLead clickcreatesubmit(){
           clickByName("submitButton");
           return new ViewLead(driver,test);
	       
		}


}
