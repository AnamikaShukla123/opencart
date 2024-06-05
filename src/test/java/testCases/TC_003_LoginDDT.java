package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePge;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	@Test(dataProvider= "LoginData",dataProviderClass=DataProviders.class)
	public void VerifyDDt(String email, String password, String exp) {
		
	try {
		
	
	HomePge hp  = new HomePge(driver);
	
	hp.ClickMyAccount();
	hp.ClickLogin();
	
	LoginPage lp = new LoginPage(driver);
	lp.setEmail("email");
	lp.setPassword("password");
	lp.clickLogin();
	
	MyAccountPage macc = new MyAccountPage(driver);
	boolean  targetpage = macc.isMyAccountPageExists();
	
	if (exp.equalsIgnoreCase("valid")) {
		if(targetpage==true) {
			macc.clickLogout();
		}
			Assert.assertTrue(true);
		}
		else {
			Assert.assertFalse(false);
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(targetpage == true) {
				macc.clickLogout();
			Assert.assertTrue(false);
		}
			else {
				Assert.assertTrue(true);				
			}
		}
	}
		
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
	



	
		
			
	
	
	


	}
	


