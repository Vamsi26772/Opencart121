package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups = { "Regression","Master"})
	public void verify_Account_Registration() {
		
		logger.info("***** starting TC001_AccountRegistrationTest ****");
		
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("clicked on myaccount link");
		hp.clickRegister();
		logger.info("clicked on register link");
		
		
		
		AccountRegistrationPage ac = new AccountRegistrationPage(driver);
		
		logger.info("providing customer details");
		ac.setFirstName("vamsi");
		ac.setLastName("chendeti");
		ac.setEmail(randomString()+"@gmail.com");
		ac.setPhoneNumber("6735267210");
		
		ac.setPassword("xyz8769");
		ac.setConfirmPassword("xyz8769");
		
		ac.setPolicy();
		ac.clickContinue();
		
		logger.info("validating confirmation details");
		String msg=ac.getConfirmationMsg();
		Assert.assertEquals(msg, "Your Account Has Been Created!");
		
		} catch (Exception e) {
			
			logger.error("test failed");
		
			Assert.fail();
		}
		
		logger.info("test finished ****TC001_AccountRegistrationTest**** ");
		
	}
	
	
	
	// rough ---> vams chand adc43@gmail.com, 6789909980 xyz456

}
