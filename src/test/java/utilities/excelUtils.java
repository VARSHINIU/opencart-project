package utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class excelUtils {
    String path;
    public void excelutility(String path){
        this.path=path;
    }

    // Get row count
    public static int getRowCount(String filename, String sheetname) throws IOException {
        FileInputStream file = new FileInputStream(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetname);
        int rowCount = sheet.getPhysicalNumberOfRows();
        workbook.close();
        file.close();
        return rowCount;
    }

    // Get cell count in the first row
    public static int getCellCount(String filename, String sheetname) throws IOException {
        FileInputStream file = new FileInputStream(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetname);
        int cellCount = sheet.getRow(0).getLastCellNum();
        workbook.close();
        file.close();
        return cellCount;
    }

    // Get cell data
    public static String getCellData(String filename, String sheetname, int rownum, int colnum) throws IOException {
        FileInputStream file = new FileInputStream(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetname);
        XSSFRow currentRow = sheet.getRow(rownum - 1); // Zero-based index

        String data = ""; // Declare and initialize `data`
        try {
            data=currentRow.getCell(colnum-1).toString();
//            DataFormatter formatter = new DataFormatter();
//            data = formatter.formatCellValue(currentRow.getCell(colnum - 1));
        } catch (Exception e) {
            data = "";
        }

        workbook.close();
        file.close();
        return data;
    }

    // Set cell data
    public static void setCellData(String filename, String sheetname, int rownum, int colnum, String value) throws IOException {
        FileInputStream file = new FileInputStream(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetname);
        XSSFRow row = sheet.getRow(rownum - 1);
        if (row == null) {
            row = sheet.createRow(rownum - 1);
        }
        XSSFCell cell = row.createCell(colnum - 1);
        cell.setCellValue(value);

        file.close(); // Close file input before writing output
        FileOutputStream outFile = new FileOutputStream(filename);
        workbook.write(outFile);
        outFile.close();
        workbook.close();
    }

    // Fill cell with red color
    public static void fillRed(String filename, String sheetname, int rownum, int colnum) throws IOException {
        FileInputStream file = new FileInputStream(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetname);
        XSSFRow row = sheet.getRow(rownum - 1);
        if (row == null) {
            row = sheet.createRow(rownum - 1);
        }
        XSSFCell cell = row.getCell(colnum - 1);
        if (cell == null) {
            cell = row.createCell(colnum - 1);
        }

        // Create a CellStyle with red background
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);

        file.close();
        FileOutputStream outFile = new FileOutputStream(filename);
        workbook.write(outFile);
        outFile.close();
        workbook.close();
    }
}
