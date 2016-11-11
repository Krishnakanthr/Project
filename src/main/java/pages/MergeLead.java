package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class MergeLead extends OpentapsWrappers  {

	
	
	public MergeLead(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Merge Leads | opentaps CRM")){
			reportStep("This is not Home Page", "FAIL");
	}
	}

  public MergeFindLead clickFromLead() throws InterruptedException{
	  clickByXpath("(//img[@alt='Lookup'])[1]");
	  switchToLastWindow();
	   return new MergeFindLead(driver, test);
  }
	
 

  
  public MergeFindLead clickToLead() {
	  clickByXpath("(//img[@alt='Lookup'])[2]");
	  switchToLastWindow();
	   return new MergeFindLead(driver, test);
  }
	
 
  

  public ViewLead clickMergerLead() throws InterruptedException{
	  clickByClassName("buttonDangerous");
	  Thread.sleep(5000);
	  acceptAlertwithoutsnapshot();
	  return new ViewLead(driver, test);
  }

}
