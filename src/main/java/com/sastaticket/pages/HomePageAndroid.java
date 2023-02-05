package com.sastaticket.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sastaticket.helper.AppiumController;
import com.sastaticket.helper.AppiumHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author 007Sajid
 *
 */
public class HomePageAndroid extends AppiumHelper implements HomePage {
	String firstPrice;
	List<MobileElement> childElements;
	WebDriverWait wait = new WebDriverWait(AppiumController.instance.driver, 10);
	@FindBy(xpath = "//android.view.View[@content-desc=\"Search\"]")
	public MobileElement searchSection;

	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]")
	public MobileElement leavingFrom;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Lahore\"]")
	public MobileElement leavingFrom2;

	
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]")
	public MobileElement leavingTo;

	@FindBy(xpath = "//android.view.View[@content-desc=\"Dubai\"]")
	public MobileElement leavingTo2;
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"Go\"]")
	public MobileElement Go;
	
	@FindBy(xpath= "//*[contains(@content-desc, 'PKR')]")
	public MobileElement flightAvailable;
	
	@FindBy(xpath = "//android.view.View[@content-desc=\"About \"]")
	public MobileElement homePageBrowseLink;

	
	
	public HomePageAndroid(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void selectFlights() {
		clickElement(searchSection);
		clickElement(leavingFrom);
		clickElement(leavingFrom2);
		clickElement(leavingTo);
		clickElement(leavingTo2);
		clickElement(Go);
		waitTillElementVisible(flightAvailable);
		
		childElements = (List<MobileElement>) AppiumController.instance.driver.findElements(By.xpath("//*[contains(@content-desc, 'PKR')]"));
		MobileElement at = (MobileElement)childElements.get(0);
		 firstPrice = at.getAttribute("content-desc").toString();
		
	
		
		
	}

	@Override
	public boolean isHomePageLoaded() {

		return isVisible(homePageBrowseLink);

	}
	@Override
	public boolean isSearchSuccessful() {
		//boolean aq = 
		return isVisible(flightAvailable);
	}
	@Override
	public String getPrice() {
		return firstPrice;
	}

}
