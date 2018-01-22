package com.vehicle.ui.pageObject;

/**
 * Start page of the DVLA vehicle information.
 * */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vehicle.ui.framework.controller.Control;
import com.vehicle.ui.framework.controller.Page;

public class DvlaStartPO extends Page  {
	 public Control registration;
	 
	 public DvlaStartPO(WebDriver driver) {
		super(driver);
		registration= new Control(this,By.linkText("Start now"));
	}

	
}
