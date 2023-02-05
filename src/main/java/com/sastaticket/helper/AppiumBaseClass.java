package com.sastaticket.helper;

import io.appium.java_client.AppiumDriver;

/**
 * @author 007sajid
 *
 */
public abstract class AppiumBaseClass {

	protected AppiumDriver<?> driver() {
		return AppiumController.instance.driver;
	}

}
