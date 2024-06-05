package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePge;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

@Test(groups= {"sanity","master"})
public void VerifyLogin() {
	logger.info("**** Starting TC_002_LoginTest  ****");
	logger.debug("capturing application debug logs....");
	try
	{
	//Home page
	HomePge hp=new HomePge(driver);
	hp.ClickMyAccount();
	logger.info("clicked on myaccount link on the home page..");
	hp.ClickLogin(); //Login link under MyAccount
	logger.info("clicked on login link under myaccount..");
	
	//Login page
	LoginPage lp=new LoginPage(driver);
	logger.info("Entering valid email and password..");
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLogin(); //Login button
	logger.info("clicked on ligin button..");
	
	//My Account Page
	MyAccountPage macc=new MyAccountPage(driver);
			
	boolean targetPage=macc.isMyAccountPageExists();
	
	Assert.assertEquals(targetPage, true,"Login failed");
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info("**** Finished TC_002_LoginTest  ****");
}
}



