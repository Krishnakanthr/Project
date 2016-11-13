package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class FindLeadPage extends OpentapsWrappers  {

	public static String lead;
	
	public FindLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Find Leads | opentaps CRM")){
			reportStep("This is not Find Lead Page", "FAIL");
		}
	}
	
	
	public FindLeadPage enterFirstName(String fname){
		enterByXpath("//div[@class='x-form-item x-tab-item']/div[@class='x-form-element']/input[@name='firstName']", fname);
		return this; 
	}
	
	public FindLeadPage enterLeadId(String id){
		enterByXpath("//div[@class='x-form-element']/following::input[@name='id']", id);
		return this; 
	}
	
	public FindLeadPage clickPhone(){
		clickByXpath("//span[@class='x-tab-strip-inner']/span[contains(text(),'Phone')]");
		return this; 
		}
	
	public FindLeadPage enterPhone(String phone){
		enterByXpath("//div[@class='x-plain-body x-plain-body-noheader x-plain-body-noborder']/input[@name='phoneNumber']", phone);
		return this; 
		}
	
	public FindLeadPage clickEmail(){
		clickByXpath("//span[@class='x-tab-strip-inner']/span[contains(text(),'Email')]");
		return this; 
		}
	
	public FindLeadPage enterEmail(String email){
		enterByXpath("//div[@class='x-form-element']/input[@name='emailAddress']", email);
		return this; 
		}
	
	public FindLeadPage clickFindLead() throws InterruptedException{
	clickByXpath("//button[contains(text(),'Find Leads')]");
	Thread.sleep(3000);
	return this; 
	}
	
	
	public ViewLeadPage clickFirstLead(){
		lead=findByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		return new ViewLeadPage(driver,test); 
		}
	
	public FindLeadPage verifyLeadPass(String lead2){
		verifyTextContainsByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a", lead2);
		return this;
	}
	
	public FindLeadPage verifyLeadFail(String lead1){
		verifyTextContainsByClassname("x-paging-info", "No records to display");
		return this;
	}
	
	public FindLeadPage sleep(int ms) throws InterruptedException{
		Thread.sleep(ms);
		return this; 
		}
	
}
