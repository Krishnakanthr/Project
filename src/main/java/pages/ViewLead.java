package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.OpentapsWrappers;

public class ViewLead extends OpentapsWrappers  {

	
	
	public ViewLead(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("View Lead | opentaps CRM")){
			reportStep("This is not Home Page", "FAIL");
	}
	}
	
	public ViewLead verifyFirstName(String firstName){
		verifyTextById("viewLead_firstName_sp", firstName);
		return this;
	}
	
	public ViewLead verifyLastName(String lastName){
		verifyTextById("viewLead_lastName_sp", lastName);
		return this;
	}
	
	
	public ViewLead verifyCompanyName(String companyName){
		String name=getTextById("viewLead_companyName_sp");
		String[] parts = name.split(" ");
		String companynameTrim = parts[0]; // 004
		
		if (!companyName.equals(companynameTrim)) {
			reportStep("This is not Company Name", "FAIL");
		}
		
		reportStep("This is Company Name "+companynameTrim, "PASS");
		return this;
	}

   public EditLead clickEditButton(){
	   clickByXpath("(//div[@class='frameSectionExtra'])[2]/a[3]");
	   return new EditLead(driver,test);
   }
	
   public MyLead clickDeleteButton(){
	   clickByXpath("//div[@class='frameSectionExtra']/a[4]");
	   return new MyLead(driver, test);
   }

   

  public FindLead clickviewFindLead() {
	clickByLink("Find Leads");
	return new FindLead(driver, test);
  }

  public DuplicateLead clickDuplicateLead(){
	  clickByXpath("(//a[@class='subMenuButton'])[1]");
	  return new DuplicateLead(driver, test);
  }
  public ViewLead clickQualifyLead(){
	  clickByLink("Qualify Lead");
	  return this;
  }
  
  public EditLead clickConvertLead(){
	  clickByLink("Convert Lead");
	  return new EditLead(driver, test);
  }
  
  }
  
