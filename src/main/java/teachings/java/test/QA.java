package teachings.java.test;

public class QA {
    public static void main(String[] args) {
        Demo ob1 = new Demo();
        System.out.println(ob1.a);
        System.out.println(Demo.b);

        ob1.cube();
        Demo.evenOdd();
    }
}
