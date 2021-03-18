package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest 
{
	
	public static WebDriver driver;
	public static Properties config = new Properties();	

	
	@BeforeMethod
	public void setUp() throws IOException 
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Resources\\confi.properties");
		config.load(fis);
		String url = config.getProperty("url");
		String implicitwait = config.getProperty("implicitwait");
		String browser = config.getProperty("browser");
	
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/DriverSoftware/ChromeDriver.exe")	;
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.get(url);
		}
		else if (browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:/DriverSoftware/geckodriver.exe")	;
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(implicitwait), TimeUnit.SECONDS);
			driver.get(url);
		}
		
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
	 driver.quit();
	}

}
   
   
   



//if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty())
//{
//	browser=System.getenv("browser");
//}
//else
//{
//	browser = config.getProperty("browser");	
//}
//
//config.setProperty("browser", browser);
   
   
