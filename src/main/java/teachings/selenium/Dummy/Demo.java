package teachings.selenium.Dummy;

public class Demo {
    int x=10;//instance variable
    static int y=20;//class variable

    public static void main(String[] args) {
        int z=30;//Local variable

        Demo ob1 = new Demo();
        ob1.x =ob1.x*2;
        System.out.println("Value of x is :"+ob1.x);

        y=y*3;
        System.out.println("Value of y is :"+Demo.y);

        z=z*4;
        System.out.println("Value of z is :"+z);
    }
}
