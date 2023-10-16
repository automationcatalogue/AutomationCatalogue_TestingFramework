package teachings.java.oops.Inheritance1;

public class B {
    int y=10;//instance variable

    void sumArrays(int a[]){
        int total = 0;
        for(int b:a){
            total = total+b;
        }
        System.out.println("Sum of All Numbers of an array is :"+total);
    }
}
