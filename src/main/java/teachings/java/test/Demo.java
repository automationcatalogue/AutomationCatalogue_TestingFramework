package teachings.java.test;

public class Demo {
    int a=10;
    static int b=20;

    protected void cube(){
        int x=5;
        int y=x*x*x;
        System.out.println("Value of y is :"+y);
    }

    protected static void evenOdd(){
        int x=10;
        if(x%2==0){
            System.out.println("Given number is Even!!!");
        }else{
            System.out.println("Given number is Odd!!!");
        }
    }

    public static void main(String[] args) {
        Demo ob1 = new Demo();
        System.out.println(ob1.a);
        System.out.println(Demo.b);

        ob1.cube();
        Demo.evenOdd();
    }



}
