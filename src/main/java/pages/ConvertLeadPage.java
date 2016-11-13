package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class ConvertLeadPage extends OpentapsWrappers  {

	public ConvertLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("opentaps CRM")){
			reportStep("This is not Convert Lead Page", "FAIL");
		}
	}
	
		
	public FindAccountsWindow clickAccount(){
		clickByXpath("//a/img[@alt='Lookup']");
		switchToLastWindow();
		return new FindAccountsWindow(driver,test); 
	}
	
	public ViewContactPage clickConvert(){
		clickByXpath("//td/input[@class='smallSubmit' and @name='submitButton' and @value='Convert Lead']");
		return new ViewContactPage(driver,test); 
	}
}
