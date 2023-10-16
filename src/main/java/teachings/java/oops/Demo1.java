package teachings.java.oops;


public class Demo1 {
    int a=10;//instance variable
    static int b=20;//class variable

    public static void main(String[] args) {
        int c=30;//Local variable

        Demo1 ob1 = new Demo1();
        System.out.println(ob1.a);

        System.out.println(b);

    }
}
