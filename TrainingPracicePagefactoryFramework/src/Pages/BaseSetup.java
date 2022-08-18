/*
package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.*;

public class BaseSetup {

	private WebDriver driver;
		//static String driverPath = "D:\\chromedriver\";
	public boolean browserAlreadyOpen=false; 
	public static Properties SYSPARAM =null;
		
		//To Initialize .properties file. 
		//@BeforeClass
		public void initData() throws IOException{ 
			SYSPARAM = new Properties(); 
			FileInputStream Ist = new FileInputStream(System.getProperty("user.dir")+"//src//Pages//SYSPARAM.properties"); 
			SYSPARAM.load(Ist)	;
			System.out.println("Browser" + SYSPARAM.getProperty("BrowserToTestIn"));
			System.out.println("url" + SYSPARAM.getProperty("AppUrl"));
		} 
		
		
		public WebDriver getDriver() {
		try {
				initBrowser();
				
			} catch (Exception e) {
				System.out.println("Error....." + e.getStackTrace());
			}
		return driver;
		}
		
		private void initBrowser(){ 
			//if(!browserAlreadyOpen){ 
			if(SYSPARAM.getProperty("BrowserToTestIn").equals("MFF"))
			{ 
			
			driver = new FirefoxDriver();
			}else if(SYSPARAM.getProperty("BrowserToTestIn").equals("CHRM"))
			{ 
		     driver = new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
			driver.manage().window().maximize();
			System.out.println("Driver get url executing, system url :"+SYSPARAM.getProperty("AppUrl"));
		//	driver.navigate().to(SYSPARAM.getProperty("AppUrl"));
			String url = SYSPARAM.getProperty("AppUrl");
			
				driver.get(url.toString());
		
			
			//driver.get("http://newtours.demoaut.com");
		//	browserAlreadyOpen=true;
		//	} 
		 

		}

		public void tearDown() {
			driver.quit();
		}
	}
*/