package com.q_ticket.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.q_ticket.base.Baseclass;

public class Admin_LandingPage extends Baseclass {
	@FindBy(id = "Username")
	WebElement Username_txtbox;
	@FindBy(id = "Password")
	WebElement Password_txtbox;
	@FindBy(xpath = "//input[@value='Sign n']")
	WebElement Signinbtn;

	public Admin_LandingPage() {
		PageFactory.initElements(driver, this);
	}

	public void Login() {
		Username_txtbox.sendKeys(prop.getProperty("Username"));
		Password_txtbox.sendKeys(prop.getProperty("Password"));
		Signinbtn.click();

	}

}
