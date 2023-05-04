package seleniumDemo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFromExcel {
    public static void main(String[] args) throws IOException {

        String filePath = "src/main/resources/demoSources/ExcelData/fileToRead.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet nameList = workbook.getSheet("NameList");
        //System.out.println(nameList.getRow(1).getCell(0).toString());
        int rowCount = nameList.getLastRowNum();
        int colCount = nameList.getRow(1).getLastCellNum();

        for(int i = 0; i < rowCount; i++ ) {
            XSSFRow row = nameList.getRow(i);

            for (int j = 0; j < colCount; j++) {

                XSSFCell cell = row.getCell(j);

                switch (cell.getCellType()) {
                    case STRING:
                        System.out.printf("|%15s",cell.getStringCellValue()+" ");
                        break;
                    case NUMERIC:
                        System.out.printf("|%15s",cell.getNumericCellValue()+" ");
                        break;
                    case BOOLEAN:
                        System.out.printf("|%15s",cell.getBooleanCellValue()+" ");
                        break;
                    case FORMULA:
                        System.out.printf("|%15s",cell.getRawValue()+" ");
                }
            }
            System.out.println();
        }

        fis.close();

    }
}
