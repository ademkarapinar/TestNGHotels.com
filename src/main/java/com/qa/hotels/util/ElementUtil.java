package com.qa.hotels.util;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hotels.base.BasePage;

public class ElementUtil extends BasePage{
	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil javascriptUtil;
	Properties prop;
	
	public ElementUtil(WebDriver driver){
		this.driver=driver;
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_TIMEOUT);
		javascriptUtil = new JavaScriptUtil(driver);
	}
	/**
	 * wait for title
	 * @param title
	 * @return
	 */
	public boolean waitForTitlePresent(String title){
		wait.until(ExpectedConditions.titleIs(title));
		return true;
	}
	/**
	 * presence of element
	 * @param locator
	 * @return
	 */
	public boolean waitForElementPresent(By locator){
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return true;
	}
	/**
	 * visibilityOfElement
	 * @param locator
	 * @return
	 */
	public boolean waitForElementVisible(By locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;
	}
	/**
	 * @author adem
	 * get title method
	 * @return
	 */
	public String doGetPageTitle(){
		try {
			return driver.getTitle();
		} catch (Exception e) {
         System.out.println("Some exception got occured while getting the title...");		
    }
		return null;			
	}
	/**
	 * getElement
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator){
		WebElement element = null;
		try {
//			if(waitForElementPresent(locator));   
			element = driver.findElement(locator);
//			if(highlightElement){
//				javascriptUtil.flash(element);
//			}
		} catch (Exception e) {
	         System.out.println("Some exception got occured while creating web element..." +locator);		
		}
		return element;
	}
	/**
	 * doClickMethod
	 * @param locator
	 */
	public void doClick(By locator){
		try {
			getElement(locator).click();
		} catch (Exception e) {
	         System.out.println("Some exception got occured while clicking web element..." +locator);		
		}
	}
	/**
	 * doSendKeysMethod
	 * @param locator
	 * @param value
	 */
		public void doSendKeys(By locator, String value){
			try {
				WebElement element = getElement(locator);
				element.clear();
				element.sendKeys(value);
			} catch (Exception e) {
		         System.out.println("Some exception got occured while entering value...");		
			}
		}
		/**
		 * isDisplayedMethod
		 * @param locator
		 * @return
		 */
		public boolean doIsDisplayed(By locator){
			try {
				return getElement(locator).isDisplayed();
			} catch (Exception e) {
		         System.out.println("Some exception got occured while isDisplayed...");		
			}
			return false;
		}
		/**
		 * isEnabledMethod
		 * @param locator
		 * @return
		 */
		public boolean doIsEnabled(By locator){
			try {
				return getElement(locator).isEnabled();
			} catch (Exception e) {
		         System.out.println("Some exception got occured while isEnabled...");		
			}
			return false;
		}
		/**
		 * IsSelectedMethod
		 * @param locator
		 * @return
		 */
		public boolean doIsSelected(By locator){
			try {
				return getElement(locator).isSelected();
			} catch (Exception e) {
		         System.out.println("Some exception got occured while IsSelected...");		
			}
			return false;
		}
		/**
		 * doGetTextMethod
		 * @param locator
		 * @return
		 */
		public String doGetText(By locator){
			try {
				return getElement(locator).getText();
			} catch (Exception e) {
		         System.out.println("Some exception got occured while getting text...");		
			}
			return null;
		}
		public void doSelectSingleDropDown(By locator, int index){
			WebElement element = driver.findElement(locator);
			Select select = new Select(element);
			select.selectByIndex(index);
		}
	}

