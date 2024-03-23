package Utilities;

public class Config {

    public static int explicitTimeOut = 40;

    public static final String orangeHRM_URL = "https://testautomate0-trials712.orangehrmlive.com";
    public static final String demoWebShop_URL = "https://demowebshop.tricentis.com";
    public static final String demoWebShopLogin_URL = "https://demowebshop.tricentis.com/login";

    public static final String testID_HRMLogin="TC01-01";
    public static final String testID_HRMAddUser="TC02-01";
    public static final String testID_HRMReports="TC03-01";
    public static final String testID_HRMLeave="TC04-01";
    public static final String testID_HRM_Performance="TC05-01";
    public static final String testID_HRM_Nationality="TC06-01";
    public static final String testID_Demo_Registration="TC07-01";
    public static final String testID_Demo_CreateAddress="TC08-01";
    public static final String testID_Demo_TotalOrders = "TC09-01";
    public static final String testID_DemoMultipleProducts="TC10-05";
    public static final String testID_DEMOApplyDiscount="TC11-05";
    public static final String testID_Demo_PlaceOrder="TC12-05";

    //Common
    public static final int col_TestcaseID=0;
    public static final int col_TestcaseName=1;
    public static final int col_UserName=2;
    public static final int col_Password=3;

    //HRMAddUser
    public static final int col_EmployeeName=4;
    public static final int col_CreateUserName=5;
    public static final int col_SupervisorRole=6;
    public static final int col_AdminRole=7;
    public static final int col_NewUserPassword=8;
    public static final int col_NewUserConfirmPassword=9;

    //HRMReports
    public static final int col_ReportType=4;
    public static final int col_FolderType=5;
    public static final int col_ReportName=6;
    public static final int col_DisplayFields=7;

    //DemoWebShop-Apply Discount
    public static final int col_ApplyDiscount_ProductCategory=4;
    public static final int col_ApplyDiscount_ProductName=5;
    public static final int col_ApplyDiscount_DiscountCode=6;
    public static final int col_ApplyDiscount_PaymentInformation=7;
    public static final int col_ApplyDiscount_CardHolderName=8;
    public static final int col_ApplyDiscount_CardNumber=9;
    public static final int col_ApplyDiscount_CardCode=10;


    //Create Address
    public static final int col_CreateAddress_FirstName =4;
    public static final int col_CreateAddress_LastName=5;
    public static final int col_CreateAddress_EmailAddress=6;
    public static final int col_CreateAddress_Company=7;
    public static final int col_CreateAddress_Country=8;
    public static final int col_CreateAddress_Province=9;
    public static final int col_CreateAddress_City=10;
    public static final int col_CreateAddress_Address1=11;
    public static final int col_CreateAddress_Address2=12;
    public static final int col_CreateAddress_PostalCode=13;
    public static final int col_CreateAddress_PhoneNumber=14;
    public static final int col_CreateAddress_FaxNumber=15;

    //OrangeHRM Performance
    public static final int col_Performance_EmployeeName =4;
    public static final int col_Performance_Description =5;
    public static final int col_Performance_AppraisalCycle =6;
    public static final int col_Performance_Template =7;
    public static final int col_Performance_FromDate =8;
    public static final int col_Performance_ToDate =9;
    public static final int col_Performance_DueDate =10;
    public static final int col_Performance_UserName_Employee = 11;
    public static final int col_Performance_UserName_Password = 12;
    public static final int col_Performance_UserName_ConfirmPassword = 13;

    //HRMLeave
    public static final int col_Name=4;
    public static final int col_Date=5;
    public static final int col_Workinghours=6;
    public static final int col_country=7;

    //Demo_MultipleOrders
    public static final int col_Product1Category=4;
    public static final int col_Product1Name=5;
    public static final int col_Product2Category=6;
    public static final int col_Product2Name=7;
    public static final int col_Product3Category=8;
    public static final int col_Product3Name=9;
    public static final int col_Product4Category=10;
    public static final int col_Product4Name=11;
    public static final int col_OrderID=12;

    //Nationalities
    public static final int col_Nationality_CountryName = 4;

    //Registration
    public static final int col_Registration_FirstName = 2;
    public static final int col_Registration_LastName = 3;
    public static final int col_Registration_Email = 4;
    public static final int col_Registration_Password = 5;
    public static final int col_Registration_ConfirmPassword = 6;
}

