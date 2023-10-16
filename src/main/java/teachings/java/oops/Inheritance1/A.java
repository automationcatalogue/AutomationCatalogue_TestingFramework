package teachings.java.oops.Inheritance1;

final public class A {
    int x=5;//instance variable

    void checkNumber(int x){//instance method
        if(x>=0){
            System.out.println("Given number is Positive!!!");
        }else{
            System.out.println("Given number is Negative!!!");
        }
    }
}
