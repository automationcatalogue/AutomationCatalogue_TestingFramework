package teachings.java.oops.polymorphim;

public class C {//super class
    int x=10;//instance variable

    //instance method - method definition
    void print(int x){
        if(x%2==0){
            System.out.println("Given number is Even!!! "+x);
        }else{
            System.out.println("Given number is Odd!!! "+x);
        }
    }


    void show(){
        System.out.println("Core Java!!!");
    }

}
