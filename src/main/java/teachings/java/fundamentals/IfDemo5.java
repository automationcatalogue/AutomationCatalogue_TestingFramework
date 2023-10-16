package teachings.java.fundamentals;

public class IfDemo5 {
    public static void main(String[] args) {
        int x=90,y=45,z=65;

        if((x>y) || (x==y)){

            x=78;
            System.out.println("I am in the if condition");
            System.out.println("x value is: "+x);
            System.out.println("y value is: "+y);
            System.out.println("z value is: "+z);
            y=99;
            z=100;
        }



        System.out.println("After If Statement, x value is :"+x+" y value is "+y+" z value is"+z);
    }
}
