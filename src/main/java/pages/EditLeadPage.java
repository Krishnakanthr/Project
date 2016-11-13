package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class EditLeadPage extends OpentapsWrappers  {

	public EditLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("opentaps CRM")){
			reportStep("This is not Edit Lead Page", "FAIL");
		}
	}
	
	public EditLeadPage enterCmpname(String cname){
		enterById("updateLeadForm_companyName", cname);
		return this;
	}
	
	public ViewLeadPage clickUpdate(){
		clickByXpath("(//td[@class='label']/following-sibling::td/input[@name='submitButton'])[1]");
		return new ViewLeadPage(driver,test);
	}
	
}
