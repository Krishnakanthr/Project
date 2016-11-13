package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class ViewLeadPage extends OpentapsWrappers  {

	public ViewLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("View Lead | opentaps CRM")){
			reportStep("This is not ViewLead Page", "FAIL");
		}
	}
	
	public ViewLeadPage verifyCmpname(String cname){
		verifyTextContainsById("viewLead_companyName_sp", cname);
		return this;
	}
	
	public ViewLeadPage verifyFirstname(String fname){
		verifyTextById("viewLead_firstName_sp", fname);
		return this;
	}
	
	public EditLeadPage clickEdit(){
		clickByXpath("//div[@class='frameSectionExtra']/a[contains(text(),'Edit')]");
		return new EditLeadPage(driver,test);
	}
	
	public MyLeadPage clickDelete(){
		clickByXpath("//div[@class='frameSectionExtra']/a[contains(text(),'Delete')]");
		return new MyLeadPage(driver,test);
	}
	
	public DuplicatePage clickDuplicate(){
		clickByXpath("//div[@class='frameSectionExtra']/a[contains(text(),'Duplicate Lead')]");
		return new DuplicatePage(driver,test);
	}
	
	public ViewLeadPage clickQualify(){
		clickByXpath("//div[@class='frameSectionExtra']/a[contains(text(),'Qualify Lead')]");
		return new ViewLeadPage(driver,test);
	}
	
	public ConvertLeadPage clickConvertLead(){
		clickByXpath("//div[@class='frameSectionExtra']/a[contains(text(),'Convert Lead')]");
		return new ConvertLeadPage(driver,test);
	}
	
	public FindLeadPage clickFindLeadPage(){
		clickByLink("Find Leads");
		return new FindLeadPage (driver,test);
	}
}
