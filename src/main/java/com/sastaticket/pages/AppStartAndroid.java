package com.sastaticket.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sastaticket.helper.AppiumHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


/**
 * @author 007sajid
 *
 */

public class AppStartAndroid extends AppiumHelper implements AppStart{
		
		@FindBy(xpath = "//*[@text='Allow']") 
		MobileElement allow;
		@FindBy(xpath = "//android.view.View[@content-desc=\"Skip\"]")
		MobileElement skip;
		
		
		public AppStartAndroid(AppiumDriver<?> driver) {
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		public void start() {
			
			clickElement(allow);
			clickElement(skip);
			
	
		}

	

}
