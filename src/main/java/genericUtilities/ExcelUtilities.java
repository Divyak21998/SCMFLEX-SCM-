package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtilities implements IPathConstants {

	/**
	 * This method is used to read data from excel
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */

	public String readDataFromExcel(String sheetname,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(Excel_PaTh);
		Workbook wk = WorkbookFactory.create(fis);
		Sheet sheet = wk.getSheet(sheetname);
		String value = sheet.getRow(row).getCell(cell).getStringCellValue();
		return value;

	}
	public void writeDataintoExcel(String sheetname,int row,int cell,String data) throws Throwable
	{
		FileInputStream fis= new FileInputStream(Excel_PaTh);
		Workbook wk = WorkbookFactory.create(fis);
		Sheet sheet = wk.getSheet(sheetname);
		sheet.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(Excel_PaTh);
		wk.write(fos);
		wk.close();	
	}
/**
 * This method is used to get last row number
 * @param sheetname
 * @return
 * @throws Throwable
 */
	
	public int gettotalRows(String sheetname) throws Throwable
	{
		FileInputStream fis= new FileInputStream(Excel_PaTh);
		Workbook wk = WorkbookFactory.create(fis);
		Sheet sheet = wk.getSheet(sheetname);
		int count = sheet.getLastRowNum();
         return count;  

	}
	
	public HashMap<String, String> readMultipleData(String sheetname,WebDriver driver) throws Throwable {
	JavaUtilities jlib=new JavaUtilities();
	FileInputStream fis= new FileInputStream(Excel_PaTh);
	Workbook wk = WorkbookFactory.create(fis);
	Sheet sheet = wk.getSheet(sheetname);
	int count=sheet.getLastRowNum();
	HashMap<String, String> map=new HashMap<String, String>();
	for(int i=0;i<=count;i++)
	{
		String key = sheet.getRow(i).getCell(0).getStringCellValue();
		String value = sheet.getRow(i).getCell(1).getStringCellValue();
		  map.put(key, value);
	}

	return map;
	}
	   
	public Object[][] getMultipleSetofdata(String sheetname) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.Excel_PaTh);
		Workbook wk = WorkbookFactory.create(fis);
		Sheet sh = wk.getSheet(sheetname);
		int rows = sh.getPhysicalNumberOfRows();
		int cell = sh.getRow(0).getLastCellNum();
		Object obj[][]=new Object[rows][cell];
		 for (int i = 0; i <rows; i++) {
			for (int j = 0; j < cell; j++) {
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		 return obj;
	}
	}



