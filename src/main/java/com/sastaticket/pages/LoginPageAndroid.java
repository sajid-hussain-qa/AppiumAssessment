package com.sastaticket.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sastaticket.helper.AppiumHelper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * @author Sajid
 *
 */
public class LoginPageAndroid extends AppiumHelper implements LoginPage {

	@FindBy(xpath = "//*[@text='SIGN IN']")
	public MobileElement emailOption;

	@FindBy(xpath = "//*[@content-desc='Menu']") 
	MobileElement menu;
	@FindBy(xpath = "//*[@content-desc='Sign in']") 
	MobileElement signIn;
	
	@FindBy(xpath = "//android.widget.EditText[1]") 
	MobileElement emailTextField;
	@FindBy(xpath = "//android.widget.EditText[2]") 
	MobileElement passwordTextField;
	
	@FindBy(xpath = "//android.view.View[@content-desc='Log in']") 
	MobileElement loginButton;
	
	
	

	public LoginPageAndroid(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void login(String email, String passWord, String mode) {

		switch (mode) {
		case "email":
			clickElement(menu);
			clickElement(signIn);
			clickElement(emailTextField);
			inputString(emailTextField, email);
			clickElement(passwordTextField);
			inputString(passwordTextField, passWord);//inputString(passwordTextField, passWord);
			clickElement(loginButton);
			break;
		}
	}

}
