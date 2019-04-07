package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersTest {
  @Test
  public void f() {
	  
	  System.out.println("jdfja");
  }
  
	public static XSSFWorkbook wb;
	public static File src;
	public static  Object[][] data;
	
	@DataProvider
	public static Object[][] readData()
	{
	    src	 = new File("C:\\Users\\HP\\Downloads\\Selenium related\\Book1.xlsx");
	    System.out.println("file path");
	    
		try {
			FileInputStream fis = new FileInputStream(src);
			 System.out.println("file path taken buy input stream"); 
			try {
				wb = new XSSFWorkbook(fis);
				 System.out.println("workbook added");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			XSSFSheet sheet =  wb.getSheet("Sheet1");
			 System.out.println("get sheet");
			 int rows = sheet.getLastRowNum();
			 System.out.println("no. oof rows are: " + rows);
			 int cols = sheet.getRow(0).getLastCellNum();
			 System.out.println("no. of cols : " + cols);
			 data=new Object[rows][cols]; 
			 
			 for(int i=0;i<rows;i++)
			 {
				 for(int j=0;j<cols;j++)
				 {
					 data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				 }
			 }
			System.out.println(data[1][1]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return data;
	}
	@Test(dataProvider="readData")
	public void getData(String a, String b) {
	System.out.println("values are : " + a + " valuesss are " + b);	
	}
  
}
