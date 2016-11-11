package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class MergeFindLead extends OpentapsWrappers  {

	public MergeFindLead(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Find Leads")){
			reportStep("This is not Home Page", "FAIL");
	}
	}
	
	 public MergeFindLead verifyMergeid(String Text)
	   {
		   verifyTextByXpath("//div[@class='x-paging-info'][1]", Text);
		   return this;
	   }
	 public MergeFindLead enterFromLeadid(String FromLeadid)
	   {
	 	  enterByName("id",FromLeadid);
	 	  return this;
	   }
	   
	   public MergeFindLead clickMergeButton() throws InterruptedException
	   {
	 	  clickByXpath("(//button[@class='x-btn-text'])[1]");
	 	  Thread.sleep(4000);
	 	  return this;
	   }
	   
	 
	   public MergeLead clickFirstGridvaluewithoutsnap() throws InterruptedException
	   {
	 	 
		   clickByXpathwithoutsnapshot("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
	 	  Thread.sleep(4000);
	 	  switchToParentWindow();
	 	  return new MergeLead(driver,test);
	   }
	   
	   public MergeFindLead enterToLeadId(String ToLeadid)
	   {
	 	  enterByName("id",ToLeadid);
	 	   return this;
	   }
}

