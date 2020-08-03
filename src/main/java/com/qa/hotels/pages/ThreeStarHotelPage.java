package com.qa.hotels.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hotels.base.BasePage;
import com.qa.hotels.util.ElementUtil;
import com.qa.hotels.util.JavaScriptUtil;

public class ThreeStarHotelPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javascriptUtil;
	double requestedMile =10;
	
	By threeStar = By.xpath("//*[@id='f-star-rating-3']");
	By hotelList = By.xpath("//*[@class='hotel-wrap']//a[@class='property-name-link']");
	
	By distance = By.xpath("//a[text()='Distance']");
	By cityCenter = By.xpath("//a[text()='City center']");
	By hotelMiles = By.xpath("//ul[@class='property-landmarks']/li[contains(text(), 'City center')]");
	
	public ThreeStarHotelPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
		javascriptUtil = new JavaScriptUtil(driver);

   }
	public void click3Star() throws InterruptedException{
		elementUtil.doClick(threeStar);	
			for(int second = 0;; second++){
				if(second >=60){
					break;
				}
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");
				Thread.sleep(500);
			}
			List<WebElement> hotels = driver.findElements(hotelList);
			for (int i = 0; i < hotels.size(); i++) {
				String list = hotels.get(i).getText();
	//		 System.out.println(list);
				if (list.contains("Hilton")) {
					System.out.println("Hilton Hotel list: "+list);
				
			}		
		}
	}
	public void get3StarHotels() throws InterruptedException{
		elementUtil.doClick(threeStar);
		elementUtil.doClick(distance);
		elementUtil.doClick(cityCenter);
		for(int second = 0;; second++){
			if(second >=80){
				break;
				
			}
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");
			Thread.sleep(1000);
			
		}	
	List<WebElement> hotelNames = driver.findElements(By.xpath("//*[@class='hotel-wrap']//h3"));
	List<WebElement> miles = driver.findElements(hotelMiles);
	for (int i = 0; i < hotelNames.size(); i++) {
		String text = hotelNames.get(i).getText();
		String text1 = miles.get(i).getText();
		String hotelMilesr = text1.replaceAll("[a-zA-Z ]", "");
		double radius = Double.parseDouble(hotelMilesr);
		// System.out.println(radius);
		if (radius<requestedMile) {
			System.out.println(hotelNames.get(i).getText() + " " + radius);
		}
	 }
   }
}