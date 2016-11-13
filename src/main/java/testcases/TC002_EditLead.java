package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

public class TC002_EditLead extends OpentapsWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="Edit";
		testDescription="Edit the company name";
		browserName="chrome";
		dataSheetName="TC_002";
		category="Smoke";
		authors="Natrayan M";
	}

	@Test(dataProvider="fetchData",threadPoolSize=4)
	public void editLead(String userName, String passWord, String cname, String fname) throws InterruptedException{

		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		//.verifyUserName(loginName)
		.clickCrmsfa()
		.clickLeadTab()
		.clickFindLeadPage()
		.enterFirstName(fname)
		.clickFindLead()
		.sleep(2000)
		.clickFirstLead() //will reutrn to ViewLeadPage
		.clickEdit() // will return to EditLeadPage
		.enterCmpname(cname) // will remain in EditLeadPage
		.clickUpdate() // will return to ViewLeadPage
		.verifyCmpname(cname); // will remain in ViewLeadPage
		
		
		
		
	}

}
