package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

public class TC005_MergeLead extends OpentapsWrappers{
	
	@BeforeClass
	public void setData() {
		testCaseName="MergeLead";
		testDescription="Merge the Two Lead Id's";
		browserName="chrome";
		dataSheetName="MergeLead";
		authors="Dinesh";
		category="Sanity";
	}

	@Test(dataProvider="fetchData")
	public void login(String userName, String passWord,String FromLeadid,String ToLeadid,String Leadid,String Text) throws InterruptedException{

		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		.ClickCRMSLink()
		.ClickLead()
		.clickMergeLead()
		.clickFromLead()
		.enterFromLeadid(FromLeadid)
		.clickMergeButton()
		.clickFirstGridvaluewithoutsnap()
	    .clickToLead()
	    .enterToLeadId(ToLeadid)
	    .clickMergeButton()
	    .clickFirstGridvaluewithoutsnap()
	    .clickMergerLead()
	    .clickviewFindLead()
	    .enterFindLeadId(Leadid)
	    .clickFindLeadbutton()
	    .verifyMergeid(Text);
	    
	     
		
	    
	    
		
		
		
		
	

	}

}
