package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {


	@Test(dataProvider = "LoginData" , dataProviderClass = DataProviders.class,groups = "Datadriven") // getting dataprovider from different class
	public void verify_LoginDDT(String email, String pwd, String exp) {
		
		logger.info("***starting TC003_LoginDDT***..." );

		try {
		// home page
		HomePage hp = new HomePage(driver);

		hp.clickMyAccount();
		hp.clickLogin();      


		//login page
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(email);
		lp.setPassword(pwd);
		lp.clickLoginto();

		// myaccount
		MyAccountPage mp = new MyAccountPage(driver);
		boolean AccountPage=mp.myAccountExist();
		
		// Data is Valid--> loginsuccess---> testpass--->logout
		//                   login un-successful--->test fail
		// Data is invalid---> login success---> test fail--->logout
		//                     login un-success--->test fail
		
		if(exp.equalsIgnoreCase("valid")) {
			
			if(AccountPage==true) {
				mp.clickLogout();
				Assert.assertTrue(true);
				
			} else {
				
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid")) {
			
			 if(AccountPage==true) {
				 
				 mp.clickLogout();
				 Assert.assertTrue(false);
			 } else {
				 
				 Assert.assertTrue(true);
			 }
		}
		
		} catch(Exception e) {
			
			Assert.fail();
		}
		logger.info("test completed TC003_LoginDDT ***----");
	}

}
