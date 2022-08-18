package Pages;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Regestration {
	WebDriver driver;
	
	@FindBy(name="firstName")
	WebElement firstnametxt;
	@FindBy(name="lastName")
	WebElement lastNametxt;
	@FindBy(name="phone")
	WebElement phonetxt;
	@FindBy(name="userName")
	WebElement userNametxt;
	@FindBy(name="address1")
	WebElement address1txt;
	@FindBy(name="address2")
	WebElement address2txt;
	@FindBy(name="city")
	WebElement citytxt;
	@FindBy(name="state")
	WebElement statetxt;
	@FindBy(name="postalCode")
	WebElement postalCodetxt;
	@FindBy(name="country")
	WebElement countrydrp;
	@FindBy(name="email")
	WebElement emailtxt;
	@FindBy(name="password")
	WebElement passwordtxt;
	@FindBy(name="confirmPassword")
	WebElement confirmPasswordtxt;
	@FindBy(name="register")
	WebElement registerbtn;
	@FindBy(linkText="REGISTER")
	WebElement registerlink;
	@FindBy(tagName="body")
	WebElement bodytag;
	
	public Regestration(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	public void createUserRegistration() throws InterruptedException 
	{
		
			firstnametxt.sendKeys("Testfirstname");
			lastNametxt.sendKeys("Testlastname");
			phonetxt.sendKeys("8888888889");
			userNametxt.sendKeys("testusername");
			address1txt.sendKeys("testaddress");
			address2txt.sendKeys("testaddress2");
			citytxt.sendKeys("Herndon");
			statetxt.sendKeys("Va");
			postalCodetxt.sendKeys("23456");
	 	  	Select drpcountry = new Select(countrydrp);
	 	    drpcountry.selectByVisibleText("UNITED STATES");
	 	    emailtxt.sendKeys("Test@test.com");
	 	    passwordtxt.sendKeys("Test1234$");
	 	    confirmPasswordtxt.sendKeys("Test1234$");
	 	    registerbtn.click();
	 	   Thread.sleep(2000);		
	}
	

	//use the excel 
	public void createUserRegistrationwihdatadriven(List<HashMap<String,String>> datamap,int i) throws InterruptedException, IOException
	{
		
	

		firstnametxt.sendKeys(datamap.get(i).get("firstName"));
		lastNametxt.sendKeys(datamap.get(i).get("lastName"));
		phonetxt.sendKeys(datamap.get(i).get("phone"));
		userNametxt.sendKeys(datamap.get(i).get("email"));
		address1txt.sendKeys(datamap.get(i).get("address1"));
		address2txt.sendKeys(datamap.get(i).get("address2"));
		citytxt.sendKeys(datamap.get(i).get("city"));
		statetxt.sendKeys(datamap.get(i).get("state"));
		postalCodetxt.sendKeys(datamap.get(i).get("postalcode"));
		Select drpcountry = new Select(countrydrp);
 	    drpcountry.selectByVisibleText(datamap.get(i).get("country"));
 	   emailtxt.sendKeys(datamap.get(i).get("username"));
 	  passwordtxt.sendKeys(datamap.get(i).get("password"));
 	 confirmPasswordtxt.sendKeys(datamap.get(i).get("confirmpassword"));
 	 registerbtn.click();
	   Thread.sleep(2000);
		  
	
}

	
	public String getRegisterPageText() throws InterruptedException
	{
		return bodytag.getText();
	}
	
	}
	
	
				

