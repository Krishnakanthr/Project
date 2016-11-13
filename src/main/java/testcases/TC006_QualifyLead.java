package testcases;

import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLeadPage;
import pages.LoginPage;
import wrappers.OpentapsWrappers;
import pages.findLeadWindow;

public class TC006_QualifyLead extends OpentapsWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="Qualify";
		testDescription="Qualify the lead";
		browserName="chrome";
		dataSheetName="TC_006";
		category="Regression";
		authors="Natrayan M";
	}

	@Test(dataProvider="fetchData")
	public void qualifyLead(String userName, String passWord, String fname) throws InterruptedException{

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
		.clickQualify() // will return to ViewLeadPage
		.clickConvertLead() //will return to ConvertLeadPage
		.clickAccount() //will open and switch to find account page
		.clickFirstAccount() //will return to ConvertLead Page
		.clickConvert() //will return to View conctact page
		.verifyAccount();
				
	}

}
