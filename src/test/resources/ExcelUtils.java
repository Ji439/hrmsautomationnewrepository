package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtils {
	
	
	 static XSSFWorkbook workbook;
	    static XSSFSheet sheet;

	    public static Object[][] getExcelData() throws Exception {

	        FileInputStream file =
	                new FileInputStream("LoginData.xlsx");

	        workbook = new XSSFWorkbook(file);

	        sheet = workbook.getSheet("Sheet1");

	        int rowCount = sheet.getPhysicalNumberOfRows();

	        int colCount = sheet.getRow(0).getLastCellNum();

	        Object data[][] = new Object[rowCount - 1][colCount];

	        for (int i = 1; i < rowCount; i++) {

	            for (int j = 0; j < colCount; j++) {

	                data[i - 1][j] =
	                        sheet.getRow(i).getCell(j).toString();
	            }
	        }

	        workbook.close();

	        return data;
	    }
	}


