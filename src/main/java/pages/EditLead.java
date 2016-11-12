package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class EditLead extends OpentapsWrappers  {

	
	
	public EditLead(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("opentaps CRM")){
			reportStep("This is not Home Page", "FAIL");
	}
	}


  public EditLead enterupdatecompanyname(String Companyname){
	enterById("updateLeadForm_companyName", Companyname);
	return this;
  }

  public ViewLead clickUpdateLeadButton(){
	  clickByName("submitButton");
	  return new ViewLead(driver, test);
  }
  
  public EditLead selectmarketcampaign(String Mcampaign){
	  selectIndexById("addMarketingCampaignForm_marketingCampaignId", Mcampaign);
	  return this;
  }
  public EditLead clickmarketcampaign(){
	  clickByXpath("(//input[@name='submitButton'])[3]");
	  return this;
  }
  
  public EditLead selectSource(String sourcevalue){
	  selectIndexById("addDataSourceForm_dataSourceId", sourcevalue);
	  return this;
  }
  public EditLead clickSource(){
	  clickByXpath("(//input[@name='submitButton'])[2]");
	  return this;
  }
  
  public FindAccount clickAccount() throws InterruptedException{
	  clickByXpath("//img[@alt='Lookup']");
	  switchToLastWindow();
	  Thread.sleep(4000);
	  return new FindAccount(driver, test);
  }
  
  public ViewContact clickConverLead(){
	  clickByXpath("//td//input[@value='Convert Lead']");
	  return new ViewContact(driver, test);
  }
}
