package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingFileFromExcel 
{
	public static Object[][] ExcelFile(String SheetName) throws IOException
	{
	String password;
	String username;	
	FileInputStream fis = new FileInputStream("C:\\JavaBasics\\WebTours\\Resources\\ExcelData.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet = wb.getSheet(SheetName);
	
	Iterator<Row> rowIterator = sheet.iterator();
	Row row = rowIterator.next();
	int rowCount;
	int cellCount;
	Object[][] data = null;

	
	while(rowIterator.hasNext())
	{
		
		Row row1 = rowIterator.next();
		rowCount = sheet.getLastRowNum();

		Iterator<Cell> cellIterator = row1.iterator();
	
		while(cellIterator.hasNext())
		{
			Cell cell = cellIterator.next();
			cellCount = row.getLastCellNum();
		    data= new Object[rowCount][cellCount];
			if(cell.getColumnIndex() == 0)
			{
			 username= cell.toString();
			 data[row1.getRowNum()][cell.getColumnIndex()] = username;
			}
			else if (cell.getColumnIndex() == 1)
			{
			password = cell.toString();
			 data[row1.getRowNum()][cell.getColumnIndex()] = password;

			}
		}
		
	}
	return data;

	}
	
}
