package teachings.java.fundamentals;

public class Increment_Decrement_Demo6 {
    public static void main(String args[]){
        int i=5;

        int j=(i--) + (++i) + (i--) + (--i) + (++i) + (++i) + (i--);

        System.out.println("Value of i is:"+i+" Value of j is :"+j);

    }
}
