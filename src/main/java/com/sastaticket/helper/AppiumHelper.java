package com.sastaticket.helper;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;

/**
 * @author 007sajid
 *
 */
public class AppiumHelper {

	//wait for maximum 30 seconds before any operation
	WebDriverWait wait = new WebDriverWait(AppiumController.instance.driver, 30);

	protected String getPageSource() {
		return AppiumController.instance.driver.getPageSource();
	}

	protected void inputString(MobileElement mobileElement, String stringToBeEntered) {
		mobileElement = waitTillElementVisible(mobileElement);
		mobileElement.sendKeys(stringToBeEntered);
		AppiumController.instance.driver.hideKeyboard();
	}

	protected void clickElement(MobileElement mobileElement) {
		mobileElement = waitTillElementVisible(mobileElement);
		mobileElement.click();
	}

	protected String getAttribute(MobileElement mobileElement, String attr) {
		mobileElement = waitTillElementVisible(mobileElement);
		return mobileElement.getAttribute(attr);
	}

	protected void goBack() {
		AppiumController.instance.driver.navigate().back();
	}

	protected boolean isVisible(MobileElement mobileElement) {

		boolean status = false;
		try {
			mobileElement = waitTillElementVisible(mobileElement);
			status = true;
		} catch (Exception e) {

		}
		return status;
	}

	protected MobileElement waitTillElementVisible(MobileElement mobileElement) {
		return (MobileElement) wait.until(ExpectedConditions.visibilityOf(mobileElement));

	}

}
