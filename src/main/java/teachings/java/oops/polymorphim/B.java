package teachings.java.oops.polymorphim;

public class B extends A{
    //instance method - method definition
    void display(int x){
        if(x>=0){
            System.out.println("Given number is Positive!!!");
        }else{
            System.out.println("Given number is Negative!!!");
        }
    }

    void print(int x){
        int y=x*x;
        System.out.println("Square of the given number is :"+y);
    }
}
