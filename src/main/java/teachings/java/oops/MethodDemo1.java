package teachings.java.oops;

final public class MethodDemo1 {
    //instance method
    //method defintion
    //method with arguments and without return type
    final void add(int a, int b){
        int c=a+b;
        System.out.println("Addition of a,b is "+c);
    }

    //class method
    //method definition
    //method with arguments and without return type
    static void evenOdd(int x){
        if(x%2==0){
            System.out.println("Given number is Even!!!");
        }else{
            System.out.println("Given number is Odd!!!");
        }
    }
}
