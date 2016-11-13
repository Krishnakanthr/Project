package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class MergeLeadPage extends OpentapsWrappers  {

	public MergeLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Merge Leads | opentaps CRM")){
			reportStep("This is not merge lead Page", "FAIL");
		}
	}
	
	
	public findLeadWindow clickFromLead(){
		clickByXpath("(//input[@id='partyIdFrom']/following::img[@alt='Lookup'])[1]");
		switchToLastWindow();
		return new findLeadWindow(driver,test); 
		}
	
	public findLeadWindow clickToLead(){
		System.out.println("im in tolead");
		clickByXpath("(//input[@id='partyIdFrom']/following::img[@alt='Lookup'])[2]");
		switchToLastWindow();
		return new findLeadWindow(driver,test); 
		}
	
	public ViewLeadPage clickMerge() throws InterruptedException{
		clickByWoSnap("Merge", 'l');
		Thread.sleep(1000);
		acceptAlert();
		return new ViewLeadPage(driver,test); 
		}
		
	public MergeLeadPage sleep(int ms) throws InterruptedException{
		Thread.sleep(ms);
		return this; 
		}
	
}
