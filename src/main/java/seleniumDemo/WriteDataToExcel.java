package seleniumDemo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataToExcel {
    public static void main(String[] args) throws IOException {

        String filePath = "src/main/resources/demoSources/ExcelData/fileToWrite.xlsx";
        FileOutputStream fos = new FileOutputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet newSheet = workbook.createSheet("newSheet");
        newSheet.createRow(0).createCell(0).setCellValue("marina");

        XSSFSheet dataSheet = workbook.createSheet("dataSheet");
        Object[][] data = {
            {"fName", "lName", "age", "mobile"},
                {"fName01", "lName01", 25, "+3737801020504"},
                {"fName02", "lName02", 26, "+3737801020504"},
                {"fName03", "lName03", 27, "+3737801020504"},
                {"fName04", "lName04", 28, "+3737801020504"},
                {"fName05", "lName05", 29, "+3737801020504"}
        };

        int rowCount = data.length;
        int colCount = data[0].length;

        for(int i = 0; i < rowCount; i++) {
            XSSFRow row = dataSheet.createRow(i);
            for (int j = 0; j < colCount; j++) {
                XSSFCell cell = row.createCell(j);
                Object dataValue = data[i][j];

                if(dataValue instanceof String) {
                    cell.setCellValue((String)dataValue);
                } else if (dataValue instanceof Integer) {
                    cell.setCellValue((Integer)dataValue);
                }
            }
        }


        workbook.write(fos);
        fos.close();

    }
}
