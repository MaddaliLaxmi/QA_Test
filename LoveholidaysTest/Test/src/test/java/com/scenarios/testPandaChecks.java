package com.scenarios;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utils.Dataprovider;

import junit.framework.Assert;

public class testPandaChecks extends Dataprovider {

	public testPandaChecks() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest
	public void startingBrowser() {
		driver.get("https://staging.loveholidays.com/");
	}
	
	
//	@Test
	public void validateDateFromSRPToPandA() throws IOException {
		searchHomeButton.click();
		//need to add a validation if we have landed on SRP page
		selectDateOnSRP();
		setDateOnSRP();
		clickAvailabilityButtonForHotel(getRandomHotelNumber());
		Assert.assertTrue(dateDisplayedOnPanda.getText().contains(setDateOnSRP()));
		
	}
	
@Test
public void manageMyBooking() throws IOException{
	manageBooking.click();
	enterBookingRef.sendKeys("LOV96209");
	enterPassengerSurname.sendKeys("AutoTestLNOne");
	signInButton.click();	
	}
	
	

}
