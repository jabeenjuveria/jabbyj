package ExcelNew.MyFirstXl;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;

import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;

public class inpuOutputExcel extends BasePage {
 
  @BeforeMethod
  public void launch() {
	  browserSetup("chrome", "https://www.amazon.in");
  }
  
  @Test
  public void InputOutput() throws Exception {
	  
	  FileInputStream fis=new FileInputStream("C:\\Users\\MARS\\Desktop\\MyFirstXl.xlsx");
	  FileOutputStream fos=null;
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	  XSSFSheet sheet=wb.getSheet("Catalog");
	  XSSFRow row=null;
	  XSSFCell cell=null;
	  int colNum=-1;
		row=sheet.getRow(2);
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals("DISCOUNT"));
			{
				colNum=i;
			}
		}
		
		row=sheet.getRow(7);
		//if(row==null)
			//row=sheet.createRow(2);
		
		cell=row.getCell(colNum);
		//if(cell==null)
			//cell=row.createCell(colNum);
		
		//cell.setCellValue("500");
		
		fos=new FileOutputStream("C:\\Users\\MARS\\Desktop\\MyFirstXl.xlsx");
		wb.write(fos);
		fos.close();
  }		
     
  @AfterMethod
  public void end() {
	  driver.close();
  }

}
