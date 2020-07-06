package com.q_ticket.framework.interfaces;

import com.q_ticket.configuration.browser.BrowserType;

public interface IconfigReader {
	public String getUserName();

	public String getPassword();

	public String getWebsite();

	public int getPageLoadTimeOut();

	public int getImplicitWait();

	public int getExplicitWait();

	public BrowserType getBrowser();

}
