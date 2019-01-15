package com.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class Dataprovider extends AbstractDriver{
	
	
	public Dataprovider() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@FindBy(css = "div.search-unit-flight-and-hotel__cta > div > div > a")
	 public WebElement searchHomeButton;
	
	@FindBy(css = "a.link-input__cal-icon__link")
	 public WebElement clickOnCalendarICon;
	
	@FindBy(css = ".book-select__select")
     public WebElement calendarMonth;
	
	@FindBy(css = ".search-unit-custom-control-calendar-day__number.search-unit-custom-control-calendar-day__number--available")
	 public List<WebElement> firstDayOfMonth;
	
	@FindBy(css = "div.link-input__input.link-input__input--tag div a span time")
     public WebElement selectedMonthOnSRP;
	
	@FindBy(css = "div.spaced-list > div:nth-child(2) > div > div > div > a")
	public List<WebElement> clickOnAvailabilityButtonOnSRP;
	
	@FindBy(css = "div.cheapest-offer-hotel-details > p")
	public WebElement dateDisplayedOnPanda;
	
	@FindBy(css = "ul > li:nth-child(7) > a")
	public WebElement manageBooking;
	
	@FindBy(css = "input.form-input")
	public WebElement enterBookingRef;
	
	@FindBy(css = "div:nth-child(2) > label > div.form-input-with-validation > input")
	public WebElement enterPassengerSurname;
	
	@FindBy(css="div.custom-button")
	public WebElement signInButton;
	
	public void selectDateOnSRP() {
		String actual = searchHomeButton.getText();
		String expected = "Search";
		Assert.assertEquals(actual, expected);
		System.out.println(actual);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		clickOnCalendarICon.click();
		System.out.println("click");
		Select select = new Select(calendarMonth);
		select.selectByIndex(4);
	    firstDayOfMonth.get(0).click();
	}
	
	 public static int getRandomHotelNumber() {
	        List<Integer> hotelNumber = new ArrayList<>(0);
	        for(int i=1; i<10; i++) {
	            hotelNumber.add(i);
	        }
	        Collections.shuffle(hotelNumber);
	        return hotelNumber.get(0);
	    }
	
	public String setDateOnSRP() {
	  return selectedMonthOnSRP.getText();
	}
	
	public void clickAvailabilityButtonForHotel(int n) {
		clickOnAvailabilityButtonOnSRP.get(n-1).click();
	}

	@DataProvider(name = "mmbLoginDetails")
    public Object[][] mmbRequestChangeCredentials() {
		
		//driver.findElement(By.xpath("div.search-unit-flight-and-hotel__cta > div > div > a"));
        if ((driver.getCurrentUrl().contains("dev"))) {
            return new Object[][] {{ "LOV59998", "AutoTestLNOne"}};
        }
        else if(driver.getCurrentUrl().contains("staging")) {
            return new Object[][] {{ "LOV87232", "hkhkkhj"}};
        }
        return new Object[][] {};
    }

}
