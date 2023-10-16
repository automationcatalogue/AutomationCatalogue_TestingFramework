package teachings.java.oops.polymorphim;

public class A {
    //instance method - method definition
    void show(int x){
        int y=x*x*x;
        System.out.println("Cube of the given number is :"+y);
    }

    //instance method - method definition
    void print(int x){
        if(x%2==0){
            System.out.println("Given number is Even!!!");
        }else{
            System.out.println("Given number is Odd!!!");
        }
    }
}
