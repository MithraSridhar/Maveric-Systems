package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelLogin {
	@Test
	public void login() throws InvalidFormatException, IOException {

		XSSFWorkbook wbook = new XSSFWorkbook(new File("./data/TC003.xlsx"));
		XSSFSheet sheet1 = wbook.getSheet("Sheet1");
		int rowcount = sheet1.getLastRowNum();
		System.out.println(rowcount);

		for (int i = 1; i <= rowcount; i++) 
		{
			XSSFRow rowi = sheet1.getRow(i);
			int colcount = sheet1.getRow(i).getLastCellNum();
			System.out.println(colcount);
			for (int j = 0; j < colcount; j++) 
			{
				XSSFCell cellj = rowi.getCell(j);
				System.out.println(cellj.getStringCellValue());
			}

		}

	}

}