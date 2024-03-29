package testcases;

import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLeadPage;
import pages.LoginPage;
import wrappers.OpentapsWrappers;
import pages.findLeadWindow;

public class TC005_DuplicateLead extends OpentapsWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="Duplicate";
		testDescription="Duplicate the lead";
		browserName="chrome";
		dataSheetName="TC_005";
		category="Regression";
		authors="Natrayan M";
	}

	@Test(dataProvider="fetchData")
	public void duplicateLead(String userName, String passWord, String email, String fname) throws InterruptedException{

		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		//.verifyUserName(loginName)
		.clickCrmsfa()
		.clickLeadTab()
		
		.clickFindLeadPage()
		.clickEmail()
		.sleep(3000)
		.enterEmail(email)
		.clickFindLead()
		.sleep(2000)
		.clickFirstLead() //will reutrn to ViewLeadPage
		.clickDuplicate() // will return to DuplicatePage
		.clickCreateLead() //will return to ViewLeadPage
		.verifyFirstname(fname);
		
				
	}

}
