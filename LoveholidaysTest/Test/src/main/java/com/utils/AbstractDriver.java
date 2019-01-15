package com.utils;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;

public class AbstractDriver {

	 public static final String chromeMacdriver = "/src/main/resources/selenium_standalone_binaries/osx/googlechrome/64bit/chromedriver";
     public WebDriver driver = null;
    public static Wait<WebDriver> wait = null;  
    
    public AbstractDriver() throws IOException {
    	initialize();
    	PageFactory.initElements(driver, this);
    }

	public void initialize() throws IOException{
                DesiredCapabilities dc = DesiredCapabilities.chrome();
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +chromeMacdriver);
                driver = new ChromeDriver(dc);
            }
    }

