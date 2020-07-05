package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author <H1>Sarang<H1>
 * <H1>This class help to read data from excel file<H1>
 *
 */
public class ExcelUtil {

//	public static Workbook book;
//	public static Sheet sheet;
//
//	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"./src/test/resources/testdata/amazonTestData.xlsx";
//
//	/**
//	 * <H1>This method will return a two dimensional Object array which can be used<H1>
//	 * <p>with data provider<p>
//	 * @param String sheet name inside the excel file
//	 * @return Object[][]
//	 */
//	public static Object[][] getTestData(String sheetName) {
//		
//		// fetch the data from excel sheet
//		FileInputStream file = null;
//
//		try {
//			file = new FileInputStream(TESTDATA_SHEET_PATH);
//		} catch (FileNotFoundException e) {
//			System.out.println("Excel file not found at specifed path with variable \"TESTDATA_SHEET_PATH\"");
//			e.printStackTrace();
//		}
//
//		try {
//			book = WorkbookFactory.create(file);
//		} catch (InvalidFormatException e) {
//			System.out.println("Invalid format of the file found please provide valid excel file format");
//			e.printStackTrace();
//		} catch (IOException e) {
//			System.out.println("IOException occured while fetching the excel file");
//			e.printStackTrace();
//		}
//
//		sheet = book.getSheet(sheetName);
//
//		// fetching data from excel sheet and storing into object array by itrations
//		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
//
//		for (int i = 0; i < sheet.getLastRowNum(); i++) {
//			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
//				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//			}
//		}
//		return data;
//	}

}
