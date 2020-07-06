package com.q_ticket.testcases;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.q_ticket.base.Baseclass;
import com.q_ticket.pages.Admin_LandingPage;
import com.q_ticket.framework.utility.ExtentTestManager;

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
	
	@Test
	public void login()
	{
		ExtentTestManager.startTest("login", "Test");
		obj.Login();	
		ExtentTestManager.getTest();
		ExtentTestManager.endTest();
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
