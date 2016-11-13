package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class FindAccountsWindow extends OpentapsWrappers  {

	public static String account;
	
	public FindAccountsWindow(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Find Accounts")){
			reportStep("This is not Find Account window Page", "FAIL");
		}
	}
	
		
	public ConvertLeadPage clickFirstAccount() throws InterruptedException{
		account = findByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]").getText();
		//clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]");
		clickByWoSnap("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]", 'x');
		switchToParentWindow();
		Thread.sleep(2000);
		return new ConvertLeadPage(driver,test); 
	}
}
