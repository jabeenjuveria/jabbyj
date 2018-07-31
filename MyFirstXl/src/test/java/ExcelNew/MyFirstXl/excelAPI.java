package ExcelNew.MyFirstXl;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;

public class excelAPI {
  
	public FileInputStream fis=null;
	public FileOutputStream fos=null;
	public XSSFWorkbook workbook=null;
	public XSSFCell cell=null;
	public XSSFSheet sheet=null;
	public XSSFRow row=null;
	String XfilePath;
	
	public excelAPI(String XfilePath) throws Exception
	{
		this.XfilePath=XfilePath;
		fis=new FileInputStream(XfilePath);
		workbook=new XSSFWorkbook(fis);
		fis.close();
		
	}
	public int getRowcount(String sheetname)
	{
		sheet= workbook.getSheet(sheetname);
		int rowCount=sheet.getLastRowNum()+1;
		return rowCount;
		
	}
	public int columnCount(String sheetname)
	{

		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(0);
		int colCount=row.getLastCellNum()+1;
		return colCount;
	}
	public String getCellData(String sheetName,int colNum,int rowNum)
	{
		try
		{
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(rowNum);
			cell=row.getCell(colNum);
			
			if(cell.getCellTypeEnum()==CellType.STRING)
		       return cell.getStringCellValue();
			else if(cell.getCellTypeEnum()==CellType.NUMERIC)
			{
                String cellValue = String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					DateFormat dt=new SimpleDateFormat("dd/mm/yyyy");
					Date date=cell.getDateCellValue();
					cellValue=dt.format(date);
				}
				return cellValue;
				}
			else if(cell.getCellTypeEnum()==CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
	}
		catch(Exception e)
		{
			e.printStackTrace();
			return "No matching value";
		}
		
	}
	
	//Reading cell data from Excel by using Column Name
		public String getCellData(String sheetName,String colName,int rowNum)
		{
			try
			{
				int colNum=-1;
				sheet=workbook.getSheet(sheetName);
				row=sheet.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++)
				{
					if(row.getCell(i).getStringCellValue().trim().equals(colName))
						colNum=i;
				}
				
				row=sheet.getRow(rowNum);
				cell=row.getCell(colNum);
				
				if(cell.getCellTypeEnum()==CellType.STRING)
					return cell.getStringCellValue();
				else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA)
				{
					String cellValue = String.valueOf(cell.getNumericCellValue());
					if(HSSFDateUtil.isCellDateFormatted(cell))
					{
						DateFormat dt=new SimpleDateFormat("dd/mm/yyyy");
						Date date=cell.getDateCellValue();
						cellValue=dt.format(date);	
					}
					return cellValue;
				}
				else if(cell.getCellTypeEnum()==CellType.BLANK)
					return "";
				else
					return String.valueOf(cell.getBooleanCellValue());
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return "No matching value";
			}
		}
			//Writing cell data to Excel by using Column Number
			public boolean setCellData(String sheetname,int colNum,int rowNum,String value)
			{
				
				try
				{
					sheet=workbook.getSheet(sheetname);
					
					row=sheet.getRow(rowNum);
					cell=row.getCell(colNum);
			        cell.setCellValue(value);
					
					fos=new FileOutputStream(XfilePath);
					workbook.write(fos);
					fos.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					return false;
				}
				return true;
			}
			

			
			//Writing cell data to Excel by using Column Name
			public boolean setCellData(String sheetname,String colname,int rownum,String value)
			{
				
				try
				{
					int colNum=-1;
					sheet=workbook.getSheet(sheetname);
					
					row=sheet.getRow(rownum);
					for(int i=0;i<row.getLastCellNum();i++)
					{
						if(row.getCell(i).getStringCellValue().trim().equals(colname));
						{
							colNum=i;
						}
					}
					row=sheet.getRow(rownum-1);
					//if(row==null)
						//row=sheet.createRow(rowNum-1);
					
					cell=row.getCell(colNum);
					//if(cell==null)
						//cell=row.createCell(colNum);
					
					cell.setCellValue(value);
					
							
					fos=new FileOutputStream(XfilePath);
					workbook.write(fos);
					fos.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
					return false;
				}
				return true;
			}
			
		
		
  @BeforeMethod
  public void beforeMethod() {
  }

  @Test
  public void f() {
  }
  
  @AfterMethod
  public void afterMethod() {
  }

}
