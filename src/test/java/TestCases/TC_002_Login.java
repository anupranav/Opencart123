package TestCases;

import org.junit.Assert;

import org.testng.annotations.Test;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestBase.BaseClass;

public class TC_002_Login extends BaseClass{
	
	@Test(groups={"sanity","master"})
	public void test_Login()
	{
		logger.info("starting TC_002Login");
		
		try
		{
			driver.get(rd.getString("appURL"));
			logger.info("Home Page Displayed");
			
			driver.manage().window().maximize();
			
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account");
			hp.clickLogin();
			logger.info("Clicked on Login");
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail(rd.getString("email"));
			logger.info("Provided Email");
			
			lp.setPassword(rd.getString("password"));
			logger.info("provided password");
			
			lp.clickLogin();
			logger.info("Clicked on Login");
		
		    boolean targetpage=lp.isMyAccountPageExists();
		    
		    if(targetpage)
		    {
		    	logger.info("Login Success");
		    	Assert.assertTrue(true);
		    }
		    else
		    {
		    	logger.error("Login Failed");
		    	captureScreen(driver, "test_Login");//capturing screenshot
		    	Assert.assertTrue(false);
		    }
		}
		catch(Exception e)
		{
			logger.fatal("Login failed");
			Assert.fail();
		}
		
		logger.info("Finished TC_002_Login");
	}
		    
		
}	

	

