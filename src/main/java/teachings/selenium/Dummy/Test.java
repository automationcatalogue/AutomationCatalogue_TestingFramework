package teachings.selenium.Dummy;

public class Test {
    public static void main(String[] args) {
        Demo3 ob = new Demo3();
        System.out.println(ob.empName);
        System.out.println(Demo3.empSalary);

        ob.getEmpData();
        Demo3.addEmpData(5200);

        float z=ob.getIncreasedSalary();
        System.out.println(z);

        int g=Demo3.showEmpData(10,"Vivek");
        System.out.println(g);

        Demo4 ob2 = new Demo4();
    }
}
