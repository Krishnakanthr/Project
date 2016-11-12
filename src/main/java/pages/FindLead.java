package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class FindLead extends OpentapsWrappers  {

	public FindLead(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Find Leads | opentaps CRM")){
			reportStep("This is not Find Leads Page", "FAIL");
		}
	}


	public FindLead enterFirstName(String FirstName){

		enterByXpath("//div[@id='findLeads']//input[@name='firstName']", FirstName);
		return this;
	}


	public FindLead clickFindLead(){

		clickByXpath("//div[@class='x-panel-footer x-panel-footer-noborder']//button");
		return this;
	}	

	public FindLead clickPhone(){

		clickByXpath("//div[@id='findLeads']//span[contains(text(),'Phone')]");
		return this;
	}
	
	public FindLead enterPhone(String PhoneNumber){
		enterByName("phoneNumber", PhoneNumber);
		return this;
	}
	
	public FindLead clickEmail(){

		clickByXpath("//div[@id='findLeads']//span[contains(text(),'Email')]");
		return this;
	}
	
	public FindLead enterEmail(String emailID){
		enterByName("emailAddress", emailID);
		return this;
	}
	
	public FindLead verifyLeadFail(){
		verifyTextByXpath("//div[@class='x-paging-info']", "No records to display");
		return this;
	}
	
	public ViewLead clickFirstLead(){
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a");
		return new ViewLead(driver, test);
	}
	
	public FindLead verifyLeadPass(String FirstName){
		verifyTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a", FirstName);
		return this;
	}
	
	public FindLead sleep() throws InterruptedException{
		Thread.sleep(30);
		return this;
	}


}


