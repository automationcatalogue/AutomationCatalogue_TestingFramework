package teachings.java.oops;

public class MethodDemo3 {
    public static void main(String[] args) {
        Test3 ob1 = new Test3();
        ob1.primeLogic(11);

        Test3.avgLogic(40,50,78,34,99);

        int q= ob1.factLogic();
        System.out.println("Factorial of a number is :"+q);

        int s=Test3.evenSumLogic();
        System.out.println("Sum of the Even numbers from 1 to 100 is :"+s);
    }
}
