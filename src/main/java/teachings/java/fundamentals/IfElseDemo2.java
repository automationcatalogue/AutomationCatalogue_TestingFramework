package teachings.java.fundamentals;

public class IfElseDemo2 {
    public static void main(String[] args) {

        int a=-99;

        if(a>=0){
            a=156;
            System.out.println("a is Negative number :"+a);
        }else{
            System.out.println("a is positive number :"+a);
            a=278;
        }

        System.out.println("Final Value of a is :"+a);
    }
}
