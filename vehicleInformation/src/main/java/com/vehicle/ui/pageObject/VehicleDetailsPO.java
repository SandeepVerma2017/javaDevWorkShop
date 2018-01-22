package com.vehicle.ui.pageObject;

/**
 * Page Object storing the vehicle information received from server.
 * */


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.vehicle.domain.object.VehicleDomain;
import com.vehicle.ui.framework.controller.Page;


public class VehicleDetailsPO extends Page{
	
	WebDriver driver;
	
	public VehicleDetailsPO(WebDriver driver) {
		super(driver);
			this.driver=driver;
			
	}

  public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getRegistration() {
		return registration;
	}
	public void setRegistration(WebElement registration) {
		this.registration = registration;
	}
	public WebElement getYm() {
		return ym;
	}
	public void setYm(WebElement ym) {
		this.ym = ym;
	}
	public WebElement getCc() {
		return cc;
	}
	public void setCc(WebElement cc) {
		this.cc = cc;
	}
	public WebElement getCo2em() {
		return co2em;
	}
	public void setCo2em(WebElement co2em) {
		this.co2em = co2em;
	}
	public WebElement getFuelType() {
		return fuelType;
	}
	public void setFuelType(WebElement fuelType) {
		this.fuelType = fuelType;
	}
	public WebElement getExportMaker() {
		return exportMaker;
	}
	public void setExportMaker(WebElement exportMaker) {
		this.exportMaker = exportMaker;
	}
	public WebElement getVehicleColur() {
		return vehicleColur;
	}
	public void setVehicleColur(WebElement vehicleColur) {
		this.vehicleColur = vehicleColur;
	}
	
	 public WebElement getRegnum() {
			return Regnum;
		}

  @FindBy(xpath="//text()[contains (., 'Vehicle make:')]/following::strong[1]") WebElement registration;
  @FindBy(xpath="//text()[contains (., 'Year of manufacture:')]/following::strong[1]") WebElement ym;
  @FindBy(xpath="//text()[contains (., 'Cylinder capacity (cc):')]/following::strong[1]") WebElement cc;
  @FindBy(xpath="//text()[contains (., 'Fuel type:')]/following::strong[1]") WebElement co2em;
  @FindBy(xpath="//text()[contains (., 'Fuel type:')]/following::strong[1]") WebElement fuelType;
  @FindBy(xpath="//text()[contains (., 'Export marker:')]/following::strong[1]") WebElement exportMaker;
  @FindBy(xpath="//text()[contains (., 'Vehicle colour:')]/following::strong[1]") WebElement vehicleColur;
  @FindBy(xpath="//text()[contains (., 'BETA')]/following::span[1]") WebElement Regnum;

 

public  void printElements()
  {
	  Reporter.log("vehicleDetails.getRegistration().::"+getRegistration().getText(),true);
      Reporter.log("vehicleDetails.getCc()::"+getCc().getText(),true);
      Reporter.log("vehicleDetails.getCo2em()::"+getCo2em().getText(),true);
      Reporter.log("vehicleDetails.getExportMaker()::"+getExportMaker().getText(),true);
      Reporter.log("vehicleDetails.getVehicleColur()::"+getVehicleColur().getText(),true);
      Reporter.log("vehicleDetails.getFuelType()::"+getFuelType().getText(),true); 
      Reporter.log("vehicleDetails.Regnum()::"+Regnum.getText(),true); 
	  
  }
  
  public  VehicleDomain getVehicleInfo()
    {
	  VehicleDomain serverVehicleInfo = new VehicleDomain();
	  serverVehicleInfo.setMake(getRegistration().getText());
	  serverVehicleInfo.setColour(getVehicleColur().getText());
	  serverVehicleInfo.setRegNo(Regnum.getText());
	  return serverVehicleInfo;
	  
  }
  
  
  
  
	
}
