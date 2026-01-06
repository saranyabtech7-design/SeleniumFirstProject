package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import testCases.BaseClassMethod;

public class ExcelUtils extends BaseClassMethod {


	public static Object[][] getData(String excelPath, String sheetName) throws IOException 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		FileInputStream fis=new FileInputStream(excelPath);
		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {
			XSSFSheet sh=wb.getSheet(sheetName);
			int rows=sh.getPhysicalNumberOfRows(); //Return no.of defined rows present in the sheet
			int cols=sh.getRow(0).getLastCellNum(); //Get the first row from the sheet and In this row, it gets you the no. of columns in it
			Object[][] data=new Object[rows-1][3];
			for(int i=1;i<rows;i++)
			{
				XSSFRow row=sh.getRow(i);
				for(int j=0;j<cols;j++)
				{
					//As excel takes the input number as decimal one, we are converting double to long and then to String
					/*double numericValue=sh.getRow(i).getCell(j).getNumericCellValue();
					long longValue=(long) numericValue; // remove decimal part
					data[i-1][j]=String.valueOf(longValue);*/
					//Column 1
				 // Column 0 -> InputNo (numeric)
				XSSFCell cell = row.getCell(j);
				if (cell == null) {
				    data[i - 1][j] = null;
				} else if (cell.getCellType() == CellType.STRING) {
				    data[i - 1][j] = cell.getStringCellValue();
				} else if (cell.getCellType() == CellType.NUMERIC) {
				    if (j == 2) { // Excel Row column
				        data[i - 1][j] = (int) cell.getNumericCellValue(); // pass as int
				    } else {
				        data[i - 1][j] = String.valueOf((long) cell.getNumericCellValue()); //Need to check
				    }
				}
                
				}
			}
			return data;
		}
	}
	
	public static void writeData(String filePath,String sheetName,int rowNum,int colNum,String value) throws IOException
	{
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		
		XSSFRow row=sheet.getRow(rowNum);
		if(row==null)
		{
			row=sheet.createRow(rowNum);
		}
		XSSFCell cell=row.getCell(colNum);
		if(cell==null)
		{
			cell=row.createCell(colNum);
		}
			cell.setCellValue(value);
			fis.close();
		
			FileOutputStream fos=new FileOutputStream(filePath);
			workbook.write(fos);
			workbook.close();
			fos.close();
		}
}
