package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileReader 
{
	WebDriver driver;
   @Test
   public void excelFile() throws IOException, InterruptedException
   {
	   System.setProperty("webdriver.chrome.driver", "C:/DriverSoftware/ChromeDriver.exe")	;
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	   driver.get("http://localhost:1080/WebTours/index.htm");
	   driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='body']")));
	   driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='navbar']")));
	   driver.findElement(By.name("username")).sendKeys("jojo");
	   driver.findElement(By.name("password")).sendKeys("bean");

	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//input[@name='login']")).click();
	   Thread.sleep(2000);

	   driver.switchTo().defaultContent();
	   driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='body']")));
	   driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='info']")));
	   String actual = driver.findElement(By.xpath("//blockquote")).getText();

	   if(actual.contains("Welcome, "))
	   {
		   driver.switchTo().defaultContent();
		   driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='body']")));
		   driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='navbar']")));
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//img[@alt='Search Flights Button']/parent::a")).click();
		   FileInputStream fis = new FileInputStream("C:\\JavaBasics\\WebTours\\Resources\\ExcelData.xlsx");
		   XSSFWorkbook wb = new XSSFWorkbook(fis);
		   XSSFSheet sheet2 = wb.getSheet("FlightDetails");
		   Iterator<Row> rowIterator2 = sheet2.iterator();

		   while(rowIterator2.hasNext()) 
		   {
			   driver.switchTo().defaultContent();
			   driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='body']")));
			   driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='info']")));
         	   Row row2 = rowIterator2.next();
			   if(row2.getRowNum() > 0)
			   {
				   //For each row, iterate through each columns
				   Iterator<Cell> cellIterator2 = row2.cellIterator();
				   while(cellIterator2.hasNext()) 
				   {        
					   Cell cell2 = cellIterator2.next();
					   if(cell2.getColumnIndex() == 0)
					   {
						   Select select = new Select(driver.findElement(By.xpath("//select[@name='depart']")));
						   select.selectByVisibleText(cell2.getStringCellValue());
					   }

					   else if(cell2.getColumnIndex() == 1)
					   {
						   Select select = new Select(driver.findElement(By.xpath("//select[@name='arrive']")));
						   select.selectByVisibleText(cell2.getStringCellValue());
						   Thread.sleep(2000);
					   }
					   else if(cell2.getColumnIndex() == 2)
					   {
						   WebElement ele = driver.findElement(By.xpath("//input[@name='numPassengers']"));
						   ele.clear();
						   ele.sendKeys(cell2.toString());
						   Thread.sleep(2000);
					   }

				   }
				   driver.findElement(By.xpath("//input[@name='findFlights']")).click();
				   Thread.sleep(2000);
				   driver.navigate().back();
				   Thread.sleep(2000);

			   }



			   Thread.sleep(2000);



		   }

	   }
	   Thread.sleep(3000);	
   }
}







//FileInputStream fis = new FileInputStream("C:\\JavaBasics\\WebTours\\Resources\\ExcelData.xlsx");
//XSSFWorkbook wb = new XSSFWorkbook(fis);
//XSSFSheet sheet = wb.getSheet("UserLogin");
//
//
//Iterator<Row> rowIterator = sheet.iterator();
//
//while(rowIterator.hasNext()) 
//{
//	  
//	   Row row = rowIterator.next();
//	   if(row.getRowNum() > 0)
//	   {
//		   driver.get("http://localhost:1080/WebTours/index.htm");
//			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='body']")));
//			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='navbar']")));
//			   
//	   
//	   //For each row, iterate through each columns
//	   Iterator<Cell> cellIterator = row.cellIterator();
//	   
//	   while(cellIterator.hasNext()) 
//	   {        
//
//		   Cell cell = cellIterator.next();
//		   if(cell.getColumnIndex() == 0)
//		   {
//			   driver.findElement(By.name("username")).sendKeys(cell.getStringCellValue());
//		   }
//		   else
//		   {
//			   driver.findElement(By.name("password")).sendKeys(cell.getStringCellValue());
//		   }
//
//		   
//	   }
