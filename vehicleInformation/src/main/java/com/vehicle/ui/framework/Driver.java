package com.vehicle.ui.framework;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import org.openqa.selenium.Capabilities;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}
  private static WebDriver driver;
  private static final HashMap<String, Class<?>> driverMap = new HashMap<String, Class<?>>() {
      {
          put("chrome", ChromeDriver.class);
          put("firefox", FirefoxDriver.class);
          put("ie", InternetExplorerDriver.class);
          put("safari", SafariDriver.class);
          put("opera", OperaDriver.class);
          put("remote", RemoteWebDriver.class);
      }
  };
  
 public static void add(String browser, Capabilities capabilities) throws Exception
 {
	 Class<?> driverClass=driverMap.get(browser);
	 driver=(WebDriver)driverClass.getConstructor(Capabilities.class).newInstance(capabilities);
	
 }
	 public static WebDriver current() {
		 
		 return driver;
	 }
	 
 }

