package com.sastaticket.helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author 007sajid
 *
 */
public class AppiumController {

	public static OS executionOS = OS.ANDROID;

	public enum OS {
		ANDROID
	}

	public static AppiumController instance = new AppiumController();
	public AppiumDriver<?> driver;

	@SuppressWarnings("rawtypes")
	public void start() throws MalformedURLException {
		if (driver != null) {
			return;
		}
		switch (executionOS) {
		case ANDROID:
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "/app/Android");
			File app = new File(appDir, "Sasta ticket - Flights, Hotels_0.5.0_Apkpure.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("deviceName", "Sajid");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", "com.pk.sastaticket");
			capabilities.setCapability("appActivity", "com.sastaticket.MainActivity");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			break;
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void stop() throws InterruptedException {
		Thread.sleep(10000);
		
	//	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
