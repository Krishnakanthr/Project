package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class ViewContactPage extends OpentapsWrappers  {

	public ViewContactPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("View Contact | opentaps CRM")){
			reportStep("This is not view contact Page", "FAIL");
		}
	}
	
		
	public ViewContactPage verifyAccount(){
		verifyTextContainsByXpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-friendlyPartyName ']/div[@class='x-grid3-cell-inner x-grid3-col-friendlyPartyName']/a[@class='linktext']", FindAccountsWindow.account);
		return this; 
	}
}
