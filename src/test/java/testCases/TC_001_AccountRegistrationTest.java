package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePge;
import testBase.BaseClass;





public class TC_001_AccountRegistrationTest extends BaseClass {
	
	
	
		
	
	@Test(groups= {"regression","master"})
	public void verify_account_registration() throws InterruptedException {
		logger.info( "**** starting TC_001_AccountRegistrationTest  *****");
		logger.info("****application logs Started *****");
		try {
		HomePge hp = new HomePge (driver);
		
		hp.ClickMyAccount();
		logger.info("**** Clicking on My Account*****");
		hp.ClickRegister();
		logger.info("**** Clicking on Register*****");
		logger.info("Entering customer details.. ");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.SetFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
	

		String password = randomAlphaNumeric();
		
	
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		Thread.sleep(1000);
	
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("clicked on continue..");
		

		String confmsg=regpage.getConfirmationMsg();
		logger.info("Validating expected message..");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		
	}
		catch(Exception e){
			logger.debug("debug logs");
			logger.error("Test fail");
			Assert.fail();
			
		}
			
	}
}

	





