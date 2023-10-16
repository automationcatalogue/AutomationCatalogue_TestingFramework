package teachings.java.oops.abstraction;

public class Demo1 {
    void cube(){
        int x=5;
        int y= x * x * x;
        System.out.println("Value of y is :"+y);
    }

    public static void main(String[] args) {
        Demo1 ob = new Demo1();
        ob.cube();
    }
}
