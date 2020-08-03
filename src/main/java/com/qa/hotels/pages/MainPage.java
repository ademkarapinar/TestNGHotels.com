package com.qa.hotels.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

public class MainPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javascriptUtil;
		
	By popUp =By.xpath("//*[text()='']");
	By searchBox = By.xpath("//input[@id='qf-0q-destination']");
	By option1 = By.xpath("//*[@id='citysqm-asi0-s0']");
	By checkIn = By.xpath("//*[@id='qf-0q-localised-check-in']");
	By august15 = By.xpath("//*[@data-date='2020-7-15']//a");
	By checkOut = By.xpath("//*[@id='qf-0q-localised-check-out']");
	By august21 = By.xpath("//*[@data-date='2020-7-21']//a");
	By close2 = By.xpath("//*[@class='widget-overlay-close']");
	By room = By.xpath("//*[@id='qf-0q-rooms']");
	By adults = By.xpath("//*[@id='qf-0q-room-0-adults']");
	By children = By.xpath("//*[@id='qf-0q-room-0-children']");
	By firstChildAge = By.xpath("//*[@id='qf-0q-room-0-child-0-age']");
	By secondChildAge = By.xpath("//*[@id='qf-0q-room-0-child-1-age']");
	By searchButton = By.xpath("//*[text()='Search']");
	
	public MainPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javascriptUtil = new JavaScriptUtil(driver);
	}		
	public ThreeStarHotelPage enteringInfo() throws InterruptedException{
		elementUtil.doClick(popUp);
		elementUtil.doSendKeys(searchBox, "Boston, Massachusetts, United States of America");
		elementUtil.doClick(option1);
		elementUtil.doClick(checkIn);
		driver.findElement(checkIn).clear();
		elementUtil.doClick(august15);
		elementUtil.doClick(checkOut);
		driver.findElement(checkOut).clear();
		elementUtil.doClick(august21);
		
		elementUtil.doSelectSingleDropDown(room, 0);
		elementUtil.doSelectSingleDropDown(adults, 1);
		elementUtil.doSelectSingleDropDown(children, 2);
		elementUtil.doSelectSingleDropDown(firstChildAge, 5);
		elementUtil.doSelectSingleDropDown(secondChildAge, 10);
		elementUtil.doClick(searchButton);
		return new ThreeStarHotelPage(driver);
		
	}	
}
