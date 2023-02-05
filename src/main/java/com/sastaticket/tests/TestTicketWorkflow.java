package com.sastaticket.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author 007sajid
 *
 */
public class TestTicketWorkflow extends BaseTestClass {
	//Login Credentials can be imported from a file or somewhere else easily
	
	private String email = "testsajid1122@gmail.com";
	private String password = "123Testing";
	private String loginMode = "email";
	private String minAmount = "PKR 100,000";
	private boolean a = false;
	@Test
	public void verifyTestTicketWorkflow() {

		
		appStart.start();
		
		// Log in using the credentials
		loginPage.login(email, password, loginMode);
		// Verify whether the homepage is loaded after login
		Assert.assertEquals(true, homePage.isHomePageLoaded());
		// Select flights section from home page
		homePage.selectFlights();
		
		//Verify Search Have some results or not.
		Assert.assertEquals(true, homePage.isSearchSuccessful());
		
		
		
		String Price = homePage.getPrice();
		//Verify Price is available and is not null. 
		Assert.assertNotNull(Price);
		// Get First price and verify if its below required minimum amount or not.
		if(Price.compareTo(minAmount)>0)		
			a=true;
		Assert.assertEquals(true,a);
		
	}

}
