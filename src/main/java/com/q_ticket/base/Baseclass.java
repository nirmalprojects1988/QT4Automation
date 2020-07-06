package com.q_ticket.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.q_ticket.Listener.*;
import org.openqa.selenium.TakesScreenshot;

public class Baseclass {

	public static WebDriver driver;

	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;


	public Baseclass() {
		try {
			String path = System.getProperty("user.dir"); // return project folder path

			String config = path + "\\configfile\\project.properties";

			System.setProperty("webdriver.chrome.driver", config);
			prop = new Properties();
			FileInputStream is = new FileInputStream(config);
			prop.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void init() {
		String browser = prop.getProperty("browsername");
		if (browser.equalsIgnoreCase("Chrome")) {
			String path = System.getProperty("user.dir"); // return project folder path

			String driverpath = path + "\\Drivers\\chromedriver.exe";

			System.setProperty("webdriver.chrome.driver", driverpath);
			driver = new ChromeDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

	public static void Takescreenshot(String methodname) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd h-m-s");
		Date date = new Date();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String location = "./ScreenShots/";

		FileUtils.copyFile(source, new File(location + methodname + "_" + dateFormat.format(date) + ".png"));
	}

	
}
