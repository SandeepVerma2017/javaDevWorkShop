package com.vehicle.ui.framework.controller;

/**
 * Controller class which abstract the selenium web driver control.
 * */
import org.openqa.selenium.By;

public class Edit extends Control{

	public Edit(Page parentValue, By locator)
{
    super(parentValue,locator);	

}

	 public void setText(String value) {
	        this.click();
	        this.element().clear();
	        this.element().sendKeys(value);
	    }

}
