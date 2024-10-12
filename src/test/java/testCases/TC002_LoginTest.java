package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass  {
	
	@Test(groups = {"Sanity","Master"})
	public void verifyLoginTest() {
		
		logger.info("***** test started TC002_LoginTest*****...");
		
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();      // methods from homepage
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLoginto();
		
		MyAccountPage mp = new MyAccountPage(driver);
		boolean AccountPage=mp.myAccountExist();
		
		Assert.assertEquals(AccountPage, true);
		
		logger.info("****test TC002_LoginTest finished *****");
		
		} catch(Exception e) {
			System.out.println("TC002_LoginTest ---->failed");
		}
		
	}

}
