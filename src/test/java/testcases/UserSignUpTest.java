package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class UserSignUpTest extends BaseTest
	
{
	

	@DataProvider
	public Object[][] data()
	{
		Object[][] data = new Object[2][2];
		data[0][0] ="jojou1";
		data[0][1] = "bean1";
		data[1][0] ="jojou2";
		data[1][1] = "bean2";
//		data[2][0] ="jojod3";
//		data[2][1] = "bean3";
//		data[3][0] ="jojod4";
//		data[3][1] = "bean4";
//		data[4][0] ="jojod5";
//		data[4][1] = "bean5";
//		data[5][0] ="jojod6";
//		data[5][1] = "bean6";
		
		
		return data;
	}
	
	@Test(dataProvider = "data")
	public void signUp(String username, String password) throws InterruptedException 
	{	
		String address = "NY";
		String zip ="10003";
	    //driver.get("http://localhost:1080/WebTours/index.htm");
	    driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='body']")));
	    driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='info']")));
		driver.findElement(By.xpath("//a[@href='/cgi-bin/login.pl?username=&password=&getInfo=true']")).click();
		driver.findElement(By.xpath("//input[@name='username' and @size='20']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password' and @size='20']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='passwordConfirm']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(address);
		driver.findElement(By.xpath("//input[@name='address2']")).sendKeys(zip);
		driver.findElement(By.xpath("//input[@name='register']")).click();
		
		
		String actual = driver.findElement(By.xpath("//blockquote[contains(text(),'Thank you, ')]")).getText();
		String expected="Thank you, "+username+", for registering and welcome to the Web Tours family. We hope we can meet all your current and future travel needs. If you have any questions, feel free to ask our support staff. Click below when you're ready to plan your dream trip...";

		//Assert.assertEquals(actual, expected);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, expected);
		sa.assertAll();
		
	    //driver.get("http://localhost:1080/WebTours/index.htm");
		driver.switchTo().defaultContent();
	    driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='body']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='navbar']")));
		driver.findElement(By.xpath("//input[@name='username' and @size='14']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password' and @size='14']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Thread.sleep(1000);
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='body']")));
//		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='navbar']")));		
//		driver.findElement(By.xpath("//img[@alt='Search Flights Button']")).click();
		
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
	    driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='body']")));

		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='info']")));

		
		String actual2 = driver.findElement(By.xpath("//blockquote[contains(text(),'Welcome, ')]")).getText();
		//String expected2="Welcome, "+username+", to the Web Tours reservation pages.";

		Assert.assertTrue(actual2.contains("Welcome, "+username+","));
		
	
	}

}
	
	
	


