package teachings.selenium.Dummy;

public class Demo3 {
    String empName = "Arun";
    static float empSalary = 9500.00f;

    //instance method
    //method definition
    //method without argument and without return type
    void getEmpData(){
        int d=9;
        int e=d*d*d;
        System.out.println("Value of e is :"+e);
    }

    //class method
    //method definition
    //method with arguments and without return type
    static void addEmpData(int x){
        empSalary=empSalary+x;
        System.out.println("Employee Salary is :"+empSalary);
    }

    //instance method
    //method definition
    //method without arguments and with return type
    float getIncreasedSalary(){
        empSalary=empSalary+99000;
        return empSalary;
    }

    //class method
    //method definition
    //method with arguments and with return type
    static int showEmpData(int x, String y){
        System.out.println(x);
        System.out.println(y);
        return x+99;
    }
}
