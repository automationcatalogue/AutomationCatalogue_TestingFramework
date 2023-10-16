package teachings.java.oops;

public class EvenOddDemo {
    int x=12;

    public static void main(String[] args) {
        EvenOddDemo ob1 = new EvenOddDemo();

        if(ob1.x%2==0){
            System.out.println("Given number x is Even!!! "+ob1.x);
        }else{
            System.out.println("Given number is X is Odd!!! "+ob1.x);
        }
    }
}
