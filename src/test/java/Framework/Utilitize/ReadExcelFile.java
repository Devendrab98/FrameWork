package Framework.Utilitize;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExcelFile {

    public static FileInputStream fis;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static String getCellValue(String fileName, String sheetName, int rowNo, int cellNo){

        try {
            fis = new FileInputStream(fileName);
            workbook= new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            cell = workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);

            workbook.close();

            return cell.getStringCellValue();
        } catch (Exception e) {
            return "";
        }
    }

    public static int getRowCount(String fileName,String sheetName){

        try {
            fis = new FileInputStream(fileName);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            int totalRow= sheet.getLastRowNum() +1;
            workbook.close();
            return totalRow;

        } catch (Exception e) {
            return (0);
        }
    }
    public static int getColCount(String fileName,String sheetName){

        try {
            fis = new FileInputStream(fileName);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);

            int totalCell= sheet.getRow(0).getLastCellNum();
            workbook.close();
            return totalCell;

        } catch (Exception e) {
            return (0);
        }
    }



}
