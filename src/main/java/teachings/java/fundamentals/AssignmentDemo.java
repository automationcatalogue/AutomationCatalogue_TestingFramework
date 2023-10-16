package teachings.java.fundamentals;

public class AssignmentDemo {
    public static void main(String[] args) {
        int i=9, j=3, k=4;
        i+=10;
        j-=i;
        System.out.println("Value of i is :"+i+" value of j is:"+j);

        int a=10, b=45;
        b+=a;
        System.out.println("Value of a is :"+a+" Value of b is :"+b);//10,55

        a-=b;
        System.out.println("Value of a is :"+a+" Value of b is :"+b);//-45, 55

        int c=(a*=3);
        System.out.println("Value of a is :"+a+" Value of b is :"+b+" Value of c is :"+c);//-135, 55, -135

        c/=10;
        System.out.println("Value of c is :"+c);

        b%=c;
        System.out.println("Value of a is :"+a+" Value of b is :"+b+" Value of c is :"+c);//-135, -3, -13

    }
}
