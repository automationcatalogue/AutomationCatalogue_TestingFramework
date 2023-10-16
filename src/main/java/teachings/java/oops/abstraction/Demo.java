package teachings.java.oops.abstraction;

//abstract class - super class
abstract public class Demo {
    //instance method - Non abstract method
    void cube(){
        int x=5;
        int y= x * x * x;
        System.out.println("Value of y is :"+y);
    }
    //abstract method
    abstract void prime();

    abstract void show();
}
