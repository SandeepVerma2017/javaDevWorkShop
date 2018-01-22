package com.vehicle.ui.test;

import static org.junit.Assert.*;


import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import com.vehicle.domain.object.VehicleDomain;
import com.vehicle.file.io.FileReader;
import com.vehicle.ui.framework.Configuration;
import com.vehicle.ui.framework.Driver;
import com.vehicle.ui.framework.controller.PageFactory;
import com.vehicle.ui.pageObject.DvlaStartPO;
import com.vehicle.ui.pageObject.RegNumberPO;
import com.vehicle.ui.pageObject.VehicleConfirmationPage;
import com.vehicle.ui.pageObject.VehicleDetailsPO;


@RunWith(Parameterized.class)
public class VehicleInformationTest {

	private WebDriver driver;
	
	private String RegNumber;	
	List<VehicleDomain> vehicleListTop;

	public VehicleInformationTest(String regNumber) {
		super();
		RegNumber = regNumber;
	}

	@Before
	  public void setUp() throws Exception {
       DesiredCapabilities cap=new DesiredCapabilities();
		Driver.add(Configuration.get("browser"), cap);		
	    driver = Driver.current();
	    driver.get(Configuration.get("url"));
	    
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FileReader filecsv= new FileReader();
		List<VehicleDomain> vehicleList= filecsv.vehicleInformationFromAllFile();  
		vehicleListTop=vehicleList;
	  }
	
    @After
	  public void tearDown() throws Exception {
	    driver.quit();   
	  
	  }
    
   // Parameterising the test . fetching the parameters by calling file api. 
    @Parameters
    public static  Object[][] getParameters() {
    	
    	FileReader filecsv= new FileReader();
    	List<VehicleDomain> vehicleList= filecsv.vehicleInformationFromAllFile();
    	 Object[][] RegNum = new Object [vehicleList.size()][1];
         Iterator vehicleListIte=vehicleList.iterator();
         int i=0;
         while(vehicleListIte.hasNext()) {
      	 
      	  VehicleDomain vehcileInfo=(VehicleDomain)vehicleListIte.next();
      	  RegNum[i][0]=vehcileInfo.getRegNo();       	
      	  i++;
         }
         
         
         return RegNum;	

    }
    

/**
 * The Test run the Junit by initialising Various PageObject and executing the commands. 
 * */	
    @Test
    public void testSampleSearch()  {
		
		try {
			
		Reporter.log("******JUNIT TEST OF THE REG NUMBER ::"+RegNumber+"********START************************",true);	
		
		// dvla start page object initialised and click on a start button
		  DvlaStartPO dvlaStart= PageFactory.init(driver, DvlaStartPO.class);
			
		  dvlaStart.registration.click(); 
		  
		  Reporter.log("dvla start page completed successfully"); 	  
		 
		//  RegNumberPO page object initialised and input the reg number .
		  RegNumberPO regNumber= PageFactory.init(driver, RegNumberPO.class);
		  regNumber.registration.setText(RegNumber);
		  
		  regNumber.Continue.click();
		  
		  Reporter.log("RegNumberPO page object  completed successfully"); 
	
		//  VehicleConfirmationPage page object initialised and confirm the reg details
		  VehicleConfirmationPage vehicleConfirmationPage= PageFactory.init(driver, VehicleConfirmationPage.class);
		  vehicleConfirmationPage.yesnoRadio.click();
		  vehicleConfirmationPage.continue1.click();	
		  
		  Reporter.log("VehicleConfirmationPage page object  completed successfully");  
		  
		//  VehicleDetailsPO page object initialised and get the vehicle details.
	      VehicleDetailsPO vehicleDetails=  PageFactory.initElements(driver, VehicleDetailsPO.class);
	     
	      VehicleDomain serverVehicleDetails= vehicleDetails.getVehicleInfo();
	     
	      Reporter.log("Vehicle details fetched successfully");  
	      
	      // comparing the vehicle details fetched from server to the data stored in vehicle cache which is populated from csv and excel files.
	      Iterator fileVehicleList=vehicleListTop.iterator();
	     
	      while(fileVehicleList.hasNext()) {
	      
	    	  VehicleDomain vehcileInfo=(VehicleDomain)fileVehicleList.next();
	      	if (vehcileInfo.getRegNo().equals(RegNumber))
	      	{
	      		Reporter.log("Inside the reg number::"+RegNumber,true);
	      		assertEquals("Vehicle Make Matches",vehcileInfo.getMake().toUpperCase(),serverVehicleDetails.getMake().toUpperCase());
	      		assertEquals("Vehicle Colour Matches",vehcileInfo.getColour().toUpperCase(),serverVehicleDetails.getColour().toUpperCase());
	      	}
	         }
	      
	      Reporter.log("Assertion Completed "); 
	      
	      Reporter.log("******JUNIT TEST OF THE REG NUMBER ::"+RegNumber+"**********END**********************",true);   
		} catch(Exception e)
		{
			e.printStackTrace();
			
		}
	      
	        
		
		  
	}
	
	

}
