package teachings.java.fundamentals;

public class Increment_Decrement_Demo_5 {
    public static void main(String[] args) {
        int a=45;
        int b = (a--) + (a--);

        System.out.println("Value of a is :"+a+" Value of b is :"+b);

        int x=5;
        int y=(x++) + (++x) + (--x);

        System.out.println("Value of x is :"+x+" value of Y is:"+y);



    }
}
