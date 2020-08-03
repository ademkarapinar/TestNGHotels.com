package com.qa.hotels.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.MainPage;

public class MainPageTest {
	
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	
	@BeforeTest
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		
		mainPage = new MainPage(driver);
	}	
	@Test(priority=1)
	public void enteringInfoTest() throws InterruptedException{
		mainPage.enteringInfo(); 
	}
	@AfterTest
	public void tearDown(){
//		driver.quit();
	}
}
