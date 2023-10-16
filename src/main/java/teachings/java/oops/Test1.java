package teachings.java.oops;

public class Test1 {

    //instance method
    //method definition
    //method without arguments and without return type
    void evenOdd(){
        int x=12;
        if(x%2==0){
            System.out.println("Given number is Even!!!");
        }else{
            System.out.println("Given number is Odd!!!");
        }
    }

    //class method
    //method definition
    //method without arguments and without return type
    static void cube(){
        int x=5;
        int y=x * x* x;
        System.out.println("Cube of the given number is :"+y);
    }

    public static void main(String[] args) {
        int a=10, b=20;
        int c=a+b;
        System.out.println("Addition of a,b is :"+c);

        Test1 ob1 = new Test1();
        ob1.evenOdd();//method call statement

        cube();//method call statement
    }


}
