package teachings.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWriteDemo {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(projectPath+"//TestData//Automation_TestData.xlsx");
        XSSFWorkbook wbk = new XSSFWorkbook(fis);
        XSSFSheet sh = wbk.getSheet("Demo_MultipleProducts");
        XSSFRow row = sh.getRow(3);
        if(row==null){
            row = sh.createRow(3);
        }

        XSSFCell cell = row.getCell(9);
        if(cell==null){
            cell = row.createCell(9);
        }
        String orderNumber="99823987";
        cell.setCellValue(orderNumber);

        FileOutputStream fos = new FileOutputStream(projectPath+"//TestData//Automation_TestData.xlsx");
        wbk.write(fos);
        fos.close();
        fis.close();
    }
}
