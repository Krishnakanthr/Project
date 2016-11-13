package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class findLeadWindow extends OpentapsWrappers  {

	public static String lead1, lead2;

	public findLeadWindow(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Find Leads")){
			reportStep("This is not find lead window Page", "FAIL");
		}
	}
		
	public findLeadWindow enterFirstName(String fname){
		enterByXpath("//div[@class='x-form-item x-tab-item']/div[@class='x-form-element']/input[@name='firstName']", fname);
		return this; 
		}
	
	public findLeadWindow clickFindLeads(){
		clickByXpath("//button[contains(text(),'Find Leads')]");
		return this; 
		}
	
	public MergeLeadPage clickFirstFromLead() throws InterruptedException{
		lead1 = findByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
		//this.lead1 = lead1;
		//clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		clickByWoSnap("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a", 'x');
		Thread.sleep(2000);
		switchToParentWindow();
		Thread.sleep(2000);
		return new MergeLeadPage(driver,test); 
		}
	
	public MergeLeadPage clickFirstToLead() throws InterruptedException{
		lead2 = findByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").getText();
		//this.lead2 = lead2;
		//clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		clickByWoSnap("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a", 'x');
		Thread.sleep(2000);
		switchToParentWindow();
		Thread.sleep(2000);
		return new MergeLeadPage(driver,test); 
		}
	
	
	public findLeadWindow sleep(int ms) throws InterruptedException{
		Thread.sleep(ms);
		return this; 
		}
	
}
