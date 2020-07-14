package com.q_ticket.testcases;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.q_ticket.base.Baseclass;
import com.q_ticket.pages.Admin_LandingPage;

public class Admin_LandingPageTest extends Baseclass{
	
	
	Admin_LandingPage obj;
	public Admin_LandingPageTest()
	{
		super();
	}

	@BeforeMethod
	public void Setup()
	{
		init();
		obj=new Admin_LandingPage();
		
	}
	
	//valid login details test script
	@Test(enabled=false)
	public void login()
	{
		
		obj.Login();	
		
	}
	
	//verify the landing page
	@Test(enabled=false)
	public void VerifyAdminlanding()
	{
		String text=obj.VerifyAdminHomepage();
		String pagetext = prop.getProperty("Landingpage");
		Assert.assertEquals(text, pagetext);
		
	}
	//verify the invalid login
	@Test(enabled=false)
	public void VerifyInvalidLogin()
	{
		String value=obj.VerifyinvalidLogin();
		String errormessage=prop.getProperty("errormsg");
		Assert.assertEquals(value,errormessage);
		
	}
	//logout functionality
	@Test
	public void Logout()
	{
		obj.logout();
		String text=obj.VerifyAdminHomepage();
		String pagetext = prop.getProperty("Landingpage");
		Assert.assertEquals(text, pagetext);
		
	}
	@AfterMethod
	public void tearDown(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus())
		{
			String methodname = result.getName();
			try {
				Takescreenshot(methodname);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		driver.quit();
	}
}
