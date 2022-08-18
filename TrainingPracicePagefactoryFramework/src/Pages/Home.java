package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home  {	
	WebDriver driver;
	// driver.findElement(By.linkText("REGISTER"))
	
	@FindBy(linkText="REGISTER")
	WebElement registerlink;
	
	
	
	@FindBy(linkText="SIGN-ON")
	WebElement signonlink;
		
	@FindBy(linkText="SIGN-OFF")
	WebElement signofflink;
	
	@FindBy(name = "userName")
	WebElement usernametxtfld;
	
	public Home(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}
	
	
	
		//click on register link
	public void clickonRegisterlink(){
		System.out.println("clickonRegisterlink method");
	//	 driver.findElement(By.linkText("REGISTER")).click();
		   
		registerlink.click();
		System.out.println("after register link method");		
	}
	
	//get the title of registration page
	public String getRegistrationTitle(){
	 return	driver.getTitle();
	}
	
	//click on signon link
	public void clickonSignonlink()
	{
	{
		signonlink.click();
	}
	public void clickSignofflink()
		signofflink.click();
	}
}
	

				

