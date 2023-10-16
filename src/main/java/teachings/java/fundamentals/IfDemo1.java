package teachings.java.fundamentals;

public class IfDemo1 {
    public static void main(String[] args) {
        int x=10, y=11;

        boolean test = ++x==y && y++<=5;

        if(test){
            System.out.println("I am learning core Java");
            x=20;
            System.out.println("Value of x is :"+x+" Value of y is :"+y);
        }

        System.out.println("Automation Catalogue");
        System.out.println("Value of x is  :"+x+" Value of y is :"+y);
    }
}
