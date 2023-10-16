package teachings.java.oops;

public class DemoE {

    DemoE(){//default constructor
        System.out.println("I am in Constructor!!!");
        int x=5;
        int y=x*x*x;
        System.out.println("Cube of the number is :"+y);
    }

    DemoE(int a, int b){//Parameterized Constructor
        this();
        int c=a+b;
        System.out.println("Addition of a,b is :"+c);
    }

    DemoE(int a, int b, int c){

    }

    public static void main(String[] args) {
        DemoE ob1 = new DemoE(10,20);
    }


}
