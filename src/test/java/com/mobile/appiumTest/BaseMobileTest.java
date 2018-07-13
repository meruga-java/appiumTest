package com.mobile.appiumTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.mobile.appium.ReadFromJson;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * 
 * @author meruga
 *
 */

public class BaseMobileTest {

	public static AppiumDriver driver;
	public static final Logger LOGGER = Logger.getLogger(BaseMobileTest.class.getName());

	@BeforeTest
	public void initializeDriver() throws MalformedURLException {
		DOMConfigurator.configure("log4j.xml");

		LOGGER.info("===========Starting Test============");
		String driverConfigFilePath = System.getProperty("user.dir") + "/src/test/resources/config/"
				+ System.getProperty("driverConfig");
		DesiredCapabilities capabilities = ReadFromJson.readCapabilities(driverConfigFilePath);
		String driverConfig = ReadFromJson.readKey(driverConfigFilePath, "platform");
		if (driverConfig.equals("ANDROID")) {
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723" + "/wd/hub"), capabilities);
		} else if (driverConfig.equals("iOS")) {
			driver = new IOSDriver<>(new URL("http://127.0.0.1:4723" + "/wd/hub"), capabilities);
		}
	}

	@AfterTest
	public void clean() {
		LOGGER.info("===========Ending Test============");
		driver.quit();
	}

}
