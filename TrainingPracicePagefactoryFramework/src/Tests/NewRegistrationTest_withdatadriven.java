package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.Regestration;
import Pages.ExcelHelper;
import Pages.Home;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class NewRegistrationTest_withdatadriven {
//	public WebDriver driver = new FirefoxDriver();
	public WebDriver driver;
    public String baseUrl = "http://newtours.demoaut.com";
    String expectedTitle="Register: Mercury Tours";
    String exptext= "Your user name is Test@test.com.";
    public   String path ="D:\\Selenium - Java\\Scripts\\TrainingPracicePagefactoryFramework\\src\\Registration.xlsx";
	 public String sheetName="Sheet1";
   // String path ="D:\\Selenium - Java\\Registration.xlsx";
     Home objHm;
     Regestration objreg;
    
    @BeforeTest
    public void openApplication() throws InterruptedException
    {
    	driver = new FirefoxDriver();
    	  driver.get(baseUrl);
    	 Thread.sleep(5000);
    }
    
    @Test(priority=0)
    public void VerifyRegisterLink() throws InterruptedException
    {
    	objHm = new Home(driver);
    	objHm.clickonRegisterlink();
    	String actualTitle=objHm.getRegistrationTitle();
  
  	  	  Assert.assertEquals(actualTitle, expectedTitle);
    }
    
    @Test(priority=1)
   public void VerifyUserRegistration() throws InterruptedException, IOException
    {
    	objreg= new Regestration(driver);
    	
    	List<HashMap<String,String>> datamap;
		datamap =  ExcelHelper.data(path,sheetName);
		  	  
	  	  
	  	  for (int i = 0; i <= 2; i++) {	
    	objreg.createUserRegistrationwihdatadriven(datamap,i);
    	String Actualtext= objreg.getRegisterPageText();
    	 String sExpected = "Your user name is "+datamap.get(i).get("username");
    	Assert.assertTrue(Actualtext.contains(sExpected));
    	objHm.clickonRegisterlink();
    	 }
    }
   
    
    @AfterTest
    public void closeApplication() throws InterruptedException
    {
    	  driver.close();
    	  driver.quit();
    }
    
}
