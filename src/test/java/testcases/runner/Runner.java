package testcases.runner;

import Utilities.ExcelUtils;
import org.testng.annotations.BeforeSuite;

public class Runner {
    @BeforeSuite
    public void beforeSuite() throws Exception{
        String projectPath = System.getProperty("user.dir");
        ExcelUtils.setExcelFilePath(projectPath + "//TestData//Automation_TestData.xlsx");
    }
}
