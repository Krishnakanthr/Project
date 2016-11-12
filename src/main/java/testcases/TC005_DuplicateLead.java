package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

public class TC005_DuplicateLead extends OpentapsWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="DuplicateLead";
		testDescription="Duplicate a lead in opentaps";
		browserName="chrome";
		dataSheetName="DuplicateLead";
		category="Smoke";
		authors = "Ram";
	}

	@Test(dataProvider="fetchData")
	public void login(String userName, String passWord, String firstName, String lastName, String phoneNumber){

		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.ClickCRMSLink()
		.ClickLead()
		.clickFindLead()
		.clickPhone()
		.enterPhone(phoneNumber)
		.clickFindLead()
		.clickFirstLead()
		.clickDuplicateLead()
		.clickCreateLead()
		.verifyFirstName(firstName)
		.verifyLastName(lastName);

	}

}
