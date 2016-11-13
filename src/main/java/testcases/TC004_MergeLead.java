package testcases;

import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;
import pages.findLeadWindow;

public class TC004_MergeLead extends OpentapsWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="Merge";
		testDescription="Merge the 2 leads";
		browserName="chrome";
		dataSheetName="TC_004";
		category="Sanity";
		authors="Natrayan M";
	}

	@Test(dataProvider="fetchData")
	public void mergeLead(String userName, String passWord, String fname1, String fname2) throws InterruptedException{

		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		//.verifyUserName(loginName)
		.clickCrmsfa()
		.clickLeadTab()
		.clickMergeLead()
		
		.clickFromLead() //click and switch to new window (findlead window)
		.sleep(5000)
		.enterFirstName(fname1)
		.clickFindLeads()
		.sleep(2000)
		.clickFirstFromLead() // click and switch to parent window (Merge Lead)
		
		.clickToLead() //click and switch to new window (findlead window)
		.sleep(5000)
		.enterFirstName(fname2)
		.clickFindLeads()
		.sleep(2000)
		.clickFirstToLead() //click and switch to parent window (Merge Lead)
		
		.clickMerge() //click and accept alert and land in mylead page
		
		
		.clickFindLeadPage() //Find lead page
		//Verify second lead
		.enterLeadId(findLeadWindow.lead2)
		.clickFindLead()
		.verifyLeadPass(findLeadWindow.lead2)
		//Verify first lead
		.enterLeadId(findLeadWindow.lead1)
		.clickFindLead()
		.verifyLeadFail(findLeadWindow.lead1);
		
				
	}

}
