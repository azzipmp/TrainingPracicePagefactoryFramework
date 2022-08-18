package Tests;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.Regestration;
import Pages.Home;




public class NewRegistrationTest_withoutdatadriven {
//	public WebDriver driver = new FirefoxDriver();
	public WebDriver driver;
    public String baseUrl = "http://newtours.demoaut.com";
    String expectedTitle="Register: Mercury Tours";
    String exptext= "Your user name is Test@test.com.";
   
   // String path ="D:\\Selenium - Java\\Registration.xlsx";
     Home objHm;
     Regestration objreg;
    
    @BeforeTest
    public void openApplication() throws InterruptedException
    {
    	System.setProperty("webdriver.gecko.driver", "C:\\firefoxdriver\\geckodriver.exe");
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
    	objreg.createUserRegistration();
    	String Actualtext= objreg.getRegisterPageText();
    	Assert.assertTrue(Actualtext.contains(exptext));
    	 }
   
    
    @AfterTest
    public void closeApplication() throws InterruptedException
    {
    	  driver.close();
    	  driver.quit();
    }
    
}
