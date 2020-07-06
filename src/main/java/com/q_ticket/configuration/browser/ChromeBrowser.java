package com.q_ticket.configuration.browser;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.q_ticket.framework.utility.DateTimeHelper;
import com.q_ticket.framework.utility.ResourceHelper;
public class ChromeBrowser {
	
	public static ChromeOptions getChromeCapabilities() {

//		DesiredCapabilities cap = DesiredCapabilities.chrome();
//		cap.setJavascriptEnabled(true);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		
		return options;
	}
	
	public static WebDriver getChromeDriver(Capabilities cap){
		System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("driver/chromedriver.exe"));
		System.setProperty("webdriver.chrome.logfile", ResourceHelper.getResourcePath("logs/chromelogs/") + "chromelog" + DateTimeHelper.getCurrentDateTime() + ".log");
		ChromeDriver driver = new ChromeDriver();
		return driver;
	}
	

}
