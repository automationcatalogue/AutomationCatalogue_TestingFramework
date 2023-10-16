package teachings.java.oops;

public class VarDemo4 {
    public static void main(String[] args) {
        Test ob1 = new Test();
        System.out.println("Value of x is "+ob1.x);

        int cube = ob1.x * ob1.x * ob1.x;
        System.out.println("Cube of the given number is :"+cube);

        System.out.println("Value of y is :"+Test.y);
        if(Test.y%2==0){
            System.out.println("Given number is Even!!!"+Test.y);
        }else{
            System.out.println("Given number is Odd!!!"+Test.y);
        }
    }
}
