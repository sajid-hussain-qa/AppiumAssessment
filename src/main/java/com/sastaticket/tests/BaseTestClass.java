package com.sastaticket.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.sastaticket.helper.AppiumBaseClass;
import com.sastaticket.helper.AppiumController;
import com.sastaticket.pages.AppStart;
import com.sastaticket.pages.AppStartAndroid;
import com.sastaticket.pages.HomePage;
import com.sastaticket.pages.HomePageAndroid;
import com.sastaticket.pages.LoginPage;
import com.sastaticket.pages.LoginPageAndroid;

/**
 * @author 007Sajid
 *
 */
public class BaseTestClass extends AppiumBaseClass {

	protected AppStart appStart;
	protected LoginPage loginPage;
	protected HomePage homePage;

	@BeforeSuite
	public void setUp() throws Exception {
		AppiumController.instance.start();
		switch (AppiumController.executionOS) {
		case ANDROID:
			
			appStart = new AppStartAndroid(driver());
			loginPage = new LoginPageAndroid(driver());
			homePage = new HomePageAndroid(driver());
			break;

		}
	}

	@AfterSuite
	public void tearDown() throws InterruptedException {
		AppiumController.instance.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AppiumController.instance.stop();
	}
}
