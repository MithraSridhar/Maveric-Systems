package testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class WritetoExcel {
	@Test
	public void writedatatoexcel() throws IOException{
		try{
		FileOutputStream out = 
				new FileOutputStream(new File("./data/write.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sample sheet");
		//Create a new row in current sheet
		Row row = sheet.createRow(0);
		//Create a new cell in current row
	Cell cell = row.createCell(0);
		//Set value to new value
		cell.setCellValue("Blahblah");
		
		
		workbook.write(out);
		out.close();
		System.out.println("Excel written successfully..");	
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

}
}