package teachings.java.oops;

public class MethodDemo {

    //instance method
    //method definition
    //method without arguments and without return type
    void cube(int x){
        int y=x*x*x;
        System.out.println("Cube of the given number is :"+y);
    }

    public static void main(String[] args) {
        System.out.println("Hello India!!!");
        MethodDemo ob1 = new MethodDemo();
        ob1.cube(5);//method call statement

        System.out.println("Core Java!!!");
        ob1.cube(6);

        System.out.println("Advanced Java!!!");
        ob1.cube(7);

    }
}
