package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.OpentapsWrappers;

public class TC001_CreateLead extends OpentapsWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="Login";
		testDescription="Login To Opentaps";
		browserName="chrome";
		dataSheetName="TC_001";
		category="Smoke";
		authors="Natrayan M";
	}

	@Test(dataProvider="fetchData",threadPoolSize=4)
	public void createLead(String userName, String passWord, String cname, String fname, String lname, String phone, String email){

		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(passWord)
		.clickLogin()
		//.verifyUserName(loginName)
		.clickCrmsfa()
		.clickLeadTab()
		.clickCreateLead()
		.enterCmpName(cname)
		.enterFirstName(fname)
		.enterLastName(lname)
		.enterPhone(phone)
		.enterEmail(email)
		.clickSubmit()
		.verifyCmpname(cname);
		
		
		String text = getTextById("viewLead_companyName_sp");
		char[] leadId = new char[10];
		char[] textarr = text.toCharArray();
		System.out.println(textarr);
		int textlen = textarr.length;
		for (int i=0; i<textlen; i++)
			{
				if (textarr[i]=='(')
					for(int j=-1; (textarr[i]!=')');j++,i++)
							{
							if (textarr[i]=='(')
								continue;
							else
								{
								leadId[j]=textarr[i];
								}
							}
			}
		System.out.println(leadId);
	}

}
