package com.q_ticket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.q_ticket.base.Baseclass;

public class Admin_LandingPage extends Baseclass {
	@FindBy(id = "Username")
	WebElement Username_txtbox;
	@FindBy(id = "Password")
	WebElement Password_txtbox;
	@FindBy(xpath = "//input[@value='Sign in']")
	WebElement Signinbtn;

	@FindBy(xpath="//h2[@class='text-center']")
	WebElement landingpagetext;
	public static String textvalue;
	public Admin_LandingPage() {
		PageFactory.initElements(driver, this);
	}

	public void Login() {
		Username_txtbox.sendKeys(prop.getProperty("Username"));
		Password_txtbox.sendKeys(prop.getProperty("Password"));
		Signinbtn.click();

	}
	public String VerifyAdminHomepage()
	{
		return textvalue=landingpagetext.getText();
	 	
	}
	
	public String VerifyinvalidLogin()
	{
		Username_txtbox.sendKeys(prop.getProperty("IUsername"));
		Password_txtbox.sendKeys(prop.getProperty("IPassword"));
		Signinbtn.click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Invalid Account']")));
		
		return textvalue=driver.findElement(By.xpath("//h2[text()='Invalid Account']")).getText();
		
		
	}

}
