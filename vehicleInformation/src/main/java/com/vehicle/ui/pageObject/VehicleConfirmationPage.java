package com.vehicle.ui.pageObject;

/**
 * Page Object handling the vehicle confirmation page.
 * */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vehicle.ui.framework.controller.Control;
import com.vehicle.ui.framework.controller.Page;

public class VehicleConfirmationPage extends Page{
	
	 public WebElement  yesnoRadio;
	 public Control   continue1;



	public VehicleConfirmationPage(WebDriver driver) {
		super(driver);
		yesnoRadio= driver.findElement(By.id("Correct_True"));
		continue1=new Control(this,By.name("Continue"));
	}

}
