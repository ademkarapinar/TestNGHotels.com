package com.qa.hotels.tests;

import org.testng.annotations.Test;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.pages.FiveStarHotelPage;
import com.qa.hotels.pages.FourStarHotelPage;
import com.qa.hotels.pages.MainPage;
import com.qa.hotels.pages.ThreeStarHotelPage;

public class HotelPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	MainPage mainPage;
	ThreeStarHotelPage threeStarHotelPage;
	FourStarHotelPage fourStarHotelPage;
	FiveStarHotelPage fiveStarHotelPage;
	
	@BeforeTest
	public void setUp() throws InterruptedException{
		basePage = new BasePage();
		prop = basePage.init_properties();
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
	    
		mainPage =new  MainPage(driver);
		threeStarHotelPage = new ThreeStarHotelPage(driver);
		threeStarHotelPage = mainPage.enteringInfo();
		fourStarHotelPage = new FourStarHotelPage(driver);
		fiveStarHotelPage = new FiveStarHotelPage(driver);
    }
	@Test(priority=1)
	public void click3StarTest() throws InterruptedException{
		threeStarHotelPage.click3Star();
	}
	@Test(priority=2)
	public void get3StarHotelTest() throws InterruptedException{
		threeStarHotelPage.get3StarHotels();
	}
	@Test(priority=3)
	public void get4StarHotelTest() throws InterruptedException{
		fourStarHotelPage.get4StarHotels();
	}
	@Test(priority=4)
	public void get5StarHotelTest() throws InterruptedException{
		fiveStarHotelPage.get5StarHotels();
	}
	@AfterTest
	public void tearDown(){
//		driver.quit();
	}
}