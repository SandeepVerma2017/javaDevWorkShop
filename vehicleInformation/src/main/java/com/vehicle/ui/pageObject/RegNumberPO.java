package com.vehicle.ui.pageObject;

/**
 * Page Object handling the Vehicle registration input page
 * */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vehicle.ui.framework.controller.Control;
import com.vehicle.ui.framework.controller.Edit;
import com.vehicle.ui.framework.controller.Page;



public class RegNumberPO extends Page {
	
	 public Edit registration;
	 public Control  Continue;


	public RegNumberPO(WebDriver driver) {
		super(driver);
		 registration= new Edit(this,By.id("Vrm"));		
	      Continue=new Control(this,By.name("Continue"));
	}
	


}
