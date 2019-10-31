package utils.dataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {

public String exceldata(String sheetname,int rownum,int colmn) throws IOException, EncryptedDocumentException, InvalidFormatException {
	String excelpath = LoadProperty.getvar("excelfilepath", "config");
	excelpath = System.getProperty("user.dir")+excelpath;
	FileInputStream fis = new FileInputStream(excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetname);
	Row  r = sh.getRow(rownum);
	Cell c = r.getCell(colmn);
	c.setCellType(Cell.CELL_TYPE_STRING);
	String data = c.getStringCellValue();
	return data;
	}
public boolean updateExceldata(String sheetname,int rownum,int colmn,String value) throws IOException, EncryptedDocumentException, InvalidFormatException {
	try{
		String excelpath = LoadProperty.getvar("excelfilepath", "config");
	
	excelpath = System.getProperty("user.dir")+excelpath;
	FileInputStream inputStream = new FileInputStream(new File(excelpath));
    Workbook workbook = WorkbookFactory.create(inputStream);
    Sheet sheet = workbook.getSheetAt(0);
    Cell cell2Update = sheet.getRow(rownum).getCell(colmn);
    cell2Update.setCellValue(value);
    FileOutputStream outputStream = new FileOutputStream(excelpath);
    workbook.write(outputStream);
    workbook.close();
    outputStream.close();
	return true;
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		return false;
	}
}
}
