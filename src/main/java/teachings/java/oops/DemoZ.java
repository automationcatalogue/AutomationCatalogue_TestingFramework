package teachings.java.oops;

public class DemoZ {
    public static void main(String[] args) {
        MethodDemo1.evenOdd(15);

        MethodDemo ob1 = new MethodDemo();
        ob1.cube(9);

        Test1 ob2 = new Test1();
        ob2.evenOdd();

        Test ob3 = new Test();
        System.out.println(ob3.x);

        System.out.println(Test.y);
    }
}
