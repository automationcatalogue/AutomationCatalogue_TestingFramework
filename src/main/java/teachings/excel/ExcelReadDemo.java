package teachings.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelReadDemo {
    public static void main(String[] args) throws Exception{
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path is : "+projectPath);
        FileInputStream fis = new FileInputStream(projectPath+"//TestData//Automation_TestData.xlsx");
        XSSFWorkbook wbk = new XSSFWorkbook(fis);
        XSSFSheet sh = wbk.getSheet("HRM_AddUser");
        int rowCount = sh.getLastRowNum();
        System.out.println("Total Number of Rows is "+rowCount);

        XSSFRow row = sh.getRow(1);
        XSSFCell cell = row.getCell(4);
        String data = cell.getStringCellValue();
        System.out.println("Data from Excel file is :"+data);

        String data1 = sh.getRow(2).getCell(1).getStringCellValue();
        System.out.println("Data1 from Excel file is :"+data1);

    }
}
