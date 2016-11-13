package testcases;

import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLeadPage;
import pages.LoginPage;
import wrappers.OpentapsWrappers;
import pages.findLeadWindow;

public class TC003_DeleteLead extends OpentapsWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="Delete";
		testDescription="Delete the lead";
		browserName="chrome";
		dataSheetName="TC_003";
		category="Sanity";
		authors="Natrayan M";
	}

	@Test(dataProvider="fetchData")
	public void deleteLead(String userName, String passWord, String phone) throws InterruptedException{

		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		//.verifyUserName(loginName)
		.clickCrmsfa()
		.clickLeadTab()
		
		.clickFindLeadPage()
		.clickPhone()
		.enterPhone(phone)
		.clickFindLead()
		.sleep(2000)
		.clickFirstLead() //will reutrn to ViewLeadPage
		.clickDelete() // will return to MyLeadPage
		
		.clickFindLeadPage() //Find lead page
		//Verify deleted lead
		.enterLeadId(FindLeadPage.lead)
		.clickFindLead()
		.verifyLeadFail(FindLeadPage.lead);
		
				
	}

}
