package com.vehicle.ui.framework.controller;

/**
 * Create abstraction for common page functions
 * 
 * */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {
	
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}



	public Page(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	public Page navigate() {
		
		return this;
	}
	
	  public boolean isTextPresent(String text) {
	        String locator = String.format("//*[text()='%s' or contains(text(), '%s')]", text, text);
	        Control element = new Control(this, By.xpath(locator));
	        return element.exists();
	    }
}
