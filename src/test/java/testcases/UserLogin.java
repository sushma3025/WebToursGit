package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;
import utilities.ReadingFileFromExcel;

public class UserLogin extends BaseTest
{
//	@DataProvider()
//	public Object[][] data() throws IOException
//	{
//		
//		Object[][] data = ReadingFileFromExcel.ExcelFile("UserLogin");
//		return data;
//		
//	
	@Test
	public void verifyUser2() throws InterruptedException, IOException
	{
		   FileInputStream fis = new FileInputStream("C:\\JavaBasics\\WebTours\\Resources\\ExcelData.xlsx");
		   XSSFWorkbook wb = new XSSFWorkbook(fis);
		   XSSFSheet sheet = wb.getSheet("UserLogin");
		   Iterator<Row> rowIterator = sheet.iterator();
		   while(rowIterator.hasNext()) 
		   {
			   Row row = rowIterator.next();
			   if(row.getRowNum() > 0)
			   {
				    driver.get("http://localhost:1080/WebTours/index.htm");
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='body']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='navbar']")));
			   //For each row, iterate through each columns
			   Iterator<Cell> cellIterator = row.cellIterator();
			   while(cellIterator.hasNext()) 
			   {  
				   Cell cell = cellIterator.next();
				   if(cell.getColumnIndex() == 0)
				   {
					   driver.findElement(By.name("username")).sendKeys(cell.getStringCellValue());
				   }
				   else
				   {
					   driver.findElement(By.name("password")).sendKeys(cell.getStringCellValue());
				   }
		 
			   }
			   
			   Thread.sleep(2000);
			   driver.findElement(By.xpath("//input[@name='login']")).click();
			   Thread.sleep(2000);
			   
			   driver.switchTo().defaultContent();
			    driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='body']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='info']")));
			   String actual = driver.findElement(By.xpath("//blockquote")).getText();
			   //Assert.assertTrue(actual.contains("Welcome, "));
			   
			   SoftAssert sa = new SoftAssert();
			   sa.assertTrue(actual.contains("Welcome, "));
               sa.assertAll();
			   }
				driver.switchTo().defaultContent();
			    driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='body']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='info']")));
				
			   
		   }

	}
}



//driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='body']")));
//driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='navbar']")));
//driver.findElement(By.xpath("//input[@name='username' and @size='14']")).sendKeys(username);
//driver.findElement(By.xpath("//input[@name='password' and @size='14']")).sendKeys(password);
//driver.findElement(By.xpath("//input[@name='login']")).click();
		   
		   
