package utils;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    public static Object[][] getData() throws Exception {

        FileInputStream fis =
            new FileInputStream("TestData/LoginData.xlsx");

        XSSFWorkbook workbook =
            new XSSFWorkbook(fis);

        XSSFSheet sheet =
            workbook.getSheet("Sheet1");

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows-1][cols];

        for(int i=1;i<rows;i++) {

            for(int j=0;j<cols;j++) {

                data[i-1][j] =
                    sheet.getRow(i)
                         .getCell(j)
                         .toString();
            }
        }

        workbook.close();

        return data;
    }
}