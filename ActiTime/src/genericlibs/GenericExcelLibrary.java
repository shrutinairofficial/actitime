package genericlibs;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class GenericExcelLibrary
{
	public static String getValue(String path, String sheetName, int r, int c)
	{
		String value="";
		try
		{
			FileInputStream fin = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fin);
			value=wb.getSheet(sheetName).getRow(r).getCell(c).getStringCellValue();
		}
		catch(IOException e)
		{
				Reporter.log("Not able to read data", true);
		}
		return value;
	}
}